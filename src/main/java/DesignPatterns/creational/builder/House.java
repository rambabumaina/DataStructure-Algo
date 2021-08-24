package DesignPatterns.creational.builder;

public class House {
    String base;
    String wall;
    String door;
    String roof;

    public House(HouseBuilder hb) {
        this.base = hb.base;
        this.wall = hb.wall;
        this.door = hb.door;
        this.roof = hb.roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "base='" + base + '\'' +
                ", wall='" + wall + '\'' +
                ", door='" + door + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
