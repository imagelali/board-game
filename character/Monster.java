package character;

import helper.RandomDiceRoll;

/*A private static példányváltozók a szörny különböző
 * állapotát írják le:
 * BASE_MONSTER_ATTACK: a szörny támadásának kezdőértéke
   BASE_MONSTER_HEALTH: a szörny életének kezdőértéke
   BASE_BOSS_ATTACK: a szint végén álló, legerősebb szörny támadásának kezdőértéke
   BASE_BOSS_HEALTH: a szint végén álló, legerősebb szörny életének kezdőértéke
   Az állapotok értékei:
   Tulajdonság	Érték:
BASE_MONSTER_ATTACK	5.0
BASE_MONSTER_HEALTH	10.0
BASE_BOSS_ATTACK	10.0
BASE_BOSS_HEALTH	20.0

A fenti példányváltozókon, valamint konstruktoron kívül a Monster osztály rendelkezik 
még getter metódussal a HardAttack, MediumAttack és WeakAttack örökölt példányváltozókhoz:

A getHardAttack metódus visszatérési értéke az attackPoint példányváltozó értékének felel meg.
A getMediumAttack metódus visszatérési értéke a HardAttack 60%-a legyen.
A getWeakAttack metódus visszatérési értéke pedig a HardAttack 30%-a legyen.
 */
public class Monster extends GameCharacter {
    public static final double BASE_MONSTER_ATTACK = 5.0;
    public static final double BASE_MONSTER_HEALTH = 10.0;
    public static final double BASE_BOSS_ATTACK = 10.0;
    public static final double BASE_BOSS_HEALTH = 20.0;
  
    public Monster(double healthPoint, double attackPoint, Position position, char initial) {
      super(healthPoint, attackPoint, position, initial);
    }
  
    public double getHardAttack() {
      return this.getattackPoint();
    }
  
    public double getMediumAttack() {
      return getHardAttack() * (60.0 / 100.0);
    }
  
    public double getWeakAttack() {
      return getHardAttack() * (30.0 / 100.0);
    }

    /*Az absztrakció során megtanultuk, hogy ha egy gyerekosztály 
    örököl egy absztrakt metódust, akkor azt minden esetben
     implementálnia kell.
      Mivel a Monster osztály ezt még nem tette meg az attack() metódussal
      Ime:
       */
      @Override
      public double attack() {
        int currentDiceRoll = RandomDiceRoll.roll();
    
        System.out.println(this.getInitial() + " rolled a(n) " + currentDiceRoll);
    
        double attackAmount = 0;


    /*A 6/4-től bekerül a this. 
        if (currentDiceRoll == 1 || currentDiceRoll == 2) {
          attackAmount = getHardAttack();
        } else if (currentDiceRoll == 3 || currentDiceRoll == 4 || currentDiceRoll == 5) {
          attackAmount = getMediumAttack();
        } else if (currentDiceRoll == 6 || currentDiceRoll == 7 || currentDiceRoll == 8) {
          attackAmount = getWeakAttack();
        }
    
        return attackAmount;
        */

        // 6/4-től a this.-al:
        if (currentDiceRoll == 1 || currentDiceRoll == 2) {
          attackAmount = this.getHardAttack();
        } else if (currentDiceRoll == 3 || currentDiceRoll == 4 || currentDiceRoll == 5) {
          attackAmount = this.getMediumAttack();
        } else if (currentDiceRoll == 6 || currentDiceRoll == 7 || currentDiceRoll == 8) {
          attackAmount = this.getWeakAttack();
        }
    
        return attackAmount;
      }
    }
  

