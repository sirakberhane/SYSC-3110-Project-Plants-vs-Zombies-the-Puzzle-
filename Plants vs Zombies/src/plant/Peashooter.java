package plant;
/**
 * Peashooter Class:
 * Peashooters are your first line 
 * of defense. They shoot peas at attacking zombies.
 * 
 * @author Sirak Berhane (101030433)
 */
public class Peashooter extends ShooterPlant{
	/**
	 * Extends a ShooterPlant type, any shooter plant type 
	 * has the ability to do damage to any zombie type. 
	 * @param x grid position x
	 * @param y grid position y
	 */
	public Peashooter(int x, int y) {
		super(10, 100, x, y, 2);
	}
	
	/**
	 * Shoots a pea at zombie, if zombie is close enough.
	 * @return negative hit value to a zombie object
	 */
	public int shootPea() {
		return -(getHitValue());
	}
}
