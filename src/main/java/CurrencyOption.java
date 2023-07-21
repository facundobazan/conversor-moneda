import javax.swing.*;
import java.awt.event.*;

public class CurrencyOption extends JDialog {
    private String[] currencies = {"Selecciona una opción", "Pesos Argentinos", "Dolar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won"};
    private JPanel contentPane;
    private JButton btnContinuar;
    private JButton btnCancelar;
    private JComboBox cboMonedaOrigen;
    private JComboBox cboMonedaDestino;
    private JButton btnReiniciar;

    public CurrencyOption() {
        contentPane.setSize(300,160);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnContinuar);
        rellenarCbo(cboMonedaOrigen);
        rellenarCbo(cboMonedaDestino, cboMonedaOrigen.getSelectedItem().toString());


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
                System.exit(0);
            }
        });
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboMonedaOrigen.getSelectedIndex() != -1 || cboMonedaDestino.getSelectedIndex() != -1) {
                    System.out.println("ok");
                } else {
                    System.out.println("indice 0");
                }
            }
        });
        cboMonedaOrigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cboMonedaOrigen.getSelectedIndex() > 0) {
                    rellenarCbo(cboMonedaDestino, cboMonedaOrigen.getSelectedItem().toString());
                }
                cboMonedaOrigen.setEnabled(false);
                cboMonedaDestino.setEnabled(true);
            }
        });
        cboMonedaDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setearBotones();
            }
        });
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setearBotones();
                rellenarCbo(cboMonedaOrigen);
                rellenarCbo(cboMonedaOrigen, cboMonedaDestino.getSelectedItem().toString());
                cboMonedaOrigen.setEnabled(true);
                cboMonedaDestino.setEnabled(false);

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

    public static void main(String[] args) {
        CurrencyOption dialog = new CurrencyOption();
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void rellenarCbo(JComboBox cbo) {
        for (String currency : currencies) cbo.addItem(currency);
    }

    private void rellenarCbo(JComboBox cbo, String valorExcluido) {
        cbo.removeAllItems();
        for (String currency : currencies) {
            if (!currency.equals(valorExcluido)) cbo.addItem(currency);
        }
    }

    private void setearBotones(){
        btnReiniciar.setEnabled(!btnReiniciar.isEnabled());
        btnContinuar.setEnabled(!btnContinuar.isEnabled());
    }
}
