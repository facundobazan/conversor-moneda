import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    protected String[] conversionOptions = {"Divisas", "Temperaturas", "Medidas"};
    private JComboBox cboConverter;
    private JButton btnAccept;
    private JButton btnCancel;
    protected JPanel panel;

    public MainForm() {
        btnAccept.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //conversionOptions = new String[]
        cboConverter = new JComboBox(conversionOptions);

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

                }

            }
        });
    }

    public static void main(String[] args) {
        /*
        MainForm mf = new MainForm();
        mf.setContentPane(new MainForm().panel);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setResizable(false);


        mf.setVisible(true);
        mf.pack();
        */
    }
}
