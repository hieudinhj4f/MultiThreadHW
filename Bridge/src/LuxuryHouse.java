public class LuxuryHouse extends HouseDetail {

    public LuxuryHouse(HouseDecorate decorate) {
        super(decorate);
    }

    @Override
    public void construct() {
        System.out.println("Luxury House Construction:");
        System.out.println("Door: " + decorate.paintDoor());
        System.out.println("Wall: " + decorate.paintWall());
        System.out.println("Trap: " + decorate.paintTrap());
    }
}
