package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlingEvents implements ActionListener {
    public static final String ADD_ACCOUNT_DEPOSIT = "Agregar Cuenta Deposito";
    public static final String ADD_ACCOUNT_CURRENT = "Agregar Cuenta Corriente";
    public static final String TRANSACTION = "Realizar Transacción";
    public static  final String EXIT = "Salir";
    private MainWindow mainWindow;

    public HandlingEvents(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case ADD_ACCOUNT_DEPOSIT: mainWindow.addAccountDeposit();
            break;

            case ADD_ACCOUNT_CURRENT: mainWindow.addAccountCurrent();
            break;

            case TRANSACTION: mainWindow.transaction();
            break;

            case EXIT: mainWindow.exit();
            break;
        }
    }
}
