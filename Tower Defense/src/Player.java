public  class Player {
    protected int money;
    protected int HP;

    public Player() {
        money = 999999;
        HP = 100;
    }

    public int getHP() {
        return HP;
    }

    public int getMoney() {
        return money;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
