# Zadanie-Collections
W tym zadaniu zasymulujemy działanie koszyka sklepowego na stronie internetowej.
Punkty do wykonania:
- Stworzenie interface'u `Product` który udostępnia metodę do pobrania ceny Produktu oraz metodę do pobrania nazwy Produktu.
- Stworzyć dwie klasy które będą implementować ten interface, można dodać do tych klas jakieś dodatkowe atrybuty.
- Stworzyć klasę `Cart` która zawiera listę Produktów oraz udostępnia metodę do dodawania Produktów do listy.
- Utworzyć klasę `Main` i dodać w niej kilka Produktów do koszyka
- Następnie stworzyć w klasie `Cart` metodę która zwróci canę za wszystkie produkty w koszyku oraz metodę która wyczyści koszyk.
- Stworzyć w klasie `Cart` metodę która zwraca listę Produktów posortowanych po cenie, można to zrobić na kilka sposobów, fajnym rozwiązaniem byłoby użycie interface'u Comparable,
aby go użyć w naszym przypadku należy znaleźć w dostępnych źródłach jak interface (w naszym wypadku `Product`) może implementować defaultowe metody oraz rozszerzać inny interface.(Chcemy zrobić coś w stylu `interface Product extends Comparable<Product>`)
- Ostatnim zadaniem jest wprowadzenie do klasy `Cart` metody która będzie przyjmowała obiekt implementujący interface Comparator i zwracała listę posortowaną według tego Comparatora.