package character;

import helper.RandomDiceRoll;
import board.Field;
import board.FieldType;


/*A private static final példányváltozók
a hős különböző állapotát írják le:
HERO_INITIAL: a hős kezdőbetűje, a megjelenítésnél van szerepe
BASE_HEALTH: a hős életének kezdőértéke
HARD_ATTACK: a hős erős ütésének ereje
MEDIUM_ATTACK: a hős közepes ütésének ereje
WEAK_ATTACK: a hős gyenge ütésének ereje
INSTANT_KILL: a hős ennyi sebzést okoz a szörnynek,
              ha sikerül egy ütésből legyőznie
Ezek értékei:
Tulajdonság	Érték
HERO_INITIAL	'H'
BASE_HEALTH	100.0
INSTANT_KILL	1000.0
HARD_ATTACK	10.0
MEDIUM_ATTACK	HARD_ATTACK * (60.0 / 100.0)
WEAK_ATTACK	HARD_ATTACK * (30.0 / 100.0)
 */

public class Hero extends GameCharacter {
    private static final char HERO_INITIAL = 'H';
    private static final double BASE_HEALTH = 100.0;
    private static final double INSTANT_KILL = 1000.0;
    private static final double HARD_ATTACK = 10.0;
    private static final double MEDIUM_ATTACK = HARD_ATTACK * (60.0 / 100.0);
    private static final double WEAK_ATTACK = HARD_ATTACK * (30.0 / 100.0);
  
    public Hero(int level, int field) {
      super(BASE_HEALTH, HARD_ATTACK, new Position(level, field), HERO_INITIAL);
    }

    //Ez a step() metódus a paraméterben megadott mezőre állítja a hőst.
    public void step(int field) {
      this.getPosition().setField(field);
    }

    //Ez a changeLevel() metódus pedig a paraméterben megadott szintre állítja a hőst.
    public void changeLevel(int level) {
      this.getPosition().setLevel(level);
    }
    /*Hős kontra Szörny I.
     * 1) Kockadobás lementése változóba
       2) Kocka értékének kinyomtatása a konzolra
       3) Támadási erő deklarálása
       4) Támadási erő meghatározása a kockadobás értékéből
     1) Ha a dobott érték 1 vagy 2, akkor a támadási erő legyen halálos
     2) Ha a dobott érték 3 vagy 4, akkor a támadási erő legyen alap szintű 
     3) Ha a dobott érték 5 vagy 6, akkor a támadási erő legyen az alap szintű támadás hatvan százaléka
     4) Ha a dobott érték 7 vagy 8, akkor a támadási erő legyen az alap szintű támadás harminc százaléka
     5) Támadási erő visszaadása
     Az attack() metódus
     */
    @Override
    public double attack() {
        int currentDiceRoll = RandomDiceRoll.roll();

    System.out.println(Hero.HERO_INITIAL + " rolled a(n) " + currentDiceRoll);

    double attackAmount = 0;

    if (currentDiceRoll == 1 || currentDiceRoll == 2) {
      attackAmount = Hero.INSTANT_KILL;
    } else if (currentDiceRoll == 3 || currentDiceRoll == 4) {
      attackAmount = Hero.HARD_ATTACK;
    } else if (currentDiceRoll == 5 || currentDiceRoll == 6) {
      attackAmount = Hero.MEDIUM_ATTACK;
    } else if (currentDiceRoll == 7 || currentDiceRoll == 8) {
      attackAmount = Hero.WEAK_ATTACK;
    }

    return attackAmount;
  }

    // A 7/2-ben kerül bele az isReadyTofight():
    public boolean isReadyToFight(Field field) {
      return field.getFieldType() == FieldType.MONSTER || field.getFieldType() == FieldType.BOSS;
  }
}
    
  

