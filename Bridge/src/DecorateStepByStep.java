public class DecorateStepByStep implements HouseDecorate{
    private int TimeEachStep = 5;
    @Override
    public boolean paintDoor() {
        return false;
    }

    @Override
    public boolean paintWall() {
        return false;
    }

    @Override
    public boolean paintTrap() {
        return false;
    }
    @Override
    public void Result(){
        System.out.println("Your home construction is  PaintDoor => PaintWall => paintTrap");
    }
}
