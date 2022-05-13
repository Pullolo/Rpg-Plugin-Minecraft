package net.pullolo.stats;

public class ArmorStats {
    private int defense;
    private int bonusHealth;
    private int bonusSpeed;

    public ArmorStats(int defense, int bonusHealth, int bonusSpeed){
        this.defense = defense;
        this.bonusHealth = bonusHealth;
        this.bonusSpeed = bonusSpeed;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getBonusHealth() {
        return bonusHealth;
    }
    public void setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
    }
    public int getBonusSpeed() {
        return bonusSpeed;
    }
    public void setBonusSpeed(int bonusSpeed) {
        this.bonusSpeed = bonusSpeed;
    }
}
