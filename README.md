## OOP

> Languages or concepts which support Encapsulation, Abstraction,Inheritance and Poly are object oriented.

**Encapsulation**
It describes the idea of bundling data and methods that work on that data within one unit. (a class in Java)

**Inheritance**
It is a mechanism where you can to derive a class from another class for a hierarchy of classes that share a set of attributes and methods.

**Abstraction**
It is the concept of object-oriented programming that "shows" only essential attributes and "hides" unnecessary information. The main purpose of abstraction is hiding the unnecessary details from the users.

**Polymorphism**
The word polymorphism is used in various contexts and describes situations in which something occurs in several different forms. In computer science, it describes the concept that objects of different types can be accessed through the same interface. Each type can provide its own, independent implementation of this interface.

## SOLID

> When developing an OO design you should strive to be SOLID.

**Single Responsibility Principle**
Every module, class or function in a computer program should have responsibility over a single part of that program's functionality, and it should encapsulate that part.

> Robert C. Martindefines a responsibility as a _reason to change_, and concludes that a class or module should have one, and only one, reason to be changed.

As an example, consider a module that compiles and prints a report. Imagine such a module can be changed for two reasons. First, the content of the report could change. Second, the format of the report could change. These two things change for different causes. The single-responsibility principle says that these two aspects of the problem are really two separate responsibilities, and should, therefore, be in separate classes or modules. It would be a bad design to couple two things that change for different reasons at different times.

**Open/Closed Principle**
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

> Unfortunately, Bertrand Mayer proposes to use inheritance to achieve this goal.

Inheritance introduces tight coupling if the subclasses depend on implementation details of their parent class.
That’s why Robert C. Martin and others redefined the Open/Closed Principle to the Polymorphic Open/Closed Principle. It uses interfaces instead of superclasses to allow different implementations which you can easily substitute without changing the code that uses them. The interfaces are closed for modifications, and you can provide new implementations to extend the functionality of your software.

**Liskov Substitution Principle**

> Let q(x) be a property provable about objects of x of type T. Then q(y) should be true for objects y of type S where S is a subtype of T.

The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. That requires the objects of your subclasses to behave in the same way as the objects of your superclass.

An overridden method of a subclass needs to accept the same input parameter values as the method of the superclass. That means you can implement less restrictive validation rules, but you are not allowed to enforce stricter ones in your subclass.

Similar rules apply to the return value of the method. The return value of a method of the subclass needs to comply with the same rules as the return value of the method of the superclass. You can only decide to apply even stricter rules by returning a specific subclass of the defined return value, or by returning a subset of the valid return values of the superclass.

**Interface Segregation Principle**

> A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them. Such shrunken interfaces are also called  role interfaces.

**Dependency Inversion Principle**

> High-level modules should not depend on low-level modules. Both should depend on abstractions.  (interface)
> Abstractions should not depend on details. Details (implementations) should depend on abstractions.

In object-oriented design, the dependency inversion principle is a specific form of loosely coupling software modules. When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed, thus rendering high-level modules independent of the low-level module implementation details. 

## interface, class

Az interfész azt mondja meg, hogy az őt implementáló osztályoknak milyen publikus függvényei kell, hogy legyenek. Ezek a függvények csak deklarálva vannak, nem implementálva! Egy interfésznek nincsenek változói, de lehetnek konstansai. Egy interfész kiterjeszthet egyszerre több más interfészt is. Interfészt önmagában példányosítani nem lehet (kivétel anonymus-class).
Java 8 default method: "Add functionality without break"

Egy osztály adatokat foglal magába (osztályváltozók) és függvényeket nyújt, amelyekkel műveleteket hajt végre a magában tárolt adatokon. Egy osztály maximum egy másik osztályt terjeszthet ki (nincs többszörös öröklés), de egyszerre több interfészt implementálhat.

## abstract class

Az abstract class-ból származtatni kell, hogy használható legyen. Az absztrakt osztály sablonként szolgál, nem példányosítható, tartalmazhat statikus adatokat. Ha egy osztálynak van legalább egy absztrakt függvénye, akkor az osztály maga is absztrakt, és ezt az osztályt így is kell deklarálni. (`abstract` kulcsszó)
Egy osztályt lehet absztraktnak deklarálni akkor is, ha nincs egyetlen absztrakt függvénye sem.

## Mire való a `static` Java-ban?

