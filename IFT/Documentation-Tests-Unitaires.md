# Documentation Tests Unitaires

Emeric Laberge 20220275
Mathieu Morin 20163634

## TurtleMoveTest
Une classe de test a été ajoutée pour tester la classe TurtleMove dont la couverture pouvait etre améliorée. Cette classe
a été choisie, car nous sommes familier avec le concept de tortue (IFT-1015).

Tous les tests pour cette classe se trouvent dans ce [fichier de tests](src/test/java/com/marginallyclever/makelangelo/turtle/TurtleMoveTest.java). <br>
Toutes les méthodes testées se trouvent dans ce [fichier](src/main/java/com/marginallyclever/makelangelo/turtle/TurtleMove.java).

### Test 1 - setColor()

<img src="IFT/images/SetColor-After.png">

Ce test s'assure que la fonction setColor() change correctement la couleur du TurtleMove pour celle désirée. Dans le
contexte d'un "MOVEMENT_TYPE.TOOL_CHANGE", la couleur est contenue dans le champs "x" de l'objet. Cette valeur est
initialisée à 1 dans le constructeur.

### Test 2 - setDiameter()

Ce test vérifie que la fonction setDiameter() change correctement le diamètre. Dans le contexte d'un
"MOVEMENT_TYPE.TOOL_CHANGE", le diamètre est contenue dans la variable y. Cette valeur est initialisée à 2 dans le
constructeur.

### Test 3 - equalsSame()

La fonction equals a été sélectionnée, car plusieurs branches n'étaient pas couvertes.
Ce test vérifie que la fonction equals() retourne vrai lorsqu'un objet TurtleMove est comparé avec lui-meme.


### Test 4 - equalsDifferentClass()

Ce test vérifie que la fonction equals() retourne faux lorsqu'un objet TurtleMove est comparé avec un objet d'une classe différente.

### Test 5 - equalsNull()

Ce test vérifie que la fonction equals() retourne faux lorsqu'un objet TurtleMove est comparé avec un objet null.

### Test 6 - equalsDifferentType()

Ce test vérifie que la fonction equals() retourne faux si les deux objets TurtlesMove diffèrent par leur type de
mouvement.

### Test 7 - equalsDifferentX()

Ce test vérifie que la fonction equals() retourne faux si les deux objets TurtlesMove diffèrent par leur coordonnées
en x.

### Test 8 - equalsDifferentY()

Ce test vérifie que la fonction equals() retourne faux si les deux objets TurtlesMove diffèrent par leur coordonnées
en y.

### Test 9 - TurtleMove()

Ce test vérifie que le constructeur retourne bien un nouvel objet TurtleMove qui est considéré égal à l'objet
qui lui a été passé en paramètre.
