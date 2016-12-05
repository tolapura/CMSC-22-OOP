package midterms.plant;
import midterms.SplashAttacker;
import midterms.zombie.Zombie;

import java.util.List;

public class Cherrybomb extends Plant implements SplashAttacker {

    private int turncount;

    public Cherrybomb() {
        super(10, 150, 150);
        turncount = 2;
    }

    private int turnCount() {
        return turncount;
    }


    @Override
    public void splashAttack(List<Zombie> defenders) {
        if (turnCount() != 0) {
            turncount--;
        } else {
            for (Zombie z : defenders) {
                if (z != null) {
                    z.takeDamage(super.getDamage());
                }
            }
            super.setHp(0);
        }
    }
}