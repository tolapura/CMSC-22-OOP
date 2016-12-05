package midterms.plant;

import midterms.Producer;

public class Sunflower extends Plant implements Producer {

    public Sunflower() {
        super(30, 0, 50);
    }

    @Override
    public int produce() {
        return 100;
    }
}
