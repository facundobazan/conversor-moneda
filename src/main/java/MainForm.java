import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainForm extends JFrame{
    private JComboBox cboConverter = new JComboBox();
    private JButton btnAccept;
    private JButton btnCancel;
    protected JPanel panel;

    public MainForm() {
        btnAccept.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cboConverter.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cboConverter.addItem("Seleccione una opción");
        cboConverter.addItem("Divisas");
        cboConverter.addItem("Temperaturas");
        cboConverter.addItem("Medidas");

        panel = new JPanel();
        panel.add(cboConverter);
        panel.add(btnAccept);
        panel.add(btnCancel);

        panel.setSize(350, 200);



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
                System.out.printf(cboConverter.getSelectedItem().toString());
                switch (cboConverter.getSelectedItem().toString()){
                    case "Divisas":

                }

            }
        });
    }

    public static void main(String[] args) {
        MainForm mf = new MainForm();
        mf.setContentPane(new MainForm().panel);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setResizable(false);

        mf.setVisible(true);
        mf.pack();
    }
}
