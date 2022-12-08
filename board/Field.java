package board;

// A mezőket ténylegesen leíró osztály

/*A getInitial() metódus az adott mező típusának a kezdőbetűjét adja vissza.
 Ehhez szükséged lesz egy eddig még nem tanult String metódusra,
  a charAt()-re. Ez egy olyan metódus, amelynek segítségével 
  a String egy karakterét kapjuk vissza, az index alapján.
  
  A printField() metódus a paraméterben kapott booleantől 
  függően írja ki a mező típusát. Ha igaz értéket kap,
   akkor megjeleníti a mező típusának kezdőbetűjét.
    Ha pedig hamis értéket, akkor egy üres mezőt 
    jelenít meg a felhasználó számára.

printField(false) → [ ]   // nincs mit mutatni
printField(true) → [M] // egy szörny áll a mezőn
printField(true) → [P] // egy bájital található a mezőn
  */

public class Field {
    private FieldType fieldType;

  public Field(FieldType fieldType) {
    this.fieldType = fieldType;
  }

  public FieldType getFieldType() {
    return this.fieldType;
  }

  public char getInitial() {
    return this.fieldType.name().charAt(0);
  }

  public void printField(boolean isFieldTypeVisible) {
    System.out.print("[" + (isFieldTypeVisible ? getInitial() : " ") + "]");
  }
}



