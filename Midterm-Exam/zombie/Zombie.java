package midterms.zombie;

import midterms.Character;

/**
 * Class to generalize all types of zombies.
 */
public abstract class Zombie extends Character {

    private int sunlightCost;

    public Zombie(int hp, int damage) {
        super(hp, damage);
    }

}
