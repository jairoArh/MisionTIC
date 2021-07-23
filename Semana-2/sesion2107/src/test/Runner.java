package test;

import model.Computer;

public class Runner {
    public static void main(String[] args) {
        Computer acer = new Computer("435324","Acer Aspire",890000);

       // acer.setState( true );

        System.out.printf("El Computador %s %s\n", acer.getIdComputer(), acer.isState() ? " Esta Prendido" : " Esta Apagado");

        Computer asus = new Computer();

        System.out.println( acer );
    }
}
