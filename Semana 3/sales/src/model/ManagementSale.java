package model;

import java.util.ArrayList;

public class ManagementSale {
    private ArrayList<Sale> sales;

    public ManagementSale() {
        sales = new ArrayList<>();
    }

    public Sale findSale( String id ){

        for( Sale sale : sales ){
            if (sale.getIdSale().equals(id)){
                return sale;
            }
        }

        return null;
    }

    public boolean addSale(String id, String name, double value, short amount, boolean iva ){

        if( findSale( id ) == null ){
            sales.add( new Sale(id,name,value,amount,iva));

            return true;
        }

        return false;
    }

    public double totallSales(){
        double totally = 0.0;
        for( Sale sale : sales ){
            totally += sale.liquidateSale();
        }

        return totally;
    }

    public ArrayList<Sale> getSales() {
        return (ArrayList<Sale>) sales.clone();
    }
}
