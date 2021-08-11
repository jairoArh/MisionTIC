package view;

import javax.swing.*;
import java.awt.*;

public class PanelTransactions extends JPanel {
    private MainWindow mainWindow;
    private JComboBox<String> numberAccounts;
    private JRadioButton deposit;
    private JRadioButton withDraw;
    private JTextField value;
    private JButton accept;

    public PanelTransactions(MainWindow mainWindow){
        this.mainWindow = new MainWindow();
        setLayout(new GridLayout(5,2));
        beginComponents();
        addComponents();
    }

    private void addComponents() {
        add(new JLabel("Consignar/Retirar"));
        add(new JLabel());
        add(new JLabel("Numero Cuenta"));
        add( numberAccounts );

        ButtonGroup group = new ButtonGroup();
        group.add( deposit );
        group.add( withDraw);

        add(new JLabel("Tipo Transacción"));

        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(2,2));
        panel.add(new JLabel("Consignar"));
        panel.add(deposit);
        panel.add(new JLabel("Retirar"));
        panel.add(withDraw);

        add(panel);

        add(new JLabel("Valor"));
        add( value );
        add(accept);
    }

    private void beginComponents() {
        numberAccounts = new JComboBox<>();

        deposit = new JRadioButton();
        deposit.setSelected( true );
        withDraw = new JRadioButton();

        value = new JTextField();
        accept = new JButton("Confirmar");
    }

    public void addNumberAccount(String number){
        numberAccounts.addItem( number );
    }
}
