# Јана Стојковска 223064


Control Flow Graph
Фотографија од control flow graph-ot


![cfg](https://github.com/jstojkovska/SI_2024_lab2_223064/assets/164164664/62980e82-ea85-4ef5-9cee-0370c61d252c)


Цикломатска комплексност

Цикломатската комплексност ја пресметав на тој начин што го избројав бројот на јазли и ребра, и пресметав со помош на формулата E-N+2, 
односно 36-28+2=10

Тест случаи според критериумот Every branch

![everyBranch](https://github.com/jstojkovska/SI_2024_lab2_223064/assets/164164664/8286195e-92fd-4e1d-a296-d7134a761e49)


Every branch - Во оваа метода целта е да се генерираат test case-ови кои во јазлите за одлука ќе ги посетат двата исходи од одлуката. Листата се состои од 4 items,
а payment изнесува 400. За да ги опфтам сите тест случаеви, направив различни комбинации на items во листата, каде листата е 
празна за да се задоволи едниот услов каде ќе се фрли исклучок - "allItems list can't be null!", понатаму едниот item да има име null каде
ќе се изврши делот името даа се сетира на unknown и до крај успешно ќе се заврши програмата. Со следниот тест пример каде discount e 0 нема 
да се исполнат два услова и ќе отидат во else делот. Со следниот тест пример каде discount e 0 нема да се исполнат два услова и ќе отидат во 
else делот. Слениот тест пример е кога barcode=null и тука доаѓа до неисполнување на услов и заврсшува програмата поради исклучок - "No barcode!".
Последниот тест пример е каде barcode е составен од алфанумерички знаци што предизвикува да заврши програмата поради исклучок - 
"Invalid character in item barcode!".

Тест случаи според критериумот Every statement


![everyStatement](https://github.com/jstojkovska/SI_2024_lab2_223064/assets/164164664/c237dc64-4579-482e-88b1-3b77cd16b3a5)


Every statement - Оваа метода налага да се генерираат test case-ови кои ќе овозможат тестирање на секоја наредба односно секој statement од
кодот. Ги искористив истите тест случаи како и за еvery branch методата, каде успешно се поминаа сите јазли.
Со овие тест случаеви се постигнува покривање на секој statement во кодот, осигурувајќи дека сите делови од
логиката се тестирани барем еднаш. Така, не само што секоја одлука (branch) е тестирана, туку и секоја наредба во кодот е извршена и валидација за точноста на 
кодот е направена.

Тест случаи според критериумот Multiple Condition


![multipleCondition](https://github.com/jstojkovska/SI_2024_lab2_223064/assets/164164664/d4199091-a76d-452c-9932-e9a0d8ff013c)


Објаснување на напишаните unit tests

Tест класа (SILab2Test):

Оваа класа содржи два главни методи за тестирање: everyStatement и everyBranch. Таа користи JUnit 5 за рамката за тестирање. Помошна метода (креира листа):

createList(Item... elems) е помошен метод кој креира List од променлив број на објекти на Item. Ова се користи за да се поедностави создавањето на тест влезови.

RuntimeException ex; ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 400)); assertTrue(ex.getMessage().contains("allItems list can't be null!")); 
Ова потврдува дека методот фрла RuntimeException со пораката "allItems list can't be null!" кога allItems е нула. RuntimeException.class: Типот на исклучок што очекуваме да биде исфрлен. 
Ламбда израз () -> SILab2.checkCart(null, 400): Ова е повикот на методот што очекуваме да го фрли исклучокот. Методот checkCart се повикува со null како прв аргумент и 400 како втор аргумент. 
Ако методот checkCart фрли RuntimeException, го фаќа assertThrows. Ако не се фрли исклучок или ако се фрли различен тип на исклучок, тестот ќе пропадне.

ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("juice", "0a34", 30, 0.2f)), 400)); assertTrue(ex.getMessage().contains("Invalid character in item barcode!")); 
Ова потврдува дека методот фрла RuntimeException со пораката "Invalid character in item barcode!" кога ставката има баркод што содржи ненумерички знаци.

ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("milk", null, 50, 0.5f)), 400)); assertTrue(ex.getMessage().contains("No barcode!")); 
Ова потврдува дека методот фрла RuntimeException со пораката "No barcode!" кога barcode = null.

assertTrue(SILab2.checkCart(createList(new Item("", "0125", 350, 0.1f)), 400)); 
Ова потврдува дека методот враќа true кога е валиден баркодот e валиден и цената е во рамките на одредената граница.

assertFalse(SILab2.checkCart(createList(new Item("chips", "0268", 5000, 0.0f)), 400));
Ова потврдува дека методот неточно кога цената на ставката ја надминува одредената ценовна граница.



