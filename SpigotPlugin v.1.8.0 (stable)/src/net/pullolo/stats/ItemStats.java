package net.pullolo.stats;

public class ItemStats {
    private int damage;
    private int abilityPower;
    private int manaCost;

    public ItemStats(int damage, int abilityPower, int manaCost){
        this.damage = damage;
        this.abilityPower = abilityPower;
        this.manaCost = manaCost;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getAbilityPower() {
        return abilityPower;
    }
    public void setAbilityPower(int abilityPower) {
        this.abilityPower = abilityPower;
    }
    public int getManaCost() {
        return manaCost;
    }
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
