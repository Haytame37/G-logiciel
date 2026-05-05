# Problèmes Rencontrés et Solutions

## Problème 1 : Conflit de Fusion Git

### Description
Lors de la fusion de la branche `feature/delete-task` dans `develop`, Git détecte un conflit car les deux branches ont modifié le même fichier `script.js` à des positions différentes.

### Symptôme
```
CONFLICT (content): Merge conflict in src/script.js
Auto-merge failed; fix conflicts and then commit the result.
```

### Cause
- Modification simultanée de la même section du code
- Base commune insuffisante

### Solution Appliquée
```bash
# 1. Voir les conflits
git status

# 2. Ouvrir VS Code
code .

# 3. VS Code affiche les conflits avec des marqueurs
# <<<<<<< HEAD (current branch)
# ... votre code ...
# =======
# ... code de l'autre branche ...
# >>>>>>> feature/delete-task

# 4. Choisir la version à garder ou combiner manuellement

# 5. Valider les changements
git add src/script.js

# 6. Terminer le merge
git commit -m "Résolution du conflit de merge entre develop et feature/delete-task"

# 7. Pousser
git push origin develop
```

### Prévention Future
- Communiquer sur les fichiers modifiés
- Utiliser des branches courtes (durée de vie limitée)
- Merger régulièrement dans la branche principal
- Utiliser les Pull Request avec review

---

## Problème 2 : localStorage Limité à 5-10MB

### Description
L'application utilise localStorage pour la persistance. Si l'utilisateur ajoute trop de tâches (très longues), il risque de dépasser la limite.

### Symptôme
```
QuotaExceededError: DOM Exception 22
```

### Cause
- localStorage limité à ~5-10MB selon le navigateur
- Chaque tâche avec métadonnées prend de la place
- Pas de nettoyage des données anciennes

### Solution Appliquée
```javascript
// 1. Vérifier la taille avant sauvegarde
function saveTasks() {
    try {
        localStorage.setItem('tasks', JSON.stringify(this.tasks));
    } catch (e) {
        if (e.code === 'QuotaExceededError') {
            alert('Erreur: Limite de stockage atteinte');
            console.warn('localStorage est plein');
        }
    }
}

// 2. Implémenter un archivage
function archiveCompletedTasks() {
    const completedTasks = this.tasks.filter(t => t.completed);
    // Archiver dans localStorage avec un key différent
    localStorage.setItem('archivedTasks', 
        JSON.stringify(completedTasks)
    );
    // Nettoyer les tâches terminées de la liste active
}

// 3. Limiter le nombre de tâches conservées
function cleanup() {
    if (this.tasks.length > 1000) {
        // Garder les 100 dernières
        this.tasks = this.tasks.slice(-100);
        this.saveTasks();
    }
}
```

### Améliorations Futures
- Utiliser IndexedDB pour plus d'espace (~50MB)
- Implémenter un backend serveur (PostgreSQL)
- Ajouter une synchronisation cloud
- Implémenter un système d'archivage automatique

---

## Problème 3 : Synchronisation Entre Onglets

### Description
L'utilisateur ouvre la To-Do List dans deux onglets différents. Les modifications dans un onglet ne sont pas visibles dans l'autre.

### Symptôme
- Ajouter une tâche dans l'onglet 1
- L'onglet 2 ne voit pas la nouvelle tâche
- Incohérence des données

### Cause
- Chaque onglet a sa propre instance JavaScript
- localStorage n'envoie pas de notifications par défaut

### Solution Appliquée
```javascript
// Écouter les changements de localStorage
window.addEventListener('storage', (event) => {
    if (event.key === 'tasks') {
        // Recharger les tâches depuis localStorage
        this.loadTasks();
        this.render();
        console.log('Tâches synchronisées depuis un autre onglet');
    }
});
```

### Test
```javascript
// Ouvrir la console dans deux onglets et exécuter :
localStorage.setItem('test', Date.now());
// L'événement se déclenche dans les autres onglets
```

---

## Problème 4 : Injection XSS (Cross-Site Scripting)

### Description
Un utilisateur malveillant ajoute une tâche contenant du HTML/JavaScript :
```html
<img src=x onerror="alert('XSS')">
```

### Symptôme
- Le code malveillant s'exécute
- Sécurité compromise
- Données de l'utilisateur en danger

