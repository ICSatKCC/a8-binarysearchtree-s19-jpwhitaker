/**
 * Charizard Pokemon object class.
 * Subclass of Charmeleon
 * @author JPW
 * @version 1.0
 * @since 2/20/2019
 */
public class Charizard extends Charmeleon implements FlyingType {

	/** The minimum attack power for species. */
	static final int BASE_ATTACK_POWER = 156;
	/** The minimum defense power for species. */
	static final int BASE_DEFENSE_POWER = 158;
	/** The minimum stamina power for species. */
	static final int BASE_STAMINA_POWER = 120;

	/** Constructor with no name. */
	public Charizard() {
		super("Charizard", "Charizard", 6, 1.7, 90.5, FLYING_TYPE, 
            BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
	}

	/** Constructor with name.
	 * @param name The user-defined name.
	 */
	public Charizard(String name) {
		super("Charizard", name, 6, 1.7, 90.5, FLYING_TYPE, BASE_ATTACK_POWER, 
				BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
	}
	/** 
	 * Constructor with species and name for subclasses.
	 *@param species The Pokemon's species.
	 *@param name The optional user-given name.
	 *@param num The Pokedex number for this species.
	 *@param ht The height of this Pokemon.
	 *@param wt The weight of this Pokemon. 
    *@param type2 The secondary type of the Pokemon. 
	 *@param baseAttackPwr The low limit of Attack Power for species.
	 *@param baseDefensePwr The low limit of Defense Power for species.
	 *@param baseStaminaPwr The low limit of Stamina Power for speices. 
	 */
	protected Charizard(String species, String name, int num, double ht, 
			double wt, String type2, int baseAttackPwr, int baseDefensePwr, 
         int baseStaminaPwr) {

		super(species, name, num, ht, wt, type2, baseAttackPwr, 
				baseDefensePwr, baseStaminaPwr);
	}


}

