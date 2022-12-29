package computer;

import java.math.BigDecimal;

public class Computer {

    private BigDecimal cost;
    private String model;
    private Ram ram;
    private Hdd hdd;

    public Computer(String model, double cost, Ram ram, Hdd hdd) {
        this.cost = BigDecimal.valueOf(cost);
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
    }

    public Computer(String model, double cost) {
        this.cost = BigDecimal.valueOf(cost);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Computer #" + TestComputer.compNumber + " : " +
                "\t model = '" + model + '\'' + "\n" +
                "\t\t\t\t cost = " + cost + "\n" +
                "\t\t\t\t Ram: " + ram + "\n" +
                "\t\t\t\t Hdd: " + hdd + "\n" ;
    }
}