Egy statikus függvény, vagy adattag az osztályhoz kötött. Ahhoz, hogy azt elérjük nem kell magát az osztályt példányosítani. Egy statikus függvényt nem lehet override-olni, mivel osztályhoz kötött, nem példányhoz. Egy statikus függvényt (vagy adattagot) el lehet árnyékolni egy származtatott osztályban ugyanolyan nevű és szignatúrájú függvénnyel. Egy osztályhoz kötött függvényt nem lehet override-olni egy nem statikus függvénnyel!

## Többszörös öröklődés támogatott-e Java-ban?

Osztály szinten nem, egy osztálynak csak egy ősosztálya lehet, de egy osztály több interfészt is implementálhat.

##  Tudsz-e oylan nyelvet ahol a többszörös öröklődés támogatott? Mi lehet ezzel a probléma?

## Mi a különbség a konstruktor és egy függvény között?

Konstruktora csak osztálynak van (interfésznek nincs!). A konstruktor egy olyan függvény, amely példányosít egy osztályt. Ugyan az a neve, mint az osztálynak, nincs visszatérési értéke, és a `new` operátor segítségével hívjuk fel.

Az általános függvényeknek van saját nevük, visszatérési értékük (amely lehet void is) és a pont (.) operatárral lehet felhívni azokat.

## Láthatósági módosítók

A láthatósági módosítók befolyásolják, hogy egy osztály, illetve annak változói, függvényei láthatóságát, azaz, hogy más osztályokból hogyan érhetők el.

 1. `public`: mindenhol látható
 2. `protected`: az adott osztályban, annak leszármazottaiban és az
    osztályt magába foglaló package összes osztályában látható.
 3. `private`: csak az adott osztályban látható.
 4. `default`: ez az alapértelmezett, ha nem írunk le semmilyen
    láthatósági módosítót. Az adott package-ben látható.

Egy interfészben deklarált összes függvény és konstans publikus, nem kötelező kiírni a `public` kulcsszót.

## Lefordul-e?

    interface A { int foo(); }
    interface B { boolean foo(); }
    class AB implements A, B { ... }

Nem mert a `foo()` függvény nem szereplehet ugyan azzal a paraméter listával különböző visszatérési értékkel.

## Lefordul-e?

    interface A { int foo(); }
    interface B extends A { boolean foo(); }

Nem mert a `foo()` függvény nem szereplehet ugyan azzal a paraméter listával különböző visszatérési értékkel.

## Lehet-e a main függvény private?

Az osztály lefordul, de nem futtatható. `("Main method not public.")`

## Mi történik, ha nem adom meg a public láthatósági módosítót a main függvénynek?

Lefordul, de nem futtatható. `("NoSuchMethodError")`

## Mi az első eleme a `main` függvény String tömbjének?

A tömb üres, nincs egyetlen eleme sem (ellentétben a C/C++-szal, ahol a tömb első eleme a program neve)

## Ha a program indulásakor nem adok meg egy paramétert sem, akkor a main függvény String tömbje null, vagy üres?

Üres, semmi esetre sem `null`!

## Lehet-e egy alkalmazásban több `main` függvény?

Lehet, de a program indításakor a JVM csak abban az osztályban keresi a main függényt, amellyel elindítottuk.

## Lehet-e egy osztályban több main függvény?

Nem, fordítási hiba.

## Collection framework

A Collection Framework a gyakran használt adatstruktúrák, adatszerkezetek gyűjteménye, pl.: `Collection`, `List`, `Set`, `Queue`, `Map`, stb. Ezek a struktúrák interface-ekkel vannak deklarálva, és több különböző implementációjuk van magában a framework-ben.

## `Map` vs. `HashMap` vs. `HashTable`

A `Map` egy interfész, amely kulcs-érték párokat tárol.

A `HashMap` a `Map` interface egy implementációja, ahol a kulcsok a hash kódjuk alapján vannak szétszórva. Ez az implementáció nem szinkronizált. A `null` referencia is lehet kulcs.

A `HashTable` a `Map` interfészt ugyan úgy implementálja, mint a `HashMap`, a különbség annyi, hogy függvényei szinkronizáltak és a `null` érték nem szerepelhet a kulcsok között.

## `List` vs. `ArrayList` vs. `LinkedList` vs. `Vector`

A `List` egy interfész, amely a lista adatszerkezetet deklarálja. A benne található elemek indexelve vannak, egy elem többször is előfordulhat.

Az `ArrayList` a `List` interfész egy implementációja, amely az elemeket egy tömbben tárolja, ha szükséges a tömb méretét megváltoztatja. Előnye, hogy gyorsan el lehet érni véletlenszerűen az elemeket. Hátránya, hogy az összes elemen végigiterálni lassú, mert a tömbbön a `[]` operátor minden egyes alkalommal megnézi, hogy nem történt-e alul vagy túlidnexelés.

