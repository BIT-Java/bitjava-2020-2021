# Zadanie-Optionals
- Stworz klasę `Address` która posiada pola `street, city, country`
- Stworz klasę `Student` która posiada pola `id, name, address`
- Stworz klasę `Course` która posiada mapę studentów (kluczem w Mapie jest id studenta, wartością student) i udostępnia metodę do dodania studenta do Mapy
- Stworz w klasie `Course` metodę `findStudent` która zwraca `Optional<Student>` w zależności od tego czy student jest w mapie czy go nie ma. (przydatne metody do operacji na mapie `HashMap<Long, Student>` to `put(key, value)` oraz `get(key)`)
- Niech gettery w klasach `Address` oraz `Student` zwracają Optionale, nie musimy wszystkich tych wartości inicjalizować w konstruktorze, dajmy niektórym z nich być nullami.
- Stworz klasę `Main` i "pobaw" się Optionalami, spróbój np:
  - Wypisać imię studenta którego ID jest w mapie, a gry nie ma go w mapie to wypisać pusty String.
  - Wypisać ulicę na której mieszka student jeśli ma ustawiony Adres, oraz Adres ma ustawioną ulicę, jeśli coś z tego nie jest ustawione to wypisz pusty String.
  