package net.pullolo.stats;

import net.pullolo.items.Items;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;


import java.util.Random;

public class EntityStats {
    private int level;
    private int health;
    private int maxHealth;
    private int healthRegen;
    private int bonusHealthRegen;
    private int baseDefense;
    private int bonusDefense;
    private int defense;
    private int damage;
    private int speed;
    private String customName;
    private final String name;

    public EntityStats(Entity e){
        Random rand = new Random();
        if(e.getType().equals(EntityType.PLAYER)){
            this.level = 1;
            this.health = 20;
            this.healthRegen = 1;
            this.maxHealth = 20;
            this.baseDefense = 10;
            this.damage = 1;
            this.speed = 100;
        }
        else if(e.getName().equalsIgnoreCase("Zombie")){
            this.level = rand.nextInt(10) + 1;
            this.health = 20 * level;
            this.healthRegen = level/4;
            this.maxHealth = 20 * level;
            this.baseDefense = level/3;
            this.damage = 3 * (level/2);
            this.speed = 50;
        }
        else if(e.getName().equalsIgnoreCase("Creeper")){
            this.level = rand.nextInt(10) + 1;
            this.health = 20*level;
            this.healthRegen = level/4;
            this.maxHealth = 20*level;
            this.baseDefense = level/3;
            this.damage = 10*(level/2);
            this.speed = 70;
        }
        else if(e.getName().equalsIgnoreCase("Skeleton")){
            this.level = rand.nextInt(10) + 1;
            this.health = 20*level;
            this.healthRegen = level/4;
            this.maxHealth = 20*level;
            this.baseDefense = level/3;
            this.damage = 6*(level/2);
            this.speed = 50;
        }
        else {
            setDefaults(e);
        }
        if (e.getType().equals(EntityType.SLIME)){
            this.name = "Slime";
        } else {
            this.name = e.getName();
        }
        this.bonusDefense = 0;
        this.bonusHealthRegen = 0;
        this.defense = this.baseDefense;
        //Todo write code that takes the armor and sets the bonus defense in a loop so not here
        //Todo mysql con
        //Todo scoreboard
        //Todo /stats
    }

    public void updateCustomName(){
        this.customName = "§8[§7Lv" + this.level + "§8] " + "§c" + this.name + " §a" + this.health + "§7/§a" + this.maxHealth + "§c♥";
    }

    public void updateStats(Entity e){
        if(e.getType().equals(EntityType.PLAYER)){
            this.healthRegen = level;
            this.maxHealth = 20*level;
            this.baseDefense = 10 + level;
            this.damage = level;
            this.speed = 100 + (level/50);
        }
        else if(e.getName().equalsIgnoreCase("Zombie")){
            this.healthRegen = level/4;
            this.maxHealth = 20 * level;
            this.baseDefense = level/3;
            this.damage = 3 * (level/2);
        }
        else if(e.getName().equalsIgnoreCase("Creeper")){
            this.healthRegen = level/4;
            this.maxHealth = 20*level;
            this.baseDefense = level/3;
            this.damage = 10*(level/2);
        }
        else if(e.getName().equalsIgnoreCase("Skeleton")){
            this.healthRegen = level/4;
            this.maxHealth = 20*level;
            this.baseDefense = level/3;
            this.damage = 6*(level/2);
        }
        else {
            updateDefaults(e);
        }
    }

    private void updateDefaults(Entity e){
        this.healthRegen = level/4;
        this.maxHealth = (int) ((Damageable) e).getHealth()*level;
        this.baseDefense = level/3;
        this.damage = 4*level;
    }

    private void setDefaults(Entity e){
        this.level = 1;
        this.health = (int) (((Damageable) e).getHealth()*level);
        this.healthRegen = level/4;
        this.maxHealth = (int) ((Damageable) e).getHealth()*level;
        this.baseDefense = level/3;
        this.damage = 4*level;
        this.speed = 50;
    }

    public void regen(){
        health += healthRegen+bonusHealthRegen;
        if (health > maxHealth){
            health = maxHealth;
        }
    }

    public void dealDamage(int amount){
        if (defense+bonusDefense <= 10){
            this.health -= amount;
        } else{
            this.health -= amount/((defense+bonusDefense) /10);
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealthRegen() {
        return healthRegen;
    }
    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }
    public int getBaseDefense() {
        return baseDefense;
    }
    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCustomName() {
        return customName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public void setBonusDefense(int bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    public int getBonusHealthRegen() {
        return bonusHealthRegen;
    }

    public void setBonusHealthRegen(int bonusHealthRegen) {
        this.bonusHealthRegen = bonusHealthRegen;
    }
}