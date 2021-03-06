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
That???s why Robert C. Martin and others redefined the Open/Closed Principle to the Polymorphic Open/Closed Principle. It uses interfaces instead of superclasses to allow different implementations which you can easily substitute without changing the code that uses them. The interfaces are closed for modifications, and you can provide new implementations to extend the functionality of your software.

**Liskov Substitution Principle**

> Let q(x) be a property provable about objects of x of type T. Then q(y) should be true for objects y of type S where S is a subtype of T.

The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. That requires the objects of your subclasses to behave in the same way as the objects of your superclass.

An overridden method of a subclass needs to accept the same input parameter values as the method of the superclass. That means you can implement less restrictive validation rules, but you are not allowed to enforce stricter ones in your subclass.

Similar rules apply to the return value of the method. The return value of a method of the subclass needs to comply with the same rules as the return value of the method of the superclass. You can only decide to apply even stricter rules by returning a specific subclass of the defined return value, or by returning a subset of the valid return values of the superclass.

**Interface Segregation Principle**

> A client should never be forced to implement an interface that it doesn???t use, or clients shouldn???t be forced to depend on methods they do not use.

ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them. Such shrunken interfaces are also called  role interfaces.

**Dependency Inversion Principle**

> High-level modules should not depend on low-level modules. Both should depend on abstractions.  (interface)
> Abstractions should not depend on details. Details (implementations) should depend on abstractions.

In object-oriented design, the dependency inversion principle is a specific form of loosely coupling software modules. When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed, thus rendering high-level modules independent of the low-level module implementation details. 

## interface, class

Az interf??sz azt mondja meg, hogy az ??t implement??l?? oszt??lyoknak milyen publikus f??ggv??nyei kell, hogy legyenek. Ezek a f??ggv??nyek csak deklar??lva vannak, nem implement??lva! Egy interf??sznek nincsenek v??ltoz??i, de lehetnek konstansai. Egy interf??sz kiterjeszthet egyszerre t??bb m??s interf??szt is. Interf??szt ??nmag??ban p??ld??nyos??tani nem lehet (kiv??tel anonymus-class).
Java 8 default method: "Add functionality without break"

Egy oszt??ly adatokat foglal mag??ba (oszt??lyv??ltoz??k) ??s f??ggv??nyeket ny??jt, amelyekkel m??veleteket hajt v??gre a mag??ban t??rolt adatokon. Egy oszt??ly maximum egy m??sik oszt??lyt terjeszthet ki (nincs t??bbsz??r??s ??r??kl??s), de egyszerre t??bb interf??szt implement??lhat.

## abstract class

Az abstract class-b??l sz??rmaztatni kell, hogy haszn??lhat?? legyen. Az absztrakt oszt??ly sablonk??nt szolg??l, nem p??ld??nyos??that??, tartalmazhat statikus adatokat. Ha egy oszt??lynak van legal??bb egy absztrakt f??ggv??nye, akkor az oszt??ly maga is absztrakt, ??s ezt az oszt??lyt ??gy is kell deklar??lni. (`abstract` kulcssz??)
Egy oszt??lyt lehet absztraktnak deklar??lni akkor is, ha nincs egyetlen absztrakt f??ggv??nye sem.

## Mire val?? a `static` Java-ban?

Egy statikus f??ggv??ny, vagy adattag az oszt??lyhoz k??t??tt. Ahhoz, hogy azt el??rj??k nem kell mag??t az oszt??lyt p??ld??nyos??tani. Egy statikus f??ggv??nyt nem lehet override-olni, mivel oszt??lyhoz k??t??tt, nem p??ld??nyhoz. Egy statikus f??ggv??nyt (vagy adattagot) el lehet ??rny??kolni egy sz??rmaztatott oszt??lyban ugyanolyan nev?? ??s szignat??r??j?? f??ggv??nnyel. Egy oszt??lyhoz k??t??tt f??ggv??nyt nem lehet override-olni egy nem statikus f??ggv??nnyel!

