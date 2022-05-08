package net.pullolo.events;

public class Mana {
    private int Mana = 300;
    private int MaxMana = 300;
    private int ManaRegen = 20;

    public Mana() {
    }

    public void ResetMana(){
        Mana = MaxMana;
    }

    public void RegenMana(){
        if(Mana < MaxMana){
            Mana += ManaRegen;
        }
        if (Mana > MaxMana){
            Mana = MaxMana;
        }
    }

    public int getMana() {
        return Mana;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

    public int getMaxMana() {
        return MaxMana;
    }

    public void setMaxMana(int maxMana) {
        MaxMana = maxMana;
    }

    public int getManaRegen() {
        return ManaRegen;
    }

    public void setManaRegen(int maxManaRegen) {
        ManaRegen = maxManaRegen;
    }
}
