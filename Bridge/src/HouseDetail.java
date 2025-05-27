public abstract class HouseDetail {
    protected HouseDecorate decorate;

    public HouseDetail(HouseDecorate decorate) {
        this.decorate = decorate;
    }
    public abstract void construct();
}
