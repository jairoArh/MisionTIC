package view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar {
    private JMenu account;

    private JMenuItem itemAddDeposit;
    private JMenuItem itemAddCurrent;
    private JMenuItem itemTransactions;
    private JMenuItem exit;


    private MainWindow mainWindow;

    public MainMenu(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        beginComponents();
        addComponents();
    }

    private void addComponents() {
        account.add( itemAddDeposit);
        account.add( itemAddCurrent);
        account.add( itemTransactions);
        account.addSeparator();
        account.add( exit );

        add( account );
    }

    private void beginComponents() {
        account = new JMenu("Cuenta");

        itemAddDeposit = new JMenuItem("Agregar Cuenta Deposito");
        itemAddDeposit.setMnemonic('C');
        itemAddDeposit.setIcon( new ImageIcon("resources/icons/deposit.png"));
        itemAddDeposit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK,false));
        itemAddDeposit.setActionCommand( HandlingEvents.ADD_ACCOUNT_DEPOSIT );
        itemAddDeposit.addActionListener( new HandlingEvents( mainWindow ) );

        itemAddCurrent = new JMenuItem("Agregar Cuenta Corriente");
        itemAddCurrent.setMnemonic('R');

        itemTransactions = new JMenuItem("Transacion");
        itemTransactions.setMnemonic('T');

        exit = new JMenuItem("Salir");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK,false));
        exit.setActionCommand( HandlingEvents.EXIT);
        exit.addActionListener( new HandlingEvents(mainWindow));

    }
}