## T??bbsz??r??s ??r??kl??d??s t??mogatott-e Java-ban?

Oszt??ly szinten nem, egy oszt??lynak csak egy ??soszt??lya lehet, de egy oszt??ly t??bb interf??szt is implement??lhat.

##  Tudsz-e oylan nyelvet ahol a t??bbsz??r??s ??r??kl??d??s t??mogatott? Mi lehet ezzel a probl??ma?

## Mi a k??l??nbs??g a konstruktor ??s egy f??ggv??ny k??z??tt?

Konstruktora csak oszt??lynak van (interf??sznek nincs!). A konstruktor egy olyan f??ggv??ny, amely p??ld??nyos??t egy oszt??lyt. Ugyan az a neve, mint az oszt??lynak, nincs visszat??r??si ??rt??ke, ??s a `new` oper??tor seg??ts??g??vel h??vjuk fel.

Az ??ltal??nos f??ggv??nyeknek van saj??t nev??k, visszat??r??si ??rt??k??k (amely lehet void is) ??s a pont (.) operat??rral lehet felh??vni azokat.

## L??that??s??gi m??dos??t??k

A l??that??s??gi m??dos??t??k befoly??solj??k, hogy egy oszt??ly, illetve annak v??ltoz??i, f??ggv??nyei l??that??s??g??t, azaz, hogy m??s oszt??lyokb??l hogyan ??rhet??k el.

 1. `public`: mindenhol l??that??
 2. `protected`: az adott oszt??lyban, annak lesz??rmazottaiban ??s az
    oszt??lyt mag??ba foglal?? package ??sszes oszt??ly??ban l??that??.
 3. `private`: csak az adott oszt??lyban l??that??.
 4. `default`: ez az alap??rtelmezett, ha nem ??runk le semmilyen
    l??that??s??gi m??dos??t??t. Az adott package-ben l??that??.

Egy interf??szben deklar??lt ??sszes f??ggv??ny ??s konstans publikus, nem k??telez?? ki??rni a `public` kulcssz??t.

## Lefordul-e?

    interface A { int foo(); }
    interface B { boolean foo(); }
    class AB implements A, B { ... }

Nem mert a `foo()` f??ggv??ny nem szereplehet ugyan azzal a param??ter list??val k??l??nb??z?? visszat??r??si ??rt??kkel.

## Lefordul-e?

    interface A { int foo(); }
    interface B extends A { boolean foo(); }

Nem mert a `foo()` f??ggv??ny nem szereplehet ugyan azzal a param??ter list??val k??l??nb??z?? visszat??r??si ??rt??kkel.

## Lehet-e a main f??ggv??ny private?

Az oszt??ly lefordul, de nem futtathat??. `("Main method not public.")`

## Mi t??rt??nik, ha nem adom meg a public l??that??s??gi m??dos??t??t a main f??ggv??nynek?

Lefordul, de nem futtathat??. `("NoSuchMethodError")`

## Mi az els?? eleme a `main` f??ggv??ny String t??mbj??nek?

A t??mb ??res, nincs egyetlen eleme sem (ellent??tben a C/C++-szal, ahol a t??mb els?? eleme a program neve)

## Ha a program indul??sakor nem adok meg egy param??tert sem, akkor a main f??ggv??ny String t??mbje null, vagy ??res?

??res, semmi esetre sem `null`!

## Lehet-e egy alkalmaz??sban t??bb `main` f??ggv??ny?

Lehet, de a program ind??t??sakor a JVM csak abban az oszt??lyban keresi a main f??gg??nyt, amellyel elind??tottuk.

## Lehet-e egy oszt??lyban t??bb main f??ggv??ny?

Nem, ford??t??si hiba.

## Collection framework

