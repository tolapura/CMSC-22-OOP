import java.util.*;

public class King extends Character{

	public King(){
		super(new KnifeBehavior(), "King");
	}

	public King(WeaponBehavior weapon){
		super(weapon, "King");
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