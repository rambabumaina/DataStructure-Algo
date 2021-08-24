package DesignPatterns.creational.builder;

/**
 * 
 */
public class BuilderTest {
    public static void main(String[] args) {
        House house = new HouseBuilder().buildBase("base").buildWall("wall").buildDoor("door").buildRoof("roof").build();
        System.out.println(house);
    }
}
