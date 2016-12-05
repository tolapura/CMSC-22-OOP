import java.util.*;

public class Queen extends Character{

	public Queen(){
		super(new BowAndArrowBehavior(), "Queen");
	}

	public Queen(WeaponBehavior weapon){
		super(weapon, "Queen");
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