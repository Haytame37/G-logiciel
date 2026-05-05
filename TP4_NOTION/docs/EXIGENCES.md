# Exigences Fonctionnelles - To-Do List

## RF1 : Ajouter une tâche

**Description** : L'utilisateur peut ajouter une nouvelle tâche à la liste

**Prérequis** : L'utilisateur est sur la page de la To-Do List

**Scénario Principal** :
1. L'utilisateur saisit du texte dans le champ "Ajouter une nouvelle tâche..."
2. L'utilisateur clique sur le bouton "Ajouter" ou appuie sur Entrée
3. La tâche s'ajoute à la liste avec le texte saisi
4. Le champ de saisie est vidé
5. Le compteur "Total" s'incrémente de 1

**Cas d'erreur** :
- Si le champ est vide : afficher un message d'alerte "Veuillez entrer une tâche"

**Cas d'exception** :
- La tâche est automatiquement sauvegardée dans localStorage
- L'ID unique est généré avec Date.now()

---

## RF2 : Supprimer une tâche

**Description** : L'utilisateur peut supprimer une tâche de la liste

**Prérequis** : Il existe au moins une tâche dans la liste

**Scénario Principal** :
1. L'utilisateur clique sur le bouton "Supprimer" d'une tâche
2. La tâche est supprimée immédiatement
3. Le compteur des statistiques se met à jour

**Scénario Secondaire** :
1. L'utilisateur clique sur "Effacer les tâches terminées"
2. Si aucune tâche n'est terminée : afficher une alerte
3. Si des tâches sont terminées : afficher une confirmation avec le nombre
4. Après confirmation, supprimer toutes les tâches terminées
5. Les statistiques se mettent à jour

**Cas d'exception** :
- Les données sont mises à jour dans localStorage
- Le bouton "Effacer les tâches terminées" est désactivé si aucune tâche n'est terminée

---

## RF3 : Marquer comme terminée

**Description** : L'utilisateur peut marquer une tâche comme terminée/complétée

**Prérequis** : Il existe au moins une tâche dans la liste

**Scénario Principal** :
1. L'utilisateur clique sur la checkbox d'une tâche
2. La tâche est marquée comme terminée
3. La tâche obtient un style visuel différent (barrage, opacité réduite)
4. Le compteur "Complétées" s'incrémente
5. Le compteur "En cours" se décrémente

**Scénario Inverse** :
1. L'utilisateur clique à nouveau sur la checkbox d'une tâche terminée
2. La tâche est marquée comme en cours
3. Les styles visuels sont supprimés
4. Les compteurs se mettent à jour en conséquence

---

## RF4 : Filtrer les tâches

**Description** : L'utilisateur peut filtrer les tâches selon leur statut

**Prérequis** : La liste contient des tâches

**Scénario Principal** :
1. L'utilisateur clique sur le bouton "Toutes" : affiche toutes les tâches
2. L'utilisateur clique sur le bouton "En cours" : affiche uniquement les tâches non terminées
3. L'utilisateur clique sur le bouton "Terminées" : affiche uniquement les tâches terminées
4. Le bouton actif est mis en évidence avec un style particulier
5. La liste se met à jour immédiatement sans rechargement

**Cas d'exception** :
- Si le filtre n'affiche aucune tâche : afficher l'état vide
- L'état du filtre n'est pas sauvegardé (reset au rechargement)

---

## RF5 : Afficher les statistiques

**Description** : L'utilisateur peut voir les statistiques de sa To-Do List

**Prérequis** : La page est chargée

**Affichage Constant** :
- **Total** : Nombre total de tâches dans la liste
- **Complétées** : Nombre de tâches marquées comme terminées
- **En cours** : Nombre de tâches non terminées

**Mise à Jour** :
- Les statistiques se mettent à jour en temps réel après chaque action
- Ajout de tâche → Total +1, En cours +1
- Suppression de tâche → Total -1 (+ Complétées ou En cours selon le statut)
- Marquage comme terminée → Complétées +1, En cours -1
- Suppression des complétées → Total et Complétées diminuent

---

## RF6 : Persistance des données

**Description** : Les tâches sont automatiquement sauvegardées et restituées

**Prérequis** : Le navigateur supporte localStorage

**Comportement** :
- Chaque action (ajout, suppression, complétion) sauvegarde les données
- Au rechargement de la page, les tâches sont restaurées depuis localStorage
- Les données persistent jusqu'à la suppression ou l'effacement du navigateur

---

## RF7 : Interface responsive

**Description** : L'application est utilisable sur tous les appareils

**Écrans supportés** :
- Desktop (1920px et plus)
- Tablette (768px à 1024px)
- Mobile (320px à 767px)

**Comportement** :
- Les éléments s'adaptent à la taille de l'écran
- La navigation reste intuitive sur tous les appareils
- Les boutons sont tactiles sur mobile

---

## Critères de Satisfaction

✓ Toutes les fonctionnalités sont implémentées  
✓ L'interface est intuitive et responsive  
✓ Les données persistent correctement  
✓ Les validations sont en place  
✓ Les messages d'erreur sont clairs  
✓ L'application n'a pas de dépendances externes  
✓ Le code est bien structuré et commenté  
✓ Les performances sont optimales
