import model.Currency;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CurrencyConverter extends JDialog {
    private JPanel contentPane;
    private JButton btnContinue;
    private JButton btnCancel;
    private JList lstCurrencyToConvert;
    private JList lstTargetCurrency;

    public CurrencyConverter() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnContinue);

        ArrayList<Currency> currency = new ArrayList<>();
        /*currency.add(new Currency("USD", "Dolar Estadounidense", 1.0035));
        currency.add(new Currency("AED", "Dírham de los Emiratos Árabes Unidos", 0.0035));
        currency.add(new Currency("ARS", "Peso Argentino", 0.0035));
        currency.add(new Currency("EUR", "Euro Eurpeo", 1.3035));*/
        lstCurrencyToConvert = new JList(currency.toArray());

        //lstCurrencyToConvert.add();

        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
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

    public static void main(String[] args) {
        CurrencyConverter dialog = new CurrencyConverter();
        dialog.pack();
        dialog.setResizable(false);
        dialog.setVisible(true);
        System.exit(0);
    }
}
