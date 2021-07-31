package run;

import model.ManagementSale;
import model.Sale;

import javax.swing.*;
import java.awt.font.NumericShaper;

public class Runner {
    private ManagementSale mngSale;

    public Runner(){
        mngSale = new ManagementSale();
    }

    public static void main(String[] args) {
        new Runner().mainMenu();
    }

    private void mainMenu() {
        String menu = "<<<<MENU PRINCIPAL>>>>\n\n" +
                "1) Adicionar Venta\n" +
                "2) Buscar Venta\n" +
                "3) Listar Ventas\n" +
                "4) Totalizar Ventas\n\n" +
                "5) Salir";
        char option = '0';
        do{
            try{
                option = JOptionPane.showInputDialog(null,menu).charAt(0);

                switch(option){
                    case '1' : addSale();
                        break;

                    case '2' : findSale();
                        break;

                    case '3' : listSales();
                        break;

                    case '4' : totallySales();
                        break;
                }
            }catch ( NullPointerException | StringIndexOutOfBoundsException e ){
                JOptionPane.showMessageDialog(null, "Debe indicar una Opcion","Error",JOptionPane.ERROR_MESSAGE);
            }

        }while(option != '5');
    }

    private void totallySales() {
        //TODO Visualizar el Total de las ventas (llamar al método correspondiente)
    }

    private void listSales() {
        //TODO Visualizar la información de las ventas (Recuperando el arreglo e iterando sobre él)
    }

    private void addSale() {
        try{
            String id = JOptionPane.showInputDialog("Digite el ID de la Venta");

            if(mngSale.findSale(id) == null){
                String name = JOptionPane.showInputDialog("Digite el Nombre del Producto");

                double value = Double.parseDouble( JOptionPane.showInputDialog( "Valor del Producto"));
                short amount = Short.parseShort(JOptionPane.showInputDialog("Cantidad Vendida"));
                char iva = JOptionPane.showInputDialog("IVA [S/N]").toUpperCase().charAt(0);
                boolean isIva = iva == 'S' ? true : false;

                mngSale.addSale( id,name,value,amount, isIva);
            }else{
                JOptionPane.showMessageDialog(null,"Error, Venta ya Registrada","Resultado",JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor no Valido","Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void findSale() {
        //TODO Leer el Id de la venta, usar el método findSale() y visualizar la información
        //de la venta si existe, si no existe, visualizar mensaje de Error
    }
}