A Collection Framework a gyakran haszn??lt adatstrukt??r??k, adatszerkezetek gy??jtem??nye, pl.: `Collection`, `List`, `Set`, `Queue`, `Map`, stb. Ezek a strukt??r??k interface-ekkel vannak deklar??lva, ??s t??bb k??l??nb??z?? implement??ci??juk van mag??ban a framework-ben.

## `Map` vs. `HashMap` vs. `HashTable`

A `Map` egy interf??sz, amely kulcs-??rt??k p??rokat t??rol.

A `HashMap` a `Map` interface egy implement??ci??ja, ahol a kulcsok a hash k??djuk alapj??n vannak sz??tsz??rva. Ez az implement??ci?? nem szinkroniz??lt. A `null` referencia is lehet kulcs.

A `HashTable` a `Map` interf??szt ugyan ??gy implement??lja, mint a `HashMap`, a k??l??nbs??g annyi, hogy f??ggv??nyei szinkroniz??ltak ??s a `null` ??rt??k nem szerepelhet a kulcsok k??z??tt.

## `List` vs. `ArrayList` vs. `LinkedList` vs. `Vector`

A `List` egy interf??sz, amely a lista adatszerkezetet deklar??lja. A benne tal??lhat?? elemek indexelve vannak, egy elem t??bbsz??r is el??fordulhat.

Az `ArrayList` a `List` interf??sz egy implement??ci??ja, amely az elemeket egy t??mbben t??rolja, ha sz??ks??ges a t??mb m??ret??t megv??ltoztatja. El??nye, hogy gyorsan el lehet ??rni v??letlenszer??en az elemeket. H??tr??nya, hogy az ??sszes elemen v??gigiter??lni lass??, mert a t??mbb??n a `[]` oper??tor minden egyes alkalommal megn??zi, hogy nem t??rt??nt-e alul vagy t??lidnexel??s.

A `LinkedList` a `List` interf??sz egy implement??ci??ja, amely az elemeket l??ncolt list??ban t??rolja. El??nye, hogy gyorsan v??gig lehet inter??lni az ??sszes elemen. H??tr??nya a lass??bb v??letlenszer?? el??r??s.

A `Vector` teljesen megegyezik az `ArrayList`-tel, csaup??n annyi a k??l??nbs??g, hogy a f??ggv??nyei szinkroniz??ltak.

## M??dos??thatatlan lista?!

Adott az al??bbi oszt??ly:

    class Car {
    
        private final List<Tire> tires = new ArrayList<Tire>();
        
        public void setTires(List<Tire> tires) {
	        this.tires.clear();
	        this.tires.addAll(tires);
		}
		
	    public void addTire(Tire tire) { this.tires.add(tire); }
	    
	    public List<Tire> getTires() { return Collections.unmodifiableList(this.tires); }
    }

## Mit ??r ki az al??bbi k??d?

    Car car = new Car();
    car.addTire(new Tire());
    car.addTire(new Tire());
    List<Tire> tires = car.getTires();
    System.out.println("Before: " + tires.size());
    car.setTires(tires);
    System.out.println("After1: " + car.getTires().size());
    System.out.println("After2: " + tires.size());

Megold??s:

`2, 0, 0;` mert az `unmodifiableList` b??r nem m??dos??that??, de nem k??sz??t m??solatot az eredeti list??r??l, hanem mag??bafoglalja azt (encapsulate), deleg??lja annak a lek??rdez?? f??ggv??nyeket, ??s csak m??dos??t?? f??ggv??nyekre dob egy `UnsupportedOperationException`-t.

## Referencia vs. ??rt??k

Az objektumokra referenci??kkal hivatkozunk. Primit??v t??pusoknak vannak ??rt??keik. Amikor egy objektumot ??tadunk egy f??ggv??nynek param??terk??nt, vagy egy objektummal t??r??nk vissza, akkor nem az objektumot mag??t adjuk ??t, hanem a r?? mutat?? referencia m??solat??t. Azaz Java-ban ??rt??kszerinti param??ter ??tad??s van.

