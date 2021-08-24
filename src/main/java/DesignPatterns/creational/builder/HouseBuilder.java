package DesignPatterns.creational.builder;

public class HouseBuilder {
    String base;
    String wall;
    String door;
    String roof;

    public HouseBuilder buildBase(String base) {
        this.base = base;
        return this;
    }

    public HouseBuilder buildWall(String wall) {
        this.wall = wall;
        return this;
    }

    public HouseBuilder buildDoor(String door) {
        this.door = door;
        return this;
    }

    public HouseBuilder buildRoof(String roof) {
        this.roof = roof;
        return this;
    }

    public House build(){
        return new House(this);
    }
}
