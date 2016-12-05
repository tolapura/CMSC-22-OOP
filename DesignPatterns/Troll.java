import java.util.*;

public class Troll extends Character{

	public Troll(){
		super(new AxeBehavior(), "Troll");
	}

	public Troll(WeaponBehavior weapon){
		super(weapon, "Troll");
	}

	@Override
	public void fight(){
		super.fight();
	}

	@Override
	public String toString(){
		return super.toString();
	}
}