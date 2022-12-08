package character;

//A 7/2-ben kerül bele:
// A 7/4-ben töröltem: import helper.TestDiceRolls;

/*Ebben az osztályban már szerepel a Position osztály is
 * példányváltozóként, mivel a karakternek lennie kell pozíciónak is.
 * valamint:
 * a konstruktor módosítása,
 * a getter és setter metódusok,
 * valamint az osztály példányait megjelenítő metódus
 * Az osztály azért abstract, mert van Hero és Monster osztályunk.
 */
public abstract class GameCharacter {
    private double healthPoint;
    private double attackPoint;
    private Position position;
    private char initial;
  
    public GameCharacter(double healthPoint, double attackPoint, Position position, char initial) {
      this.healthPoint = healthPoint;
      this.attackPoint = attackPoint;
      this.position = position;
      this.initial = initial;
    }
  
    public double getHealthPoint() {
      return this.healthPoint;
    }
  
    public void setHealthPoint(double healthPoint) {
      this.healthPoint = healthPoint;
    }
  
    public double getattackPoint() {
      return this.attackPoint;
    }
  
    public Position getPosition() {
      return this.position;
    }
  
    public char getInitial() {
      return this.initial;
    }
  
    public void printGameCharacter() {
      System.out.println(this.initial + " = " + "{ a: " + this.attackPoint + ", h: " + (this.healthPoint < 0 ? "0" : this.healthPoint) + ", p: " + this.position.getPositionString() + " }");
    }

/* 3/4 Hős kontra Szörny II.
user story:
[ ] a küzdelem esetén két dolgot lát: a támadás erejét,
 illetve az ellenfél életerejét a támadások után.
A hős és a szörny karakterek kockadobásokkal döntik el, hogy mekkora támadási erőt használnak.
 Ez valamelyest megadja a user story első részét.
  Hiszen tudjuk a támadási erők értékeit, csak még nincsenek kiírva a konzolra.

A második része, amikor egy karakter életerejét a támadások után kell megjeleníteni,
 már egy kicsit érdekesebb.
  Végig kell gondolni, hogy ez a folyamat különbözik-e a két karakternél.

Valójában ugyanolyan módon zajlik egy támadás egy hősnél és egy szörnynél is,
 csak maguknál a kockadobásoknál van különbség.
 */
public void fight(GameCharacter GameCharacter) {
    double damage = this.attack();
    System.out.println(this.initial + " attack:  " + damage);
    double newHeroHealth = GameCharacter.getHealthPoint() - damage;
    GameCharacter.setHealthPoint(newHeroHealth);
    GameCharacter.printGameCharacter();
    if (GameCharacter.getHealthPoint() <= 0) ;
      
    }
  
  

  /*Az OOJ figyelembe vételével létre kell hozni
  ebben az osztályban is egy attack() metódust 
  double visszatérési értékkel.*/
  public abstract double attack();
}
