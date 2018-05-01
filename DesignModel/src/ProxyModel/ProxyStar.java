package ProxyModel;

public class ProxyStar implements Star {

    private Star star;
    @Override
    public void confer() {
        System.out.println("ProxyStar confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar confer");
    }

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar confer");
    }

    @Override
    public void sing() {
       star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar confer");
    }

}
