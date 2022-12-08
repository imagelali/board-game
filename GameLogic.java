import java.util.Scanner;

import character.Hero;
import board.Board;
import board.Level;
//A 7/1-nél kerülnek bele:
import character.GameCharacter;
import character.MonsterArmy;
// A 7/2-nél kikerült: import board.FieldType;
//7/4-ben megszünt: import helper.TestDiceRolls;

public class GameLogic {

  private int currentLevel;
  private int currentField;
  private boolean isFieldTypeVisible;
  // A 7/1-nél kiegészül:
  public static final double BASE_POTION_AMOUNT = 30.0;
  public static final double POTION_LOSS = 5.0;

  public GameLogic(int currentLevel, int currentField, boolean isFieldTypeVisible) {
    this.currentLevel = currentLevel;
    this.currentField = currentField;
    this.isFieldTypeVisible = isFieldTypeVisible;
  }

  //6/5 moveHero(), changeLevel():
  public void moveHero(Board board, Hero hero, int step) {
    this.currentField += step;
    hero.step(this.currentField);

    if (this.currentField >= board.getNumberOfFields() - 1) {
      this.currentField = board.getNumberOfFields() - 1;
      hero.step(this.currentField);
    }
  }

  public void changeLevel(Board board, Hero hero) {
    if (hero.getPosition().getField() == board.getNumberOfFields() - 1) {
      this.currentLevel += 1;
      this.currentField = GameSetup.START_FIELD;
      board.setCurrentLevel(this.currentLevel);
      hero.step(this.currentField);
      hero.changeLevel(this.currentLevel);
    }
  }

  //A 7/1-nél kerül be a pickUpPotion():
  public void pickUpPotion(Hero hero) {
    System.out.println("-----POTION PICKUP-----");
    double currentHeroHealth = hero.getHealthPoint();
    double newHeroHealth = currentHeroHealth + BASE_POTION_AMOUNT - (this.currentLevel * POTION_LOSS);
    hero.setHealthPoint(newHeroHealth);
    hero.printGameCharacter();
  }


  //A 7/2-nél kerül bele a battle():
  public boolean battle(Hero hero, GameCharacter monster) {
    boolean isHeroAlive = true;

    System.out.println("-----MONSTER FIGHT-----");

    while (hero.getHealthPoint() > 0) {
      hero.fight(monster);
      if (monster.getHealthPoint() > 0) {
        monster.fight(hero);
      } else {
        return isHeroAlive;
      }
    }

    isHeroAlive = false;

    return isHeroAlive;
  }

  public void run(Board board, Hero hero, MonsterArmy monsterArmy) {
    Level[] levels = board.getBoard();

    System.out.println("START");
    Scanner scanner = new Scanner(System.in);
    
    boolean isHeroAlive = true;
    boolean isFinalBossAlive = true;
    int numberOfPotionsPicked = 0; // Csak a 7/3-nál a jéták végén kerül be.
    int numberOfMonstersKilled = 0; // Ez is.

    while (isHeroAlive && isFinalBossAlive) {
      System.out.println("\nChoose step:\t 1\t 2\t 3");
      int step = scanner.nextInt();

      while(step != 1 && step != 2 && step != 3) {
        System.out.println("Please choose from the following steps: 1, 2, 3");
        step = scanner.nextInt();
      scanner.close();  
      }
    
      changeLevel(board, hero);

      moveHero(board, hero, step);

      if (hero.isReadyToFight(levels[this.currentLevel].getField(this.currentField))) {
        GameCharacter monster = monsterArmy.getMonster(this.currentLevel, this.currentField);
        isHeroAlive = battle(hero, monster);
        if (!isHeroAlive) {
          System.out.println("GAME OVER");
        }
        // A 7/4-ben kikerült: TestDiceRolls.counter = 0;
      } else {
        pickUpPotion(hero);
        numberOfPotionsPicked++; //7/4-től
      }

      if (this.currentLevel == board.getNumberOfLevels() - 1 && this.currentField == board.getNumberOfFields() - 1 && isHeroAlive) {
        isFinalBossAlive = false;
        System.out.println("YOU WON!");
      }

      if (isHeroAlive && isFinalBossAlive) {
        levels[this.currentLevel].printLevel(this.currentLevel + 1, hero.getPosition(), this.isFieldTypeVisible);
      }
      
    }

    // 7/3 A játék vége:
    System.out.println("TOTAL POTIONS FOUND: " + numberOfPotionsPicked);
    System.out.println("TOTAL MONSTERS KILLED: " + numberOfMonstersKilled);
  }
  
}


/* A 7/2-ben az összes későbbiek átíródnak,kiegészülnek a harc miatt: 
  public void run(Board board, Hero hero, MonsterArmy monsterArmy ) { //A 7/1-nél kerül be a MonsterArmy
    Level[] levels = board.getBoard();

    System.out.println("START");
    Scanner scanner = new Scanner(System.in);

    boolean isHeroAlive = true;

    while (isHeroAlive) {
      System.out.println("\nChoose step:\t 1\t 2\t 3");
      int step = scanner.nextInt();

      while(step != 1 && step != 2 && step != 3) {
        System.out.println("Please choose from the following steps: 1, 2, 3");
        step = scanner.nextInt();
      }

// A 6/5-ben került ide achangeLevel és a moveHero:
      changeLevel(board, hero);
      moveHero(board, hero, step);
      
// A 7/1-ben került bele if():
if(levels[this.currentLevel].getField(this.currentField).getFieldType() == FieldType.POTION) {
    pickUpPotion(hero);
  }

  if (isHeroAlive) {
    levels[this.currentLevel].printLevel(this.currentLevel + 1, hero.getPosition(), this.isFieldTypeVisible);
  }

//Ez csak a =/1-ig kellett:
      hero.printGameCharacter();

      levels[this.currentLevel].printLevel(this.currentLevel, hero.getPosition(), this.isFieldTypeVisible);
*/
    
  

    
