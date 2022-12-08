package helper;

/*az osztály felépítése eltér a megszokottól,
 mivel csak static változói és egy static metódusa van.
  Azért alkottuk meg így az osztályt, mivel ez csak egy segéd részét,
   a tesztelést adja a programnak. 
   Így nem kell bajlódni a példányok létrehozásával,
    hanem közvetlenül lehet használni a változókat és metódusokat.

Nézzük meg, mit takarnak az osztályváltozók:

counter → Elmenti, hogy éppen hányadik kockadobás van soron.
diceRolls → A hét darab kockadobás egy tömbbe lementve.
A getDiceRoll() metódus pedig mindig a következő kockadobás eredményét adja vissza
 * 
 */
public class TestDiceRolls {
    public static int counter = 0;
    public static int[] testDiceRolls = {8, 3, 4, 3, 5, 6, 1};
    
    public static int getDiceRoll() {
      return testDiceRolls[counter++]; //7/2-től a diceRolls=testDiceRolls
    }
  }