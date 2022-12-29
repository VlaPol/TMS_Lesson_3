package computer;

public class Hdd {

     private String model;
     private String volume;
     HddType type;

    public Hdd() {
        this.model = "unknow manufacture";
        this.type = HddType.UNKNOWN;
    }

    public Hdd(String model, String volume, HddType type) {
        this.model = model;
        this.volume = volume;
        this.type = type;
    }

    @Override
    public String toString() {
        return "\tmodel = '" + model + '\'' +"\n" +
                "\t\t\t\t\t\tvolume = " + volume +"\n" +
                "\t\t\t\t\t\ttype = " + type;
    }
}

enum HddType {
    INNER,
    OUTER,
    UNKNOWN
}
