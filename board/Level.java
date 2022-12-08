package board;

import character.Position;

// A szintek osztály
/*Ez az osztály több érdekes metódussal is rendelkezik, nézzük meg ezeket sorban.

Elsőként a getField() metódust láthatod.
 Ez a metódus egy mezőt ad vissza a fields tömbből attól függően, 
 hogy paraméterként milyen indexet kapott meg.

A createLevelFromSetup() metódus lesz felelős
 a paraméterként kapott char tömbből egy Field-eket tartalmazó tömb létrehozásáért.
  A paraméterként kapott tömbben találhatók az adott szint mezőinek típusai.
 Ennek a segítségével kell egy Field elemeket tartalmazó tömböt létrehozni,
  amely a megfelelő típusokat tartalmazza.
   Ez a metódus fogja a konstruktoron belül inicializálni a fields tömböt.

A printLevel() metódus elsőként kiírja,
 hányadik szinten járunk,
  majd pedig egymás mellé nyomtatja ki a mezőket.
   A paraméterként kapott heroPosition a hős helyzetét határozza meg. 
   Amelyik mezőn a hős éppen áll,
    ott a [H]-t fogja kiírni a konzol.
     A hős még abban az esetben is látható kell legyen,
      ha a paraméterben kapott isFieldTypeVisible hamis értéket kap. */

public class Level {
    private Field[] fields;

    public Level(char[] levelSetup) {
      this.fields = createLevelFromSetup(levelSetup);
    }
  
    public Field getField(int fieldNumber) {
      return this.fields[fieldNumber];
    }
  
    public Field[] getFields() {
      return this.fields;
    }
  
    private Field[] createLevelFromSetup(char[] levelSetup) {
      Field[] fields = new Field[levelSetup.length];
  
      for (int i = 0; i < levelSetup.length; i++) {
        char fieldChar = levelSetup[i];
        if (fieldChar == 'M') {
          fields[i] = new Field(FieldType.MONSTER);
        } else if(fieldChar == 'P') {
          fields[i] = new Field(FieldType.POTION);
        } else {
          fields[i] = new Field(FieldType.BOSS);
        }
      }
  
      return fields;
    }
  
    public void printLevel(int level, Position heroPosition, boolean isFieldTypeVisible) {
      System.out.print("Level " + level + " ");
      for (int i = 0; i < this.fields.length; i++) {
        if (heroPosition.getField() == i) {
          System.out.print("[H]");
        } else {
          fields[i].printField(isFieldTypeVisible);
        }
      }
      System.out.println();
    }
  }

