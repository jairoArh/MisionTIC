package logic;

public class Customer {

    private String nit;
    private String name;
    private String LastName;
    private int minResidue;
    private String city;
    private String Phone;

    public Customer(String nit, String name, String lastName, int minResidue, String city, String phone) {
        this.nit = nit;
        this.name = name;
        LastName = lastName;
        this.minResidue = minResidue;
        this.city = city;
        Phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getMinResidue() {
        return minResidue;
    }

    public void setMinResidue(int minResidue) {
        this.minResidue = minResidue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nit='" + nit + '\'' +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", minResidue=" + minResidue +
                ", city='" + city + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
