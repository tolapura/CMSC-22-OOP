import java.util.*;

public class CharacterTest{
	public static void main(String[] args){

		System.out.println("--Default Constructor--\n");

		Character king = new King();
		Character queen = new Queen();
		Character knight = new Knight();
		Character troll = new Troll();
		king.fight();
		queen.fight();
		knight.fight();
		troll.fight();

		System.out.println("\n--------Test 1-------\n");

		Character k1 = new King(new SwordBehavior());
		Character k2 = new King(new AxeBehavior());
		Character k3 = new King(new BowAndArrowBehavior());
		Character k4 = new King(new KnifeBehavior());
		k1.fight();
		k2.fight();
		k3.fight();
		k4.fight();

		System.out.println("\n--------Test 2-------\n");

		Character q1 = new Queen(new SwordBehavior());
		Character q2 = new Queen(new AxeBehavior());
		Character q3 = new Queen(new BowAndArrowBehavior());
		Character q4 = new Queen(new KnifeBehavior());
		q1.fight();
		q2.fight();
		q3.fight();
		q4.fight();

		System.out.println("\n--------Test 3-------\n");

		Character kt1 = new Knight(new SwordBehavior());
		Character kt2 = new Knight(new AxeBehavior());
		Character kt3 = new Knight(new BowAndArrowBehavior());
		Character kt4 = new Knight(new KnifeBehavior());
		kt1.fight();
		kt2.fight();
		kt3.fight();
		kt4.fight();

		System.out.println("\n--------Test 4-------\n");

		Character t1 = new Troll(new SwordBehavior());
		Character t2 = new Troll(new AxeBehavior());
		Character t3 = new Troll(new BowAndArrowBehavior());
		Character t4 = new Troll(new KnifeBehavior());
		t1.fight();
		t2.fight();
		t3.fight();
		t4.fight();
	}	
}