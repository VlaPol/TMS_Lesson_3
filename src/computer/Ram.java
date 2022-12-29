package computer;

public class Ram {
    private String name;
    private int volume;

    public Ram() {
        this.name = "unknown manufacture";
    }

    public Ram(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return  "\tname = '" + name + '\'' + "\n" +
                "\t\t\t\t\t\tvolume = " + volume;
    }
}