A `LinkedList` a `List` interfész egy implementációja, amely az elemeket láncolt listában tárolja. Előnye, hogy gyorsan végig lehet interálni az összes elemen. Hátránya a lassúbb véletlenszerű elérés.

A `Vector` teljesen megegyezik az `ArrayList`-tel, csaupán annyi a különbség, hogy a függvényei szinkronizáltak.

## Módosíthatatlan lista?!

Adott az alábbi osztály:

    class Car {
    
        private final List<Tire> tires = new ArrayList<Tire>();
        
        public void setTires(List<Tire> tires) {
	        this.tires.clear();
	        this.tires.addAll(tires);
		}
		
	    public void addTire(Tire tire) { this.tires.add(tire); }
	    
	    public List<Tire> getTires() { return Collections.unmodifiableList(this.tires); }
    }

## Mit ír ki az alábbi kód?

    Car car = new Car();
    car.addTire(new Tire());
    car.addTire(new Tire());
    List<Tire> tires = car.getTires();
    System.out.println("Before: " + tires.size());
    car.setTires(tires);
    System.out.println("After1: " + car.getTires().size());
    System.out.println("After2: " + tires.size());

Megoldás:

`2, 0, 0;` mert az `unmodifiableList` bár nem módosítható, de nem készít másolatot az eredeti listáról, hanem magábafoglalja azt (encapsulate), delegálja annak a lekérdező függvényeket, és csak módosító függvényekre dob egy `UnsupportedOperationException`-t.

## Referencia vs. Érték

Az objektumokra referenciákkal hivatkozunk. Primitív típusoknak vannak értékeik. Amikor egy objektumot átadunk egy függvénynek paraméterként, vagy egy objektummal térünk vissza, akkor nem az objektumot magát adjuk át, hanem a rá mutató referencia másolatát. Azaz Java-ban értékszerinti paraméter átadás van.

## Mi a különbség az `==` operátor és az `equals` függvény között?

Az `==` operátor ellenőrzi, hogy két primitív értéke egyenlő-e, vagy két referencia ugyan arra az objektumra mutat-e. Az `equals()` függvény az `Object` osztályban definiált függvény, így minden java osztályban megtalálható. Ez a függvény igazzal tér vissza, ha a két objektum megegyezik.

## Milyen követelményeknek kell megfelelnie az equals függvénynek?

 1. Reflexív: `a.equals(a)`
 2. Szimmetrikus: `ha a.equals(b)`, akkor `b.equals(a)`
 3. Tranzitív: ha `a.equals(b)` és `b.equals(c)`, akkor `a.equals(c)`

## Mi a kapcsolat az `equals` és a `hashCode` függvények között, hol van ennek szerepe?

Az `equals` és `hashCode` függvények az `Object` osztályban vannak deklarálva/definiálva, a következő a kapcsolatuk:

 1. Ha két objektum egyenlő, akkor ugyanaz a hash kódjuk:
    
        a.equals(b) ===> (a.hashCode() == b.hashCode())
 2. Ha két objektum hash kódja különböző, akkor a két objektum
    különbözik egymástól:
    
        a.hashCode() != b.hashCode() ===> !a.equals(b)
 3. Ha két objektum hash kódja megegyezik, az még nem biztosítja, hogy a
    két objektum megegyezik.
 4. Ha egy objektumtól egyszer elkértük a hash kódját, akkor attól az
    objektumtól akármikor is kérjük el újra a hash kódot, mindig ugyan
    azt az értéket kell kapnunk!

Szerepe ott van, amikor egy objektumot valamilyen hash adatszerkezetben tároljuk, például `HashSet`, `HashMap`, `HashTable`.

Hash függvény értékének számításához ajánlott immutable változókat használni!

## What is the default implementation of hashCode()?

The value returned by the default implementation of hashCode() is called identity hash code.

`public native int hashCode();`

## Helyes-e az a hash függvény, amely mindig ugyanazzal az értékkel tér vissza?

Pl.: `class X { public int hashCode() { return 1; } }`

Igen helyes, mert megfelel az előzőekben látható "szerződésnek".

## Mi az az `immutable`?

Az `immutable` oylan osztály, amely példányosításkor kap egy állapotot (a változói kapnak valami értéket), és ez az állapot többé nem változik (pl.: `String`, a primitív típusok wrapper osztályai: `Integer`, `Double` stb.). Az ilyen osztályok példányváltozói jellemzően `final` kulcsszóval vannak ellátva.

