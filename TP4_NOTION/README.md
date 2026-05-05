# TP4 - Intégration de Notion et Git pour la Gestion de Projet

**Auteur**: Haytame EL ATRAOUI  
**Module**: Génie Logiciel - ENSA-BM  
**Professeur**: Pr. BE.ELBAGHAZAOUI  
**Date**: 2026

## 📋 Description

Ce TP couvre l'intégration de Notion comme outil de gestion de projet collaboratif et Git pour le contrôle de version. Le projet consiste à développer une application To-Do List moderne et à synchroniser son développement avec Notion.

## 🎯 Objectifs Pédagogiques

- Utiliser Notion pour la gestion de projet et la documentation
- Mettre en place un workflow Git efficace avec des branches feature
- Synchroniser le développement entre Notion et Git
- Apprendre la collaboration et le suivi des tâches
- Documenter les problèmes et solutions rencontrés
- Maîtriser les bonnes pratiques de gestion de projet

## 📁 Structure du Projet

```
TP4_NOTION/
├── src/
│   ├── index.html          # Interface de la To-Do List
│   ├── styles.css          # Stylisation CSS moderne
│   ├── script.js           # Logique JavaScript complète
│   └── README_APP.md       # Documentation technique de l'app
├── docs/
│   ├── EXIGENCES.md        # Exigences fonctionnelles
│   ├── NOTION_WORKFLOW.md  # Workflow Notion et Git
│   └── PROBLEMES.md        # Problèmes rencontrés et solutions
├── README.md               # Ce fichier
└── convert_to_pdf_fixed.py # Script de génération PDF
```

## 🚀 Application To-Do List

### Fonctionnalités Implémentées

1. **Ajouter une tâche**
   - Interface intuitive avec champ de saisie
   - Validation de l'entrée
   - Ajout à la liste en temps réel

2. **Supprimer une tâche**
   - Bouton de suppression pour chaque tâche
   - Confirmation avant suppression
   - Suppression en masse des tâches terminées

3. **Marquer comme terminée**
   - Checkbox pour cocher/décocher
   - Styles visuels pour les tâches terminées
   - Décoration barrage du texte

4. **Filtrage des tâches**
   - Afficher toutes les tâches
   - Afficher uniquement les tâches en cours
   - Afficher uniquement les tâches terminées

5. **Statistiques**
   - Total des tâches
   - Nombre de tâches terminées
   - Nombre de tâches actives
   - Mise à jour automatique

6. **Persistance des données**
   - Sauvegarde automatique avec localStorage
   - Les données persistent après rechargement
   - Pas de backend requis

### Technologies Utilisées

- **HTML5** : Structure sémantique
- **CSS3** : Design responsive et animations
- **JavaScript (ES6+)** : Logique complète avec classe ToDoApp
- **LocalStorage** : Persistance des données

### Démarrage de l'Application

```bash
# Aucune installation requise
# Ouvrir simplement le fichier src/index.html dans un navigateur
# ou utiliser un serveur local:

python -m http.server 8000
# puis accéder à http://localhost:8000/src/

# Ou avec Node.js:
npx http-server src/
```

## 📊 Workflow Notion & Git

### Étape 1 : Tableau Kanban dans Notion

Créer un tableau Kanban avec 3 colonnes :
- **À faire** : Tâches planifiées
- **En cours** : Tâches en développement
- **Terminé** : Tâches achevées

**Cartes du projet :**
1. Fonctionnalité 1 : Ajouter une tâche
2. Fonctionnalité 2 : Supprimer une tâche
3. Fonctionnalité 3 : Marquer comme terminée

### Étape 2 : Git Workflow

```bash
# Créer une branche pour chaque fonctionnalité
git checkout -b feature/add-task
git checkout -b feature/delete-task
git checkout -b feature/mark-completed

# Après chaque fonctionnalité terminée
git add .
git commit -m "Ajout de la fonctionnalité [description]"
git push origin feature/[name]

# Créer une Pull Request sur GitHub
# Une fois mergée, mettre à jour Notion
```

### Étape 3 : Synchronisation

| Git Branch | Notion Status | Description |
|-----------|--------------|-------------|
| feature/add-task | En cours → Terminé | Ajout de tâches |
| feature/delete-task | En cours → Terminé | Suppression de tâches |
| feature/mark-completed | En cours → Terminé | Marquer comme terminée |

## 📝 Exigences Fonctionnelles

### RF1 : Ajouter une tâche
**Description** : L'utilisateur peut ajouter une nouvelle tâche à la liste
- Saisir du texte dans un champ
- Cliquer sur "Ajouter" ou appuyer sur Entrée
- La tâche s'ajoute à la liste
- Le champ est vidé après l'ajout

### RF2 : Supprimer une tâche
**Description** : L'utilisateur peut supprimer une tâche
- Bouton "Supprimer" pour chaque tâche
- Confirmation avant suppression
- Suppression en masse avec "Effacer les tâches terminées"

### RF3 : Marquer comme terminée
**Description** : L'utilisateur peut marquer une tâche comme terminée
- Checkbox pour chaque tâche
- Style visuel différent pour les tâches terminées
- Compteur de tâches terminées

### RF4 : Filtrer les tâches
**Description** : Afficher les tâches selon leur statut
- Filtre "Toutes"
- Filtre "En cours"
- Filtre "Terminées"

### RF5 : Statistiques
**Description** : Afficher les statistiques de la liste
- Total des tâches
- Nombre de terminées
- Nombre en cours
- Mise à jour en temps réel

## 🔄 Branches Git Créées

```
main (branche principale - stable)
├── feature/add-task
├── feature/delete-task
├── feature/mark-completed
├── feature/filtering
├── feature/statistics
└── develop (branche de développement)
```

## 🐛 Problèmes Rencontrés et Solutions

### Problème 1 : Conflit de fusion
**Description** : Conflit lors de la fusion des branches
**Solution** : Résolution manuelle du conflit avec VS Code, test après fusion

### Problème 2 : localStorage limité
**Description** : localStorage a une limite de taille
**Solution** : Implémenter une gestion optimale des données

### Problème 3 : Persistance entre onglets
**Description** : Synchroniser les données entre plusieurs onglets
**Solution** : Utiliser des événements storage

### Problème 4 : Sécurité XSS
**Description** : Injection HTML malveillante
**Solution** : Échapper le HTML avec escapeHtml()

## 📚 Documentation Notion

### Section 1 : Tableau Kanban
- Visualiser l'état des fonctionnalités
- Mises à jour en temps réel
- Lien vers les branches GitHub

### Section 2 : Documentation Fonctionnelle
- Exigences pour chaque fonctionnalité
- Cas d'usage
- Critères d'acceptation

### Section 3 : Rapport
- Problèmes rencontrés
- Solutions apportées
- Commits associés

### Section 4 : Réunion Récapitulative
- Progrès réalisés
- Points à améliorer
- Améliorations futures

## ✅ Checklist de Validation

- [x] Application To-Do List fonctionnelle
- [x] Toutes les fonctionnalités implémentées
- [x] Design responsive et moderne
- [x] Persistance des données
- [x] Documentation complète
- [x] Branches Git bien organisées
- [x] Commits descriptifs
- [x] Notion configuré avec tableau Kanban
- [x] Synchronisation Git/Notion
- [x] Rapport PDF généré

## 📈 Améliorations Futures

1. **Backend** : Ajouter une API Node.js/Express
2. **Database** : Intégrer MongoDB ou PostgreSQL
3. **Authentification** : Système de login utilisateur
4. **Collaboration** : Partage et édition collaborative
5. **Notifications** : Rappels pour les tâches
6. **Catégories** : Organiser les tâches par catégories
7. **Priorités** : Définir des niveaux de priorité
8. **Récurrence** : Tâches récurrentes
9. **Intégration Notion** : API Notion pour sync automatique
10. **Analytics** : Dashboard de productivité

## 🔧 Compétences Acquises

- Gestion de projet avec Notion
- Workflow Git avancé (branches, merge, rebase)
- Développement d'application web moderne
- Collaboration et synchronisation
- Documentation technique complète
- Bonnes pratiques DevOps et Agile

## 📚 Ressources

- [Notion API Documentation](https://developers.notion.com/)
- [GitHub Best Practices](https://github.com/features/code-review)
- [MDN Web Docs](https://developer.mozilla.org/)
- [Agile Methodologies](https://www.agilealliance.org/)
