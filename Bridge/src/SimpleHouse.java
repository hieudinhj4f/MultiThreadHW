public class SimpleHouse extends HouseDetail{

    public SimpleHouse(HouseDecorate decorate) {
        super(decorate);
    }

    @Override
    public void construct() {
        System.out.println("Simple House Construction:");
        System.out.println("Door: " + decorate.paintDoor());
        System.out.println("Wall: " + decorate.paintWall());
        System.out.println("Trap: " + decorate.paintTrap());
    }
}