## Mi a k??l??nbs??g az `==` oper??tor ??s az `equals` f??ggv??ny k??z??tt?

Az `==` oper??tor ellen??rzi, hogy k??t primit??v ??rt??ke egyenl??-e, vagy k??t referencia ugyan arra az objektumra mutat-e. Az `equals()` f??ggv??ny az `Object` oszt??lyban defini??lt f??ggv??ny, ??gy minden java oszt??lyban megtal??lhat??. Ez a f??ggv??ny igazzal t??r vissza, ha a k??t objektum megegyezik.

## Milyen k??vetelm??nyeknek kell megfelelnie az equals f??ggv??nynek?

 1. Reflex??v: `a.equals(a)`
 2. Szimmetrikus: `ha a.equals(b)`, akkor `b.equals(a)`
 3. Tranzit??v: ha `a.equals(b)` ??s `b.equals(c)`, akkor `a.equals(c)`

## Mi a kapcsolat az `equals` ??s a `hashCode` f??ggv??nyek k??z??tt, hol van ennek szerepe?

Az `equals` ??s `hashCode` f??ggv??nyek az `Object` oszt??lyban vannak deklar??lva/defini??lva, a k??vetkez?? a kapcsolatuk:

 1. Ha k??t objektum egyenl??, akkor ugyanaz a hash k??djuk:
    
        a.equals(b) ===> (a.hashCode() == b.hashCode())
 2. Ha k??t objektum hash k??dja k??l??nb??z??, akkor a k??t objektum
    k??l??nb??zik egym??st??l:
    
        a.hashCode() != b.hashCode() ===> !a.equals(b)
 3. Ha k??t objektum hash k??dja megegyezik, az m??g nem biztos??tja, hogy a
    k??t objektum megegyezik.
 4. Ha egy objektumt??l egyszer elk??rt??k a hash k??dj??t, akkor att??l az
    objektumt??l ak??rmikor is k??rj??k el ??jra a hash k??dot, mindig ugyan
    azt az ??rt??ket kell kapnunk!

Szerepe ott van, amikor egy objektumot valamilyen hash adatszerkezetben t??roljuk, p??ld??ul `HashSet`, `HashMap`, `HashTable`.

Hash f??ggv??ny ??rt??k??nek sz??m??t??s??hoz aj??nlott immutable v??ltoz??kat haszn??lni!

## What is the default implementation of hashCode()?

The value returned by the default implementation of hashCode() is called identity hash code.

`public native int hashCode();`

## Helyes-e az a hash f??ggv??ny, amely mindig ugyanazzal az ??rt??kkel t??r vissza?

Pl.: `class X { public int hashCode() { return 1; } }`

Igen helyes, mert megfelel az el??z??ekben l??that?? "szerz??d??snek".

## Mi az az `immutable`?

Az `immutable` oylan oszt??ly, amely p??ld??nyos??t??skor kap egy ??llapotot (a v??ltoz??i kapnak valami ??rt??ket), ??s ez az ??llapot t??bb?? nem v??ltozik (pl.: `String`, a primit??v t??pusok wrapper oszt??lyai: `Integer`, `Double` stb.). Az ilyen oszt??lyok p??ld??nyv??ltoz??i jellemz??en `final` kulcssz??val vannak ell??tva.

## Milyen oper??torok vannak a Java-ban?

 1. ??rt??kad??: `=  +=  -=  *=  /=`
 2. Rel??ci??s: `== != < <= > >=`
 3. Logikai: `&& & || | ^`
 4. Aritmetikai: `+ - / * % ++ --`
 5. bit m??dos??t??: `& | ^ ~ ! << >>`
 6. felt??teles: `?:`

## Overrideolhat??k-e az oper??torok Java-ban?

Nem.

## `&&` vagy `&`?

    Object x = null;
    if (null != x && 0 != x.hashCode()) { }
    if ( (null != x) & (0 != x.hashCode()) ) { }