### Cause
- Utiliser directement innerHTML avec les données utilisateur
- Pas d'échappement des caractères spéciaux

### Solution Appliquée
```javascript
// Fonction d'échappement HTML
escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;  // textContent échappe automatiquement
    return div.innerHTML;
}

// Utilisation sécurisée
const taskHTML = this.escapeHtml(task.text);
li.innerHTML = `<span>${taskHTML}</span>`;

// Alternative : utiliser textContent
li.textContent = task.text;
```

### Résultat
- `<img src=x onerror="alert('XSS')">` est affiché comme texte
- Pas d'exécution de code

---

## Problème 5 : Performance avec Beaucoup de Tâches

### Description
Quand la liste atteint 500+ tâches, l'application devient lente.

### Symptôme
- Lag lors du rendu
- Temps de réaction lent
- Utilisation CPU élevée

### Cause
- Re-render de toute la liste à chaque action
- Pas de virtualisation
- DOM trop volumineux

### Solution Appliquée
```javascript
// Avant : re-render complet
render() {
    taskList.innerHTML = '';  // Supprime tout
    filtered.forEach(task => {
        // Recréer tous les éléments
    });
}

// Après : re-render optimisé
render() {
    // Mise en cache du fragment DOM
    const fragment = document.createDocumentFragment();
    filtered.forEach(task => {
        fragment.appendChild(this.createTaskElement(task));
    });
    taskList.replaceChildren(fragment);
}
```

### Améliorations Futures
- Implémenter la virtualisation (afficher uniquement les éléments visibles)
- Utiliser React ou Vue pour le rendu efficace
- Lazy loading des tâches anciennes
- Pagination (afficher 20 tâches par page)

---

## Problème 6 : Validation Faible des Entrées

### Description
L'application accepte des tâches avec seulement des espaces :
```
"    " → enregistré comme tâche
```

### Symptôme
- Liste polluée par des tâches vides
- Expérience utilisateur mauvaise

### Cause
- Validation : `if (text === '')` n'échappe pas les espaces

### Solution Appliquée
```javascript
addTask() {
    const input = document.getElementById('taskInput');
    const text = input.value.trim();  // Supprimer espaces début/fin
    
    // Validation améliorée
    if (!text || text.length === 0) {
        alert('Veuillez entrer une tâche');
        return;
    }
    
    // Limiter la longueur
    if (text.length > 200) {
        alert('La tâche ne doit pas dépasser 200 caractères');
        return;
    }
}
```

---

## Problème 7 : État du Filtre Perdu au Rechargement

### Description
L'utilisateur sélectionne le filtre "Terminées". Si la page se recharge, le filtre revient à "Toutes".

### Symptôme
- Perte de contexte utilisateur
- Mauvaise expérience

### Cause
- Le filtre n'est pas sauvegardé dans localStorage

### Solution Appliquée
```javascript
// Sauvegarder le filtre
setFilter(filter) {
    this.currentFilter = filter;
    localStorage.setItem('lastFilter', filter);
    // ... reste du code
}

// Charger le filtre sauvegardé
init() {
    const saved = localStorage.getItem('lastFilter');
    if (saved) {
        this.currentFilter = saved;
    }
    // ... reste de l'init
}
```

---

## Résumé des Corrections

| Problème | Sévérité | État | Solution |
|----------|----------|------|----------|
| Conflit Git | Moyen | ✅ Résolu | Merge manuel + communication |
| localStorage limité | Moyen | ✅ Mitigé | Nettoyage + IndexedDB future |
| Sync onglets | Moyen | ✅ Résolu | Event listener storage |
| Injection XSS | Critique | ✅ Résolu | escapeHtml() |
| Performance | Moyen | ✅ Mitigé | Optimisation DOM + virtualisation future |
| Validation faible | Moyen | ✅ Résolu | trim() + longueur max |
| Filtre perdu | Faible | ✅ Résolu | Persistance localStorage |

---

## Leçons Apprises

1. **Toujours valider** les entrées utilisateur
2. **Sécurité XSS** est critique en web
3. **Communication** évite les conflits Git
4. **Performance** importante avec de gros volumes
5. **Persistance** améliore l'UX
6. **Tests** nécessaires pour les edge cases
7. **Documentation** aide à la maintenance