## Milyen operátorok vannak a Java-ban?

 1. Értékadó: `=  +=  -=  *=  /=`
 2. Relációs: `== != < <= > >=`
 3. Logikai: `&& & || | ^`
 4. Aritmetikai: `+ - / * % ++ --`
 5. bit módosító: `& | ^ ~ ! << >>`
 6. feltételes: `?:`

## Overrideolhatók-e az operátorok Java-ban?

Nem.

## `&&` vagy `&`?

    Object x = null;
    if (null != x && 0 != x.hashCode()) { }
    if ( (null != x) & (0 != x.hashCode()) ) { }

## Mi történik?

Az 5. sorban `NullPointerException` mert a `&` mohó-operátor (kiértékeli az operátor mindkét oldalán található kifejezéseket), míg a `&&` lusta-operátor (csak a minimumot értékeli ki, ha a baloldal kiértékelése után után a teljse kifejezés értéke meghatározható, akkor a jobboldalt már nem értékeli ki, ezt a technikát hívják még rövidzárnak - short-cut.

## Mik a primitív típusok, a wrapper class-ok, mi az az autoboxing?

#### primitív típusok (Java-ban nincs előjel nélküli egész típus!)

    boolean, byte, char, short, int, long, float, double, void

#### wrapper osztály:

Az adott primitív típust magába foglaló immutable  osztály. (pl.: `Integer`, `Boolean`, `Float` stb.)

#### autoboxing:

Automatikus átalakítás primitív értékről wrapper objektumra és vissza.

Nem kell a programozónak a konverzióval foglalkozni, rövidebb kód.

    Integer.valueOf(3).intValue();

Potenciális `NullPointerException` lehetőség.

    Integer x = null;
    int a = x; // e helyett lenne: a = x.intValue()

## final, finally, finalize

### Mi a különbség köztük?

A `final` kulcsszó egy osztály, változó, függvény vagy paraméter változtathatóságát befolyásolja. Az ezzel a kulcsszóval ellátott osztályból nem lehet származtatni, egy ilyen változó, vagy paraméter nem módosítható, egy ilyen függvényt nem lehet felüldefiniálni.

A `finally` kulcsszónak a kivételkezelésben van szerepe: `try { .. } catch .. finally { ... } vagy try { ... } finally { ... }`. A `finally` blokkban található kód mindenképpen lefut. Akkor is ha a try blokkban hiba történt, ez esetben a `catch` blokk után, és akkor is, ha nem történt semmilyen hiba, ez esetben a `try` blokk után.

A `finalize()` egy `protected` függvény, amelyet a garbage collector hív fel, amikor észleli, hogy arra az objektumra nem mutat több referencia.

## Double.NaN, Double.isNaN()

`NaN` - Not-a-Number. Nagyon kis számok osztásával kapható eredmény. A `NaN` semmivel sem egyenlő, még önmagával sem! A `Double.isNaN()` függvénnyel lehet lekérdezni, hogy egy művelet eredménye `NaN`-e.

## Mi a szinkronizáció szerepe a többszálúságban?

A szinkronizáció szerepe a többszálúságban az, hogy vezéreljük a szálak hozzáférését a megosztott erőforrásokhoz. A synchronized kulcsszóval biztosítjuk, hogy egyszerre csak egy szál futhasson egy bizonyos kódrészletet.

## Miért fontos a szinkronizáció?

Szinkronizáció nélkül előfordulhat, hogy egy szál módosít egy adatot, miközben egy másik szál is épp azon dolgozik (kiolvassa, vagy szintén írja). Ez általában hibához vezet.

### Ismertesse a különböző módjait a thread-ek használatának!

Implementáljuk a `Runnable` interfészt és azzal példányosítjuk a `Thread` osztályt.
Örököltetünk a `Thread` osztályból és override-oljuk a `run()` függvényt.

Az előnye az 1-es megoldásnak, hogy tetszőleges osztállyal implementálhatjuk az interfészt.

## synchronize, volatile

### Mikor, hol melyiket használjuk?

Threadek szinkronizálásához.

`synchronize`: blokk-hoz illetve függvénynél alkalmazható.

 - blokk esetén meg kell mondani melyik objektumra szinkronizáljon:

    synchronize (`<egy objektum>`) { ... }

 - függvény esetében az adott objektum példányára szinkronizál
 - statikus függvény esetén az adott osztály objektumra szinkronizál

`volatile`: változókra

## Mi a különbség a static public void és a public static void között?

A kettő ugyan az.

## Hogyan van megoldva java-ban a generic?

Csak nyelvi elem. Tipus törléssel (type-erasion) fordításkor. A .class file-ok kompatibilisek a korábbiakkal.

## Lehet-e primitiv típus a típus-paraméter?

Nem, típus-paraméter csak osztály, vagy interface lehet.

## Adott a következő pár sor. Lefordul-e, ha nem, akkor hol vannak a problémák?

    List<Integer> intList = new ArrayList<Integer>();
    List<Number> numList = intList;
    Number num = numList.get(0);
    numList.add(Double.valueOf(2.0));

Fordítási hiba a második sorban. Egy double értéket adunk az `intList`-hez a negyedik sorban!

### A negyedik sort figyelmen kívül hagyva hogyan kellene módosítani, hogy leforduljon?

    List<? extends Number> numList = intList;

### Mi ennek a következménye a negyedik sort is figyelembe véve?

Fordítási hiba a negyedik sorban.

## Mi a különbség az override és az overload között?

**overloading**: egy függvény szignatúráját megváltoztatjuk.

    class X {
    void foo() { ... }
    boolean foo()  { return false; }
    }

**overriding**: egy ősosztálybeli függvényt felüldefiniálunk.

### Lehet-e csak a visszatérés típusát módisítani?

Nem.

## Mire való az `@Override` annotáció (Java 5-től)?

Függvényeket lehet vele megjelölni, és a fordítónak azt mondjuk meg vele, hogy az adott függvény override-ol egy ősosztálybeli függvényt. Amennyiben nincs megfelelő szignatúrájú függvény egyik ősosztályban sem, akkor fordítási hibát kapunk.

**Jelentősége**: fordítási időben kdierül, hogy ha valamit elírtunk és emiatt egy függvényt véletlenül overloadoltunk override helyett.

## Mi az a `varargs`, milyen megkötések vannak a használatára?

pl.: `void foo(String format, Object... params) { ... }`

Egy függvénynek csak egy varargs paramétere lehet és az is csak az utolsó praméterként. Az alábbiak helytelenek:

    void foo(int... params, String str) { ... }
    void bar(int... params, Object... objects) { ... }

## Mi az eredmény és miért?

    class X {
	    public static main(String... args) {
		    System.out.println(foo("a") + foo("a", "a") + foo("a" + "a" + "a"));
	    }
	    public static String foo(String a) { return "0"; }
	    public static String foo(String a, String b) { return "1"; }
	    public static String foo(String a, String b, String c) { return "2"; }
	    public static String foo(String... args) { return "3"; }
    }

"`012`" az eredmény, mert ilyenkor a fix paraméterek fontosabbak!

### Kikényszeríthető-e a "`333`" eredmény?

Igen, ha a paramétert tömbként adjuk át.

## Mi a (de)szerializáció, mire való mi a `transient` kulcsszó szerepe?

Objektumokat lehet adatfolyammá (stream-mé) alakítani a szerializációval, deszerializációval pedig adatfolyamból tudunk objektumokat előállítani.

Objektumok állapotának mentésére, visszatöltésére, tárolására, adatcsatornákon való továbbításra használják.

A `transient` kulcsszóval megjelölt példányváltozók (a `transient` kulcsszó csak példányváltozók esetében használható) nem lesznek szerializálva és értéket se kapnak deszerializálás során.

## Mik azok a kivételek?

A kivételek valamilyen működésbeli hibát jeleznek, amelyet a hiba fellépésnek a helyén/pillanatában nem tudunk kezelni.

## Mik a kivételek nyelvi eszközei Java-ban?

kulcsszavak: `throw`, `throws`, `try`, `catch`, `finally`
A kivételek az `Exception` osztályból származnak.

## Lehet-e `finally` blokkban kivételt dobni?

Igen, lehet.

## Milyen kivételek vannak a Java-ban, melyiknek mi a szerepe?

 **checked**: Olyan működésbeli hibára utal, amelyet kezelni kell (pl.: meg akarunk nyitni egy fájlt, de az nem létezik). Az `Exception`, de nem a `RuntimeException` osztályból származik.
 
 **unchecked**: Általában programozási hibára utal (pl: 0-val való osztás), A `RuntimeException` osztályból származik. 
 
 **error**: Hiba történt    a JVM-ben (`OutOfMemoryError`,
   `StackOverflowError`, ...) az `Error` osztályból származik.

## Mi a különbség a checked, illetve az unchecked exception-ök között?

**checked**: kötelező elkapni, vagy a függvény deklarációjában a továbbdobásnak/terjedésnek lehetőséget biztosítani.

**unchecked**: a `RuntimeException`-ből származik, se elkapni nem kötelező, se a továbbdobás/terjedési lehetőséget biztosítani.

## El lehet kapni egy `Error`-t a programunkban?

Igen, el. Bármit el lehet kapni, amely a `Throwable` osztályból lett származtatva.

## Lehet-e egy `@Override`-olt metódus `throws` deklarációját kiegészíteni további `Exception`-nel?

Nem (bizonyos megkötésekkel igen, pl.: fel lehet sorolni unchecked `Exception`-öket, vagy ha az ősosztálybeli függvény pl. `IOException`-t dob, akkor a származtatott osztályban, ahol felüldefiniálom, ott dobhatok bármit, amely az `IOException`-ből származik, pl. `FileNotFoundException`-t.)

## Lehet-e egy `@Override`-olt metódus `throws` deklarációját szűkíteni?

Igen, lásd előző.

## Mi a garbage collection célja, mikor használjuk?

A Java-ban nem kell foglalkozni a lefoglalt memória felszabadításával, ez a garbage collector (gc) feladata. Ha egy objektumra nincs több hivatkozás (nem mutat rá több referencia), akkor az objektum által lefoglalt memória terület felszabadítható. Amikor a gc ezt észreveszi, akkor felhívja az objektum finalize() függvényét, mielőtt a memóriát felszabadítaná.

Egy objektum akkor is felszabadítható, ha egy olyan objektum gráfnak az eleme, amelynek egyik elemére sincs a gráfon kívülről hivatkozás (a gráfon belül az objektumok tetszőlegesen mutogathatnak egymásra). Ez esetben a gráf összes eleme felszabadítható.

## Mi az a WeakReference?

Az előző leírást pontosítva: egy objektum által lefoglalt memória felszabadítható, ha az adott objektumra nincs több hivatkozás, vagy csak WeakReference-en keresztül hivatkozunk rá. Ha WeakReference-en keresztül hivatkozunk egy objektumra és azt a gc felszabadította, akkor a WeakReference `null` pointerre fog a továbbiakban mutatni.

Hasonlóan objektum gráfokra is.

## Létezik-e Java-ban memory-leak?

Mivel a lefoglalt memóriát nem tudjuk közvetlenül felszabadítani, azt a gc teszi meg helyettünk, ezért  azt hihetnénk, hogy Java-ban nem létezik memory-leak. Létezik olyan szituáció, hogy egy objektumra akaratlanul is hivatkozunk (pl. egy statikus változón keresztül). Ilyenkor a gc úgy érzékeli, hogy az objektum még nem szbadítható fel. Ezt a Java-ban általában reference-leak-nek hívják. Ritka programozási hiba.

## Készíts egy stack osztályt: `isEmpty()`, `push()`, `pop()`

    public static class Stack {
	    private Object[] data = new Object[8];
	    private int index;
	    
	    public void push(final Object o) {
		    if (data.length == data.length) { // index
			    data = Arrays.copyOf(data, data.length << 1);
		    }
		    data[index++] = o;
	    }
		public Object pop() {
			if (isEmpty()) {
				throw new RuntimeException("The stack is empty!");
			}
			Object o = data[--index];
			data[index] = null; // Ha ez nincs akkor reference leak vana stack-ben!
			return o;
		}
		public boolean isEmpty() {
			return 0 == index;
		}
    }

## A `String` primitív típus?

Nem.

## Hogyan módosítok egy `String`-et?

A `String` immutable, nem módosítható. A `String` osztály  összes függvénye egy újabb `String`-gel tér vissza.

## `StringBuilder` vs. `StringBuffer`

Mindkettő `String`-ek összefűzésére szolgál. Ugyan azok a műveleteik, csak annyi a különbség hogy a `StringBuffer` függvényei szinkronizáltak.

## Egy üres .java fájl helyes-e?

Igen.

## Lehet-e több osztály egy .java fájlban?

Igen, de `public`-ból csak egy!

## Változók típusai (példány, lokális, statikus)?

    class X {
	    static int i; // statikus változó
	    int j; // példányváltozó
	    X () {
		    int k; // lokális változó
	    }
    }

## Mit ír ki? System.out.println("1" + 3);

Válasz: 13

## Memory Management in Java

In Java, memory management is the process of allocation and de-allocation of objects, called Memory management. Java does memory management automatically. Java uses an automatic memory management system called a garbage collector. Thus, we are not required to implement memory management logic in our application. Java memory management divides into two major parts:

JVM Memory Structure
Working of the Garbage Collector

### JVM Memory Structure

JVM creates various run time data areas in a heap. These areas are used during the program execution. The memory areas are destroyed when JVM exits, whereas the data areas are destroyed when the thread exits.

### Method Area

Method Area is a part of the heap memory which is shared among all the threads. It creates when the JVM starts up. It is used to store class structure, superclass name, interface name, and constructors. The JVM stores the following kinds of information in the method area:

A Fully qualified name of a type (ex: String)
The type's modifiers
Type's direct superclass name
A structured list of the fully qualified names of super interfaces.

### Heap Area

Heap stores the actual objects. It creates when the JVM starts up. The user can control the heap if needed. It can be of fixed or dynamic size. When you use a new keyword, the JVM creates an instance for the object in a heap. While the reference of that object stores in the stack. There exists only one heap for each running JVM process. When heap becomes full, the garbage is collected. For example:

`StringBuilder sb= new StringBuilder(); `

The above statement creates an object of the StringBuilder class. The object allocates to the heap, and the reference sb allocates to stack. Heap is divided into the following parts:

Young generation - this is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up
Survivor space - Part of the young gen, but survived the minor GC cycle
Old generation - this is where long surviving objects are stored. When objects are stored in the Young Generation, a threshold for the object's age is set and when that threshold is reached, the object is moved to the old generation
Permanent generation - this consists of JVM metadata for the runtime classes and application methods
Code Cache

### Reference Type

There are four types of references: Strong, Weak, Soft, and Phantom reference. The difference among the types of references is that the objects on the heap they refer to are eligible for garbage collecting under the different criteria.

### Stack Area

Stack Memory in Java is used for static memory allocation and the execution of a thread. It contains primitive values that are specific to a method and references to objects that are in a heap, referred from the method.

Access to this memory is in Last-In-First-Out (LIFO) order. Whenever a new method is called, a new block on top of the stack is created which contains values specific to that method, like primitive variables and references to objects.

When the method finishes execution, it’s corresponding stack frame is flushed, the flow goes back to the calling method and space becomes available for the next method.

## Garbage collection

JVM controls the garbage collector. JVM decides when to perform the garbage collection. We can also request to the JVM to run the garbage collector. But there is no guarantee under any conditions that the JVM will comply. JVM runs the garbage collector if it senses that memory is running low. When Java program request for the garbage collector, the JVM usually grants the request in short order. It does not make sure that the requests accept.

Every Java program has more than one thread. Each thread has its execution stack. There is a thread to run in Java program that is a main() method. Now we can say that an object is eligible for garbage collection when no live thread can access it. The garbage collector considers that object as eligible for deletion. If a program has a reference variable that refers to an object, that reference variable available to live thread, this object is called reachable.

Reference Counting

Reference counting GC algorithms associate a reference count with each object. These algorithms consider an object to be alive as long as the number of references to that object is greater than zero. Usually, the runtime stores the reference count in the object header.

However, there is still one serious issue with reference counting: it can't reclaim cyclic references.

Tracing collectors will determine the objects' reachability by tracing them from a set of root objects, known as GC roots.

We can think of GC roots as objects that we're sure are alive. (Local variables or anything stack frames are referring to right now, Static variables etc..)

# SQL

## 5. Use WHERE instead of HAVING to define filters

The goal of an efficient query is to pull only the required records from the database. Per the  [SQL Order of Operations](https://www.sisense.com/blog/sql-query-order-of-operations/),  **HAVING**  statements are calculated after WHERE statements. If the intent is to filter a query based on conditions, a WHERE statement is more efficient.

For example, let’s assume 200 sales have been made in the year 2016, and we want to query for the number of sales per customer in 2016.

`SELECT Customers.CustomerID, Customers.Name, Count(Sales.SalesID)  
FROM Customers  
INNER JOIN Sales  
ON Customers.CustomerID = Sales.CustomerID  
GROUP BY Customers.CustomerID, Customers.Name  
HAVING Sales.LastSaleDate BETWEEN #1/1/2016# AND #12/31/2016#`

This query would pull 1,000 sales records from the Sales table, then filter for the 200 records generated in the year 2016, and finally count the records in the dataset.

In comparison,  **WHERE**  clauses limit the number of records pulled:

`SELECT Customers.CustomerID, Customers.Name, Count(Sales.SalesID)  
FROM Customers  
INNER JOIN Sales  
ON Customers.CustomerID = Sales.CustomerID  
WHERE Sales.LastSaleDate BETWEEN #1/1/2016# AND #12/31/2016#  
GROUP BY Customers.CustomerID, Customers.Name`

This query would pull the 200 records from the year 2016, and then count the records in the dataset. The first step in the  **HAVING**  clause has been completely eliminated.

**HAVING**  should only be used when filtering on an aggregated field. In the query above, we could additionally filter for customers with greater than 5 sales using a HAVING statement.

`SELECT Customers.CustomerID, Customers.Name, Count(Sales.SalesID)  
FROM Customers  
INNER JOIN Sales  
ON Customers.CustomerID = Sales.CustomerID  
WHERE Sales.LastSaleDate BETWEEN #1/1/2016# AND #12/31/2016#  
GROUP BY Customers.CustomerID, Customers.Name  
HAVING Count(Sales.SalesID) > 5`

## 4. Create joins with INNER JOIN (not WHERE)
SELECT Customers.CustomerID, Customers.Name, Sales.LastSaleDate  
FROM Customers, Sales  
WHERE Customers.CustomerID = Sales.CustomerID

This type of join creates a Cartesian Join, also called a Cartesian Product or Cross Join.

In a Cartesian Join, all possible combinations of the variables are created. In this example, if we had 1,000 customers with 1,000 total sales, the query would first generate 1,000,000 results, then filter for the 1,000 records where CustomerID is correctly joined. This is an inefficient use of database resources, as the database has done 100x more work than required. Cartesian Joins are especially problematic in large-scale databases, because a Cartesian Join of two large tables could create billions or trillions of results.

SELECT Customers.CustomerID, Customers.Name, Sales.LastSaleDate  
FROM Customers  
INNER JOIN Sales  
ON Customers.CustomerID = Sales.CustomerID

The database would only generate the 1,000 desired records where CustomerID is equal.

## Join types
**Example Tables**
Assume we have the following two tables. **Table A** is on the left, and **Table B** is on the right. We'll populate them with four records each.
```
id name       id  name
-- ----       --  ----
1  Pirate     1   Rutabaga
2  Monkey     2   Pirate
3  Ninja      3   Darth Vader
4  Spaghetti  4   Ninja
```

**Inner join** produces only the set of records that match in both Table A and Table B.  

```
SELECT * FROM TableA INNER JOIN TableB ON TableA.name = TableB.name
	
id name       id  name
-- ----       --  ----
1  Pirate     2   Pirate
3  Ninja	  4   Ninja
```


**Full outer join** produces the set of all records in Table A and Table B, with matching records from both sides where available. If there is no match, the missing side will contain null.

```
SELECT * FROM TableA FULL OUTER JOIN TableB ON TableA.name = TableB.name
	
id		name		id		name
-- 		----       	--		----
1  		Pirate 	 	2   	Pirate  
2  		Monkey		null  	null  
3 		Ninja 		4 		Ninja  
4 		Spaghetti 	null	null  
null  	null 		1 		Rutabaga  
null  	null 		3 		Darth Vader
```

**Left outer join** produces a complete set of records from Table A, with the matching records (where available) in Table B. If there is no match, the right side will contain null.

```
SELECT * FROM TableA LEFT OUTER JOIN TableB ON TableA.name = TableB.name
	
id  name       id    name
--  ----       --    ----
1   Pirate     2     Pirate
2   Monkey     null  null
3   Ninja      4     Ninja
4   Spaghetti  null  null
```
 To produce the set of records only in Table A, but not in Table B, we perform the same left outer join, then exclude the records we don't want from the right side via a where clause.
```
SELECT * FROM TableA 
LEFT OUTER JOIN TableB 
ON TableA.name = TableB.name 
WHERE TableB.id IS null
```
To produce the set of records unique to Table A and Table B, we perform the same full outer join, then exclude the records we don't want from both sides via a where clause,
```
SELECT * FROM TableA
FULL OUTER JOIN TableB
ON TableA.name = TableB.name
WHERE TableA.id IS null
OR TableB.id IS null
```


# Spring

## Milyen típusai vannak a DI-nek Springben?

Constructor Injection —enforcing immutability
Setter injection — enjoy the mutability
Field injection — nobody likes it? (reflection)

## Hányszor hívódik meg a carRepository() ?

```
@Configuration  
public class CarServiceConfiguration {  
  
	@Bean  
	public CarService carService() {  
		CarServiceImpl carService = new CarServiceImpl();  
		carService.setCarRepository(carRepository());  
		return carService;  
	}  
  
	@Bean  
	public LicenceService licenceService() {  
	    LicenceServiceImpl licenceService = new LicenceServiceImpl();  
		licenceService.setCarRepository(carRepository());  
		return licenceService;  
	}  
  
	@Bean  
	public CarRepository carRepository() {  
	  CarRepositoryImpl carRepository = new CarRepositoryImpl();  
	  return carRepository;  
	}
  
}
```
