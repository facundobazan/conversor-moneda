import api.ExchangerateApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm extends JFrame {
    private  JPanel contentPane = new JPanel();
    private JComboBox cboConverter = new JComboBox();
    private JButton btnAccept;
    private JButton btnCancel;


    public MainForm() {
        this.setSize(350, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAccept.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cboConverter.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cboConverter.addItem("Seleccione una opción");
        cboConverter.addItem("Divisas");
        cboConverter.addItem("Temperaturas");
        cboConverter.addItem("Medidas");

        contentPane.add(cboConverter);
        contentPane.add(btnAccept);
        contentPane.add(btnCancel);

        this.setContentPane(contentPane);

        contentPane.setSize(350, 200);
        this.setResizable(false);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        cboConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAccept.setEnabled(cboConverter.getSelectedIndex() > 0);
            }
        });

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.printf(cboConverter.getSelectedItem().toString());
                switch (cboConverter.getSelectedItem().toString()) {
                    case "Divisas":
                        System.out.println("divisas");
                        asd();
                        break;
                    case "Temperaturas":
                        System.out.println("Temperaturas");
                        break;
                    case "Medidas":
                        System.out.println("Medidas");
                        break;

                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        MainForm mf = new MainForm();
        //mf.setContentPane(new MainForm().panel);
        //mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mf.setVisible(true);
        //mf.pack();

        ExchangerateApi currencyService = new ExchangerateApi();

        //System.out.println(currencyService.getConvertion(100.0, "USD", "ARS"));

    }

    public void asd(){
        CurrencyOption currencyOption = new CurrencyOption();
        //currencyOption.setContentPane(this);
        currencyOption.setVisible(true);
    }
}
