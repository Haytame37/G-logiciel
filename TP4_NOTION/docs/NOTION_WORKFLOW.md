# Workflow Notion et Git - Synchronisation

## 📋 Configuration Notion

### Tableau Kanban Principal

**Nom** : Projet To-Do List  
**Vue** : Kanban  

**Colonnes** :
1. **À faire** (To Do)
   - Tâches planifiées
   - Pas encore commencées

2. **En cours** (In Progress)
   - Développement en cours
   - Branche Git créée
   - Travail actif

3. **Terminé** (Done)
   - Fonctionnalités complétées
   - Code mergé dans main
   - Testées et validées

### Cartes du Projet

#### Carte 1 : Ajouter une tâche
- **Statut initial** : À faire
- **Description** : Implémenter la fonctionnalité d'ajout de tâche
- **Branche Git** : feature/add-task
- **Liée à** : RF1
- **Checklist** :
  - [ ] Interface input + bouton
  - [ ] Validation de l'entrée
  - [ ] Ajout à la liste
  - [ ] Sauvegarde localStorage
  - [ ] Tests manuels

#### Carte 2 : Supprimer une tâche
- **Statut initial** : À faire
- **Description** : Implémenter la suppression de tâche
- **Branche Git** : feature/delete-task
- **Liée à** : RF2
- **Checklist** :
  - [ ] Bouton supprimer par tâche
  - [ ] Confirmation de suppression
  - [ ] Suppression en masse
  - [ ] Mise à jour localStorage
  - [ ] Tests

#### Carte 3 : Marquer comme terminée
- **Statut initial** : À faire
- **Description** : Implémenter le marquage de tâche terminée
- **Branche Git** : feature/mark-completed
- **Liée à** : RF3
- **Checklist** :
  - [ ] Checkbox pour chaque tâche
  - [ ] Style visuel pour terminées
  - [ ] Mise à jour compteur
  - [ ] Persistance localStorage
  - [ ] Tests

---

## 🔄 Workflow Détaillé

### Étape 1 : Planification dans Notion

```
1. Créer une nouvelle carte pour la fonctionnalité
2. La placer dans la colonne "À faire"
3. Définir la description et les critères
4. Assigner le développeur (vous)
5. Ajouter la date de début souhaitée
```

### Étape 2 : Démarrage du Développement

**Dans Notion** :
```
1. Ouvrir la carte
2. Changer le statut à "En cours"
3. Ajouter une date de fin estimée
```

**Dans Git** :
```bash
# Créer une branche basée sur la carte Notion
git checkout -b feature/[nom-de-la-fonctionnalite]

# Exemple :
git checkout -b feature/add-task
```

### Étape 3 : Développement et Commits

**Code** :
```bash
# Faire les modifications
# Ajouter les fichiers
git add .

# Commiter avec un message descriptif
git commit -m "Ajout de la fonctionnalité : [description]

- Détail 1
- Détail 2

Lié à la carte Notion : [ID ou nom]"
```

**Message de Commit Recommandé** :
```
Ajout du formulaire d'ajout de tâche

- Champ input avec placeholder
- Bouton "Ajouter" stylisé
- Validation de l'entrée vide
- Ajout à la liste React
- Sauvegarde dans localStorage

Fermé : Notion - Carte "Ajouter une tâche"
```

### Étape 4 : Pull Request et Révision

```bash
# Pousser la branche
git push origin feature/add-task

# Sur GitHub :
# 1. Créer une Pull Request
# 2. Title : "Fonctionnalité : [Ajout de tâche]"
# 3. Description : Lier la PR à la carte Notion
# 4. Ajouter des tests
# 5. Demander une review
# 6. Merger dans develop
```

### Étape 5 : Fusion et Mise à Jour Notion

**Git** :
```bash
# Merger la branche dans develop
git checkout develop
git merge feature/add-task
git push origin develop

# Optionnel : supprimer la branche locale
git branch -d feature/add-task
```

**Notion** :
```
1. Ouvrir la carte
2. Changer le statut à "Terminé"
3. Ajouter la date réelle de completion
4. Ajouter le lien vers le commit/PR GitHub
5. Marquer les checklist comme complétées
6. Ajouter des notes si nécessaire
```

---

## 📊 Matrice de Synchronisation

| Étape | Notion | Git | Action |
|-------|--------|-----|--------|
| 1 | Créer carte | - | Planification |
| 2 | "À faire" | git branch | Préparation |
| 3 | "En cours" | feature branch | Développement |
| 4 | "En cours" | commits | Progression |
| 5 | Checklist | code review | Qualité |
| 6 | "Terminé" | git merge | Intégration |
| 7 | Lien GitHub | PR URL | Traçabilité |

---

## 🔗 Lien Entre Notion et GitHub

### Ajouter un lien dans Notion

```
1. Ouvrir la propriété "GitHub" (à créer)
2. Coller l'URL de la branche :
   https://github.com/Haytame37/G-logiciel/tree/feature/add-task

3. Ou le lien du commit :
   https://github.com/Haytame37/G-logiciel/commit/[commit-hash]

4. Ou le lien de la PR :
   https://github.com/Haytame37/G-logiciel/pull/[PR-number]
```

---

## 📝 Documentation Notion Sections

### Section 1 : Tableau Kanban
- Vue principale du projet
- Drag & drop des cartes
- Toutes les fonctionnalités visibles

### Section 2 : Documentation Fonctionnelle
- Page par fonctionnalité
- Exigences détaillées
- Cas d'usage
- Acceptation criteria

### Section 3 : Liens GitHub
- Branches créées
- Commits importants
- Pull Requests
- Issues

### Section 4 : Rapport de Problèmes
- Problèmes rencontrés
- Solutions apportées
- Commits associés
- Impact sur le calendrier

### Section 5 : Notes de Réunion
- Décisions prises
- Actions à faire
- Blocages identifiés
- Améliorations futures

---

## ✅ Checklist Synchronisation

Pour chaque fonctionnalité :

- [ ] Carte créée dans Notion
- [ ] Statut initial "À faire"
- [ ] Branche Git créée localement
- [ ] Branche poussée sur GitHub
- [ ] Statut Notion changé à "En cours"
- [ ] Commits faits avec messages descriptifs
- [ ] Code testé localement
- [ ] Pull Request créée sur GitHub
- [ ] PR révisée et approuvée
- [ ] Branche mergée dans develop
- [ ] Statut Notion changé à "Terminé"
- [ ] Lien GitHub ajouté dans Notion
- [ ] Checklist Notion complétée
- [ ] Documentation mise à jour

---

## 🚀 Intégration Avancée (Optionnelle)

### Automatisation avec Zapier/GitHub Actions

```yaml
# .github/workflows/notion-sync.yml
name: Sync Notion

on: [push, pull_request]

jobs:
  notify:
    runs-on: ubuntu-latest
    steps:
      - name: Send Notion Update
        run: |
          # Appel API Notion pour mettre à jour automatiquement
          curl -X PATCH https://api.notion.com/...
```

### API Notion

```javascript
// Exemple de mise à jour automatique
fetch('https://api.notion.com/v1/pages/[PAGE_ID]', {
  method: 'PATCH',
  headers: { 'Authorization': `Bearer ${NOTION_TOKEN}` },
  body: JSON.stringify({
    properties: {
      Status: { select: { name: 'Terminé' } }
    }
  })
});
```