## Mi t??rt??nik?

Az 5. sorban `NullPointerException` mert a `&` moh??-oper??tor (ki??rt??keli az oper??tor mindk??t oldal??n tal??lhat?? kifejez??seket), m??g a `&&` lusta-oper??tor (csak a minimumot ??rt??keli ki, ha a baloldal ki??rt??kel??se ut??n ut??n a teljse kifejez??s ??rt??ke meghat??rozhat??, akkor a jobboldalt m??r nem ??rt??keli ki, ezt a technik??t h??vj??k m??g r??vidz??rnak - short-cut.

## Mik a primit??v t??pusok, a wrapper class-ok, mi az az autoboxing?

#### primit??v t??pusok (Java-ban nincs el??jel n??lk??li eg??sz t??pus!)

    boolean, byte, char, short, int, long, float, double, void

#### wrapper oszt??ly:

Az adott primit??v t??pust mag??ba foglal?? immutable  oszt??ly. (pl.: `Integer`, `Boolean`, `Float` stb.)

#### autoboxing:

Automatikus ??talak??t??s primit??v ??rt??kr??l wrapper objektumra ??s vissza.

Nem kell a programoz??nak a konverzi??val foglalkozni, r??videbb k??d.

    Integer.valueOf(3).intValue();

Potenci??lis `NullPointerException` lehet??s??g.

    Integer x = null;
    int a = x; // e helyett lenne: a = x.intValue()

## final, finally, finalize

### Mi a k??l??nbs??g k??zt??k?

A `final` kulcssz?? egy oszt??ly, v??ltoz??, f??ggv??ny vagy param??ter v??ltoztathat??s??g??t befoly??solja. Az ezzel a kulcssz??val ell??tott oszt??lyb??l nem lehet sz??rmaztatni, egy ilyen v??ltoz??, vagy param??ter nem m??dos??that??, egy ilyen f??ggv??nyt nem lehet fel??ldefini??lni.

A `finally` kulcssz??nak a kiv??telkezel??sben van szerepe: `try { .. } catch .. finally { ... } vagy try { ... } finally { ... }`. A `finally` blokkban tal??lhat?? k??d mindenk??ppen lefut. Akkor is ha a try blokkban hiba t??rt??nt, ez esetben a `catch` blokk ut??n, ??s akkor is, ha nem t??rt??nt semmilyen hiba, ez esetben a `try` blokk ut??n.

A `finalize()` egy `protected` f??ggv??ny, amelyet a garbage collector h??v fel, amikor ??szleli, hogy arra az objektumra nem mutat t??bb referencia.

## Double.NaN, Double.isNaN()

`NaN` - Not-a-Number. Nagyon kis sz??mok oszt??s??val kaphat?? eredm??ny. A `NaN` semmivel sem egyenl??, m??g ??nmag??val sem! A `Double.isNaN()` f??ggv??nnyel lehet lek??rdezni, hogy egy m??velet eredm??nye `NaN`-e.

## Mi a szinkroniz??ci?? szerepe a t??bbsz??l??s??gban?

A szinkroniz??ci?? szerepe a t??bbsz??l??s??gban az, hogy vez??relj??k a sz??lak hozz??f??r??s??t a megosztott er??forr??sokhoz. A synchronized kulcssz??val biztos??tjuk, hogy egyszerre csak egy sz??l futhasson egy bizonyos k??dr??szletet.

## Mi??rt fontos a szinkroniz??ci???

Szinkroniz??ci?? n??lk??l el??fordulhat, hogy egy sz??l m??dos??t egy adatot, mik??zben egy m??sik sz??l is ??pp azon dolgozik (kiolvassa, vagy szint??n ??rja). Ez ??ltal??ban hib??hoz vezet.

### Ismertesse a k??l??nb??z?? m??djait a thread-ek haszn??lat??nak!

Implement??ljuk a `Runnable` interf??szt ??s azzal p??ld??nyos??tjuk a `Thread` oszt??lyt.
??r??k??ltet??nk a `Thread` oszt??lyb??l ??s override-oljuk a `run()` f??ggv??nyt.

Az el??nye az 1-es megold??snak, hogy tetsz??leges oszt??llyal implement??lhatjuk az interf??szt.

## synchronize, volatile

### Mikor, hol melyiket haszn??ljuk?

Threadek szinkroniz??l??s??hoz.

`synchronize`: blokk-hoz illetve f??ggv??nyn??l alkalmazhat??.

 - blokk eset??n meg kell mondani melyik objektumra szinkroniz??ljon:

    synchronize (`<egy objektum>`) { ... }

 - f??ggv??ny eset??ben az adott objektum p??ld??ny??ra szinkroniz??l
 - statikus f??ggv??ny eset??n az adott oszt??ly objektumra szinkroniz??l

`volatile`: v??ltoz??kra

## Mi a k??l??nbs??g a static public void ??s a public static void k??z??tt?

A kett?? ugyan az.

## Hogyan van megoldva java-ban a generic?

Csak nyelvi elem. Tipus t??rl??ssel (type-erasion) ford??t??skor. A .class file-ok kompatibilisek a kor??bbiakkal.

## Lehet-e primitiv t??pus a t??pus-param??ter?

Nem, t??pus-param??ter csak oszt??ly, vagy interface lehet.

## Adott a k??vetkez?? p??r sor. Lefordul-e, ha nem, akkor hol vannak a probl??m??k?

    List<Integer> intList = new ArrayList<Integer>();
    List<Number> numList = intList;
    Number num = numList.get(0);
    numList.add(Double.valueOf(2.0));

Ford??t??si hiba a m??sodik sorban. Egy double ??rt??ket adunk az `intList`-hez a negyedik sorban!

### A negyedik sort figyelmen k??v??l hagyva hogyan kellene m??dos??tani, hogy leforduljon?

    List<? extends Number> numList = intList;

### Mi ennek a k??vetkezm??nye a negyedik sort is figyelembe v??ve?

Ford??t??si hiba a negyedik sorban.

## Mi a k??l??nbs??g az override ??s az overload k??z??tt?

**overloading**: egy f??ggv??ny szignat??r??j??t megv??ltoztatjuk.

    class X {
    void foo() { ... }
    boolean foo()  { return false; }
    }

**overriding**: egy ??soszt??lybeli f??ggv??nyt fel??ldefini??lunk.

### Lehet-e csak a visszat??r??s t??pus??t m??dis??tani?

Nem.

## Mire val?? az `@Override` annot??ci?? (Java 5-t??l)?

F??ggv??nyeket lehet vele megjel??lni, ??s a ford??t??nak azt mondjuk meg vele, hogy az adott f??ggv??ny override-ol egy ??soszt??lybeli f??ggv??nyt. Amennyiben nincs megfelel?? szignat??r??j?? f??ggv??ny egyik ??soszt??lyban sem, akkor ford??t??si hib??t kapunk.

**Jelent??s??ge**: ford??t??si id??ben kdier??l, hogy ha valamit el??rtunk ??s emiatt egy f??ggv??nyt v??letlen??l overloadoltunk override helyett.

## Mi az a `varargs`, milyen megk??t??sek vannak a haszn??lat??ra?

pl.: `void foo(String format, Object... params) { ... }`

Egy f??ggv??nynek csak egy varargs param??tere lehet ??s az is csak az utols?? pram??terk??nt. Az al??bbiak helytelenek:

    void foo(int... params, String str) { ... }
    void bar(int... params, Object... objects) { ... }

## Mi az eredm??ny ??s mi??rt?

    class X {
	    public static main(String... args) {
		    System.out.println(foo("a") + foo("a", "a") + foo("a" + "a" + "a"));
	    }
	    public static String foo(String a) { return "0"; }
	    public static String foo(String a, String b) { return "1"; }
	    public static String foo(String a, String b, String c) { return "2"; }
	    public static String foo(String... args) { return "3"; }
    }

"`012`" az eredm??ny, mert ilyenkor a fix param??terek fontosabbak!

### Kik??nyszer??thet??-e a "`333`" eredm??ny?

Igen, ha a param??tert t??mbk??nt adjuk ??t.

## Mi a (de)szerializ??ci??, mire val?? mi a `transient` kulcssz?? szerepe?

Objektumokat lehet adatfolyamm?? (stream-m??) alak??tani a szerializ??ci??val, deszerializ??ci??val pedig adatfolyamb??l tudunk objektumokat el????ll??tani.

Objektumok ??llapot??nak ment??s??re, visszat??lt??s??re, t??rol??s??ra, adatcsatorn??kon val?? tov??bb??t??sra haszn??lj??k.

A `transient` kulcssz??val megjel??lt p??ld??nyv??ltoz??k (a `transient` kulcssz?? csak p??ld??nyv??ltoz??k eset??ben haszn??lhat??) nem lesznek szerializ??lva ??s ??rt??ket se kapnak deszerializ??l??s sor??n.

## Mik azok a kiv??telek?

A kiv??telek valamilyen m??k??d??sbeli hib??t jeleznek, amelyet a hiba fell??p??snek a hely??n/pillanat??ban nem tudunk kezelni.

## Mik a kiv??telek nyelvi eszk??zei Java-ban?

kulcsszavak: `throw`, `throws`, `try`, `catch`, `finally`
A kiv??telek az `Exception` oszt??lyb??l sz??rmaznak.

## Lehet-e `finally` blokkban kiv??telt dobni?

Igen, lehet.

## Milyen kiv??telek vannak a Java-ban, melyiknek mi a szerepe?

 **checked**: Olyan m??k??d??sbeli hib??ra utal, amelyet kezelni kell (pl.: meg akarunk nyitni egy f??jlt, de az nem l??tezik). Az `Exception`, de nem a `RuntimeException` oszt??lyb??l sz??rmazik.
 
 **unchecked**: ??ltal??ban programoz??si hib??ra utal (pl: 0-val val?? oszt??s), A `RuntimeException` oszt??lyb??l sz??rmazik. 
 
 **error**: Hiba t??rt??nt    a JVM-ben (`OutOfMemoryError`,
   `StackOverflowError`, ...) az `Error` oszt??lyb??l sz??rmazik.

## Mi a k??l??nbs??g a checked, illetve az unchecked exception-??k k??z??tt?

**checked**: k??telez?? elkapni, vagy a f??ggv??ny deklar??ci??j??ban a tov??bbdob??snak/terjed??snek lehet??s??get biztos??tani.

**unchecked**: a `RuntimeException`-b??l sz??rmazik, se elkapni nem k??telez??, se a tov??bbdob??s/terjed??si lehet??s??get biztos??tani.

## El lehet kapni egy `Error`-t a programunkban?

Igen, el. B??rmit el lehet kapni, amely a `Throwable` oszt??lyb??l lett sz??rmaztatva.

## Lehet-e egy `@Override`-olt met??dus `throws` deklar??ci??j??t kieg??sz??teni tov??bbi `Exception`-nel?

Nem (bizonyos megk??t??sekkel igen, pl.: fel lehet sorolni unchecked `Exception`-??ket, vagy ha az ??soszt??lybeli f??ggv??ny pl. `IOException`-t dob, akkor a sz??rmaztatott oszt??lyban, ahol fel??ldefini??lom, ott dobhatok b??rmit, amely az `IOException`-b??l sz??rmazik, pl. `FileNotFoundException`-t.)

## Lehet-e egy `@Override`-olt met??dus `throws` deklar??ci??j??t sz??k??teni?

Igen, l??sd el??z??.

## Mi a garbage collection c??lja, mikor haszn??ljuk?

A Java-ban nem kell foglalkozni a lefoglalt mem??ria felszabad??t??s??val, ez a garbage collector (gc) feladata. Ha egy objektumra nincs t??bb hivatkoz??s (nem mutat r?? t??bb referencia), akkor az objektum ??ltal lefoglalt mem??ria ter??let felszabad??that??. Amikor a gc ezt ??szreveszi, akkor felh??vja az objektum finalize() f??ggv??ny??t, miel??tt a mem??ri??t felszabad??tan??.

Egy objektum akkor is felszabad??that??, ha egy olyan objektum gr??fnak az eleme, amelynek egyik elem??re sincs a gr??fon k??v??lr??l hivatkoz??s (a gr??fon bel??l az objektumok tetsz??legesen mutogathatnak egym??sra). Ez esetben a gr??f ??sszes eleme felszabad??that??.

## Mi az a WeakReference?

Az el??z?? le??r??st pontos??tva: egy objektum ??ltal lefoglalt mem??ria felszabad??that??, ha az adott objektumra nincs t??bb hivatkoz??s, vagy csak WeakReference-en kereszt??l hivatkozunk r??. Ha WeakReference-en kereszt??l hivatkozunk egy objektumra ??s azt a gc felszabad??totta, akkor a WeakReference `null` pointerre fog a tov??bbiakban mutatni.

Hasonl??an objektum gr??fokra is.

## L??tezik-e Java-ban memory-leak?

Mivel a lefoglalt mem??ri??t nem tudjuk k??zvetlen??l felszabad??tani, azt a gc teszi meg helyett??nk, ez??rt  azt hihetn??nk, hogy Java-ban nem l??tezik memory-leak. L??tezik olyan szitu??ci??, hogy egy objektumra akaratlanul is hivatkozunk (pl. egy statikus v??ltoz??n kereszt??l). Ilyenkor a gc ??gy ??rz??keli, hogy az objektum m??g nem szbad??that?? fel. Ezt a Java-ban ??ltal??ban reference-leak-nek h??vj??k. Ritka programoz??si hiba.

## K??sz??ts egy stack oszt??lyt: `isEmpty()`, `push()`, `pop()`

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

## A `String` primit??v t??pus?

Nem.

## Hogyan m??dos??tok egy `String`-et?

A `String` immutable, nem m??dos??that??. A `String` oszt??ly  ??sszes f??ggv??nye egy ??jabb `String`-gel t??r vissza.

## `StringBuilder` vs. `StringBuffer`

Mindkett?? `String`-ek ??sszef??z??s??re szolg??l. Ugyan azok a m??veleteik, csak annyi a k??l??nbs??g hogy a `StringBuffer` f??ggv??nyei szinkroniz??ltak.

## Egy ??res .java f??jl helyes-e?

Igen.

## Lehet-e t??bb oszt??ly egy .java f??jlban?

Igen, de `public`-b??l csak egy!

## V??ltoz??k t??pusai (p??ld??ny, lok??lis, statikus)?

    class X {
	    static int i; // statikus v??ltoz??
	    int j; // p??ld??nyv??ltoz??
	    X () {
		    int k; // lok??lis v??ltoz??
	    }
    }

## Mit ??r ki? System.out.println("1" + 3);

V??lasz: 13

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

When the method finishes execution, it???s corresponding stack frame is flushed, the flow goes back to the calling method and space becomes available for the next method.

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

For example, let???s assume 200 sales have been made in the year 2016, and we want to query for the number of sales per customer in 2016.

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

## Milyen t??pusai vannak a DI-nek Springben?

Constructor Injection ???enforcing immutability
Setter injection ??? enjoy the mutability
Field injection ??? nobody likes it? (reflection)

## H??nyszor h??v??dik meg a carRepository() ?

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
