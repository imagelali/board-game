package board;

/*4/1
* 
 * jelen pillanatban hol állunk a user storykkal. A felhasználó →

[ ] lát egy táblát, rajta szintekkel és mezőkkel.
[ ] meg tudja mondani a hősnek, hogy mennyit lépjen a pályán.
[ ] a hőssel lépve a pályán fel tudja szedni az életet adó bájitalt.
[ ] a hőssel lépve a pályán szörnyekkel találkozhat, amelyekkel meg kell, hogy küzdjön.
[x] egy küzdelem esetén a hős és a szörny kockadobásokkal döntik el a támadásaik erejét.
[x] a küzdelem esetén két dolgot lát: a támadás erejét, illetve az ellenfél életerejét a támadások után.
[ ] egy szint továbblépéséhez a hőssel mindenképp le kell, hogy győzze a szint legerősebb szörnyét.
[ ] a hőssel szinteket lépve egyre erősebb szörnyekkel találkozik.
[ ] a hőssel szinteket lépve egyre gyengébb bájitalokat szedhet fel.
[ ] ha képes legyőzni az utolsó szint főellenségét, akkor a játék a hős győzelmével ér véget.
[ ] a játék végén pedig látja, hogy hány darab szörnyet győzött le, illetve hány darab bájitalt szedett fel.

Most következik a
[ ] lát egy táblát, rajta szintekkel és mezőkkel.

 */
    
public enum FieldType {
   MONSTER,
   POTION,
   BOSS
}