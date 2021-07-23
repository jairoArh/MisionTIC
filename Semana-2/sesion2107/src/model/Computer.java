package model;

/*
Clase que define las características de un Computador
 */
public class Computer {
    //Id del Computador
    private String idComputer;

    //Marca del Computador
    private String brand;

    //Valor del Computador
    private double value;

    //Estado que indica si esta prendido o apagado
    private boolean state;

    //Cuando no hay contructor en la clase, se toma por defecto uno vacío.

    public Computer() {
    }

    /***
     * Constructor que recibe los valores de los atributos
     * @param idComputer
     * @param brand
     * @param value
     */
    public Computer(String idComputer, String brand, double value){
        this.idComputer = idComputer;
        this.brand = brand;
        this.value = value;
        state = false;
    }

    /***
     * Método que retorna el id del Computador
     * @return String
     */
    public String getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(String idComputer) {
        this.idComputer = idComputer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "idComputer='" + idComputer + '\'' +
                ", brand='" + brand + '\'' +
                ", value=" + value +
                ", state=" + state +
                '}';
    }
}
