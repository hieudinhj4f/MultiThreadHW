public class DecorateFully implements HouseDecorate{
    @Override
    public boolean paintDoor() {
        return true;
    }

    @Override
    public boolean paintWall() {
        return true;
    }

    @Override
    public boolean paintTrap() {
        return true;
    }
    @Override
    public void Result(){
        System.out.println("Your home construction is  PaintDoor + PaintWall + paintTrap");
    }
}
