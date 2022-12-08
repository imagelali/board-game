package character;

import board.Board;
import board.Level;
import board.FieldType;
import java.util.ArrayList;


// A szörnyhadsereg, és elhelyezése:
public class MonsterArmy {

    
    private ArrayList<GameCharacter> army;
    private Board board;
  
    public MonsterArmy(Board board) {
      this.board = board;// ez a példányváltozó tartalmazza a pálya pontos leírását.
      this.army = createMonsters();//ez a metódus felelős a szörnyhadsereg létrehozásáért.
    }
  
    public ArrayList<GameCharacter> getArmy() {
      return this.army;
    }
  
    public void setArmy(ArrayList<GameCharacter> army) {
      this.army = army;
    }
  
    public Board getBoard() {
      return this.board;
    }
  
    public void setBoard(Board board) {
      this.board = board;
    }


  /*Ezen a ponton jön be az osztály másik két metódusa: a createMonster() és createBoss().

Mivel a createArmy() metódus egyik feladata az, hogy végigiteráljon a board példányváltozó szinteket tartalmazó tömbjén,
 amikor elér egy olyan mezőre, amelynek a típusa MONSTER,
  ott egy szimpla szörnyet rak le, azaz meghívja a createMonster() metódust.
   Ennek argumentumaként megadja, hogy éppen melyik szinten és mezőn áll.
    A createMonster() pedig ezen információk alapján létrehozza a szörnyet.
     Azonban level és field paraméterekből nem csak azt adja meg,
      hogy hol legyen a szörny pozíciója, hanem hogy milyen erősségű legyen a szörny.

Miután egy szörny létrejön, a createArmy() metódus második feladata lép életbe,
 azaz, hogy eltárolja a szörny pédlányt az army ArrayListben.

A createBoss() lépésről lépésre ugyanazt ismétli meg, mint a createMonster(),
 csak a szint végi legerősebb szörnnyel.:

 A metódusok létrehozásánál használd fel szörnyek értékeit leíró táblázatot,
  valamint a Monster osztály konstans változóit:

Szint	Szimpla szörny	Szint legerősebb szörnye
1	Életerő: 10.0, Támadóerő: 5.0	Életerő: 20.0, Támadóerő: 10.0
2	Életerő: 15.0, Támadóerő: 10.0	Életerő: 30.0, Támadóerő: 20.0
3	Életerő: 20.0, Támadóerő: 15.0	Életerő: 40.0, Támadóerő: 30.0
  */
    public Monster createMonster(int level, int field, char initial) {
      double attackPoint = Monster.BASE_MONSTER_ATTACK * (level + 1);
      double healthPoint = (Monster.BASE_MONSTER_HEALTH * (level + 1)) - Monster.BASE_MONSTER_ATTACK * level;
      return new Monster(healthPoint, attackPoint, new Position(level, field), initial);
    }
  
    public Monster createBoss(int level, int field, char initial) {
      double attackPoint = Monster.BASE_BOSS_ATTACK * (level + 1);
      double healthPoint = (Monster.BASE_BOSS_HEALTH * (level + 1)) - Monster.BASE_BOSS_ATTACK * level;
      return new Monster(healthPoint, attackPoint, new Position(level, field), initial);
    }
  
    public ArrayList<GameCharacter> createMonsters() {  // 6/4-től a createArmy=createMonters
      Level[] levels = this.board.getBoard();
      ArrayList<GameCharacter> monsters = new ArrayList<>();
  
      for (int i = 0; i < this.board.getNumberOfLevels(); i++) {
        for (int j = 0; j < this.board.getNumberOfFields(); j++) {
  
          FieldType fieldType = levels[i].getField(j).getFieldType();
          char initial = levels[i].getField(j).getInitial();
  
          if (fieldType == FieldType.MONSTER) {
            monsters.add(createMonster(i, j, initial));
          } else if (fieldType == FieldType.BOSS) {
            monsters.add(this.createBoss(i, j, initial));
          }
        }
      }
  
      return monsters;
    }

    /*5/3 - egy szörny harcba küldése a getMonster()metódussal
     * Fontos! A találat után a szörny mindenképp kerüljön törlésre a listából.
     *  Ez nem más, mint a break.
     */
    public GameCharacter getMonster(int level, int field) {
        GameCharacter monster = null;
    
        for (int i = 0; i < this.army.size(); i++) {
          monster = this.army.get(i);
          if (monster.getPosition().getLevel() == level && monster.getPosition().getField() == field) {
            monster = this.army.remove(i);
            break;
          } 
          }

          return monster; //5/3-nál visszatér !!!
        }
    
    /* Ez volt az 5/2-ben is és marad az 5/3-ban is
     a szörny harcba küldésekor -
     Végül pedig, hogy láthassuk a kész szörnyhadsereget,
hozz létre egy printMonsterArmy() metódust is,
 amely kinyomtatja a konzolra az összes szörnyet.
  */    
    public void printMonsterArmy() {
      for (int i = 0; i < this.army.size(); ++i) {
        this.army.get(i).printGameCharacter();
      }
    }
  }

