Tests:

Chemin d'accès: src/test/java/com/marginallyclever/communications/NetworkSessionEventTest.java

testNetworkSessionEventCreation(): On veut s'assurer qu'il n'y a pas de souci lors de l'initialisation d'un objet 'NetworkSessionEvent()', et que les arguments passés à l'initialisation sont bien ceux que l'on retrouve dans l'objet en soi.

testNetworkSessionEventFlags(): Les motivations ressemblent à celles du test précédent. Ici, on veut s'assurer que chaque valeur possible d'un flag se retransmette correctement dans l'objet lors de l'initialisation.

Chemin d'accès: src/test/java/com/marginallyclever/communications/TransportLayerTest.java

testOpenConnection(): Ici on veut s'assurer que la méthode '.openConnection()' de l'objet 'DummmyTransportLayer' ait le comportement attendu, c'est à dire ouvrir une session avec le nom attendu de la configuration passé en entrée.

testListConnections(): On veut vérifier qu'on puisse bien récupérer l'information des sessions encore actives avec 'listConnections()'. On utilise le test précédent en tant qu'arrange, et le test devrait vérifier que le nom de la session initialisée précédemment est bien récupérable.

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/CollapsiblePanelTest.java

testToggleVisibility(): Ce test sert à vérifier le comportement d'un panneau rétractable. En effet il doit initiallement être rétracté, puis se développer et afficher ses éléments, puis se rétracter à nouveau à chaque clique et faire disparaitre ses éléments. On a besoin d'un set up au préalable, ainsi que de la définition d'une fonction qui permet de constater la visibilité du panneau. Attention: le test ne s'exécute pas dans le cas de CI.

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/DialogAboutTest.java

testDialogComponents(): On veut vérifier la présence d'éléments dans la boite de dialogue 'DialogAbout'. Dans l'ordre: la boite en elle-même, ensuite un élément avec pour label: 'DialogAbout.AboutHTML', et un bouton 'OK' sur lequel on clique pour finalement fermer la boite de dialogue. Attention: le test ne s'exécute pas dans le cas de CI (test graphique).

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/DialogBadFirmwareVersionTest.java

testDialogComponents(): On veut vérifier la présence d'éléments dans la boite de dialogue 'DialogBadFilmwareVersion'. Dans l'ordre: la boite en elle-même, ensuite un élément avec pour label: 'DialogBadFirmwareVersion.Message', et un bouton 'OK' sur lequel on clique pour finalement fermer la boite de dialogue. Attention: le test ne s'exécute pas dans le cas de CI (test graphique).

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/select/SelectBooleanTest.java

testInitialSelection(): On veut s'assurer que le paramètre 'arg0' détermine correctement l'initialisation de l'objet 'SelectBoolean'. Ce paramètre est sensé déterminer comme attendu la sortie de la méthode 'isSelected()'.

testSetSelected(): On souhaite vérifier le bon fonctionnement du setter 'setSelected'.

testEventFiring(): Ce test a pour but de vérifier le bon fonctionnement des événements de intéragissant avec l'objet SelectBoolean. On définit un écouteur (listener) qui réagit aux changements d'état. Lorsqu'on modifie l'état de l'objet en appelant la méthode setSelected(true), cet événement est  déclenché et permet de valider que les valeurs anciennes et nouvelles sont correctes.  Ainsi, on s'assure que l'état a bien changé de false à true, et que l'événement capture correctement cette transition.

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/select/SelectIntegerTest.java

testInitialValue(): Ici on test l'initialisation de 'SelectInteger', particulièrement du paramètre 'defaultValue'. On veut vérifier qu'il n'y a pas d'erreur qu'on entre 0 ou un entier positif quelconque.

testSetValue(): On souhaite tester le setter de l'attribut 'value' de la classe 'SelectInteger'.

testEventFiring(): Ce test a pour but de vérifier le bon fonctionnement des événements interagissant avec l'objet 'SelectInteger'. On définit un écouteur (listener) qui réagit aux changements d'état. Lorsqu'on modifie l'état de l'objet en appelant la méthode 'setValue(15)', cet événement est déclenché et permet de valider que les valeurs anciennes et nouvelles sont correctes. Ainsi, on s'assure que l'état a bien changé de l'ancienne valeur (0) à la nouvelle (15), et que l'événement capture correctement cette transition.

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/select/SelectPasswordTest.java

testInitialPassword(): On souhaite tester l'initialisation de l'objet SelectPassword, en vérifiant que la valeur initialisée est bien celle attendue en utilisant le getter 'getPassword()'.

testSetPassword(): On souhaite tester le setter de l'attribut password de l'objet 'SelectPassword'. On l'essaye à deux reprises avec deux mot de passe différents pour être sûr que l'utiliser une première fois ne cause pas de problème pour une utilisation ultérieure de ce setter.

Chemin d'accès: src/test/java/com/marginallyclever/makelangelo/paper/PaperSizeTest.java

testConstructorAndGetter(): Ici on vérifie l'initialisation correcte de 'PaperSize' et de ses 3 paramètres qui doivent équivaloir aux 3 attributs correspondant.

testToString(): On veut tester la méthode 'toString()' de la classe 'PaperSize'. On s'assure que le format du string en sortie est comme attendu, donc bien lisible.