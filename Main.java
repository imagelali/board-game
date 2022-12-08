
// A 6/5-ben töröljük: import java.util.Scanner;

/* Miután a 4/6-ban importáltam a Boardot
* ezekre nincs szükség
 
import board.Field;
import board.FieldType;
import board.Level;
import character.Position;
*/

//import board.Board; //4/6

//import character.GameCharacter; //5/3

// import character.MonsterArmy;



// A 7/2-ben megszünik: class Main {
// A 4/6-nál folytatódik:   public static void main(String[] args) {
      /*Ezek a korábbi példányosítások és kiírattatások voltak: 
      Hero myHero = new Hero(0, 0);
      Monster monster = new Monster(Monster.BASE_MONSTER_HEALTH, Monster.BASE_MONSTER_ATTACK, new Position(0, 2), 'M');
  
      myHero.printGameCharacter();
      myHero.step(1);
      myHero.printGameCharacter();
      monster.printGameCharacter();

      System.out.println(TestDiceRolls.getDiceRoll());
      System.out.println(TestDiceRolls.getDiceRoll());
      TestDiceRolls.counter = 0;
      System.out.println(TestDiceRolls.getDiceRoll());
      

// 3/3 Hős kontra szörny I.
      System.out.println("Hero's attack power: " + myHero.attack());
      System.out.println("Monster's attack power: " + monster.attack());

// 3/4 Hős köntra Szörny II.
      myHero.fight(monster);
      monster.fight(myHero);
      myHero.fight(monster);
      
      
// 4/2 Enumok a Javában
      String nameOfPotion = FieldType.POTION.name();
      System.out.println(nameOfPotion);
      */

/* 


// 4/3 A mezők
      Field testField = new Field(FieldType.MONSTER);
      testField.printField(false);
      System.out.println();
      testField.printField(true);
      
      
// 4/4 A szintek
      char[] levelSetup = { 'M', 'M', 'P', 'P', 'M', 'P', 'M', 'P', 'P', 'B' };
      Level testLevel = new Level(levelSetup);
      testLevel.printLevel(1, new Position(1, 4), true);
*/     
/*A 7/3-ban a szörnyek miatt az egész átíródik      
// 4/6 A pálya készen áll:
private static final char[][] BOARD = {
      { 'M', 'M', 'P', 'P', 'M', 'P', 'M', 'P', 'P', 'B' },
      { 'P', 'M', 'P', 'M', 'M', 'P', 'P', 'M', 'P', 'B' },
      { 'M', 'P', 'P', 'M', 'M', 'M', 'P', 'P', 'P', 'B' }
};
private static final boolean IS_FIELD_TYPE_VISIBLE = true;

 public static void main(String[] args) {
/* Ez a 4/6-ra vonatkozik:
  Board board = new Board(BOARD);
  board.printBoard(IS_FIELD_TYPE_VISIBLE);
*/

/*  Az 5/2
   Board board = new Board(BOARD);
   MonsterArmy monsterArmy = new MonsterArmy(board);
   Az 5/2-ben 
   monsterArmy.printMonsterArmy();
   

   //5/3:
   System.out.println(monsterArmy.getArmy().size());
   GameCharacter monster = monsterArmy.getMonster(0,0);
   System.out.println(monsterArmy.getArmy().size());

 */ 
/* Ez kell a //3-hoz:

    GameSetup gameSetup = new GameSetup(BOARD, IS_FIELD_TYPE_VISIBLE);

    System.out.println("Please write a number here between 1 and 3: ");
      Scanner scanner = new Scanner(System.in);
      int step = scanner.nextInt();
      System.out.println("The hero is moving forward " + step + " steps");
}
}
 */ 

 /*  7/2. A szörnyek miatt igy folytatódik:
 public class Main {
      private static final char[][] BOARD = {
          { 'M', 'M', 'P', 'P', 'M', 'P', 'M', 'P', 'P', 'B' }
      };
      private static final boolean IS_FIELD_TYPE_VISIBLE = false;
      
      public static void main(String[] args) {    
 
    new GameSetup(BOARD, IS_FIELD_TYPE_VISIBLE).start();
    }
 }
*/

//A játék vége:
public class Main {
      private static final char[][] BOARD = {
          { 'M', 'M', 'P', 'P', 'M', 'P', 'M', 'P', 'P', 'B' },
          { 'P', 'M', 'P', 'M', 'M', 'P', 'P', 'M', 'P', 'B' },
          { 'M', 'P', 'P', 'M', 'M', 'M', 'P', 'P', 'P', 'B' }
      };
      private static final boolean IS_FIELD_TYPE_VISIBLE = false;
      
      public static void main(String[] args) {    
        new GameSetup(BOARD, IS_FIELD_TYPE_VISIBLE).start();
      }
  }
  






  