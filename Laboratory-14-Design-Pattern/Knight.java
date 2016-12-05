import java.util.*;

public class Knight extends Character{

	public Knight(){
		super(new SwordBehavior(), "Knight");
	}

	public Knight(WeaponBehavior weapon){
		super(weapon, "Knight");
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