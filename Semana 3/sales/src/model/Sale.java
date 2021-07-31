package model;

public class Sale {
    private String idSale;
    private String product;
    private double valueProduct;
    private short amount;
    private boolean iva;

    //Definición de una constante
    public static final float IVA = 0.19F;

    public Sale(String idSale, String product, double valueProduct, short amount, boolean iva) {
        this.idSale = idSale;
        this.product = product;
        this.valueProduct = valueProduct;
        this.amount = amount;
        this.iva = iva;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(double valueProduct) {
        this.valueProduct = valueProduct;
    }

    public short getAmount() {
        return amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    private double calculateDiscount() {

        double subtotal = valueProduct * amount;

        if( subtotal > 0 && subtotal <= 10_000 ) {

            return subtotal * 0.05;
        }else if( subtotal > 10_000 && subtotal <= 20_000 ) {

            return subtotal * 0.1;
        }else if(subtotal > 20_000 && subtotal <= 50_000 ) {

            return subtotal * 0.15;
        }else if( subtotal > 50_000 && subtotal <= 100_000 ) {

            return subtotal * 0.2;
        }else if( subtotal > 100_000){
            return subtotal * 0.3;
        }

        return 0.0;

    }

    public double liquidateSale() {

        return valueProduct * amount - calculateDiscount() + calcIVA();
    }

    public double calcIVA() {

        return isIva() ? valueProduct * amount * IVA : 0.0;

    }
}
