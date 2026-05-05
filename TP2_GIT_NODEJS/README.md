# TP2 - Git & Node.js

**Auteur**: Haytame EL ATRAOUI  
**Module**: Génie Logiciel - ENSA-BM  
**Professeur**: Pr. BE.ELBAGHAZAOUI  
**Date**: 2026

## 📋 Description

Ce TP couvre les concepts fondamentaux de gestion de versions avec Git et le développement d'une application Node.js simple. Il comprend :

1. **Initialisation du projet Node.js** avec Git
2. **Gestion des branches** (dev, feature)
3. **Fusion (merge)** et résolution de conflits
4. **Rebase** pour une histoire linéaire
5. **Cherry-pick** pour appliquer des commits spécifiques
6. **Collaboration** avec GitHub

## 🎯 Objectifs Pédagogiques

- Maîtriser les commandes Git de base et avancées
- Comprendre le workflow Git (branches, merge, rebase)
- Développer une application Node.js modulaire
- Gérer les conflits de fusion
- Collaborer efficacement avec Git

## 📁 Structure du Projet

```
TP2_GIT_NODEJS/
└── mon-projet-node/
    ├── index.js              # Application principale avec fonctions mathématiques
    ├── package.json          # Configuration du projet Node.js
    ├── README.md             # Documentation du projet
    └── .gitignore            # Fichiers à ignorer
```

## 🔧 Installation et Exécution

### Prérequis

- Node.js (version 14+)
- Git

### Installation

```bash
cd mon-projet-node
npm install
```

### Exécution

```bash
npm start
```

## 📝 Fonctionnalités Implémentées

### Fonctions Mathématiques

- **addition(a, b)** : Addition robuste avec gestion des types (conversion en Number, vérification NaN)
- **soustraction(a, b)** : Soustraction simple

### Gestion des Branches Git

- Branche `main` : Version stable
- Branche `dev` : Développement des nouvelles fonctionnalités
- Branche `feature` : Fonctionnalités spécifiques (soustraction)
- Branche `bugfix` : Corrections de bugs (robustesse de l'addition)

## 🔄 Workflow Git Réalisé

1. **Initialisation** : Création du projet avec `npm init`, ajout README et .gitignore
2. **Branche dev** : Ajout de la fonction `addition`
3. **Merge dev → main** : Intégration de l'addition
4. **Branche feature** : Ajout de la fonction `soustraction`
5. **Conflit de merge** : Résolution lors de la fusion feature → main
6. **Branche bugfix** : Amélioration de la robustesse de `addition`
7. **Rebase** : Application du bugfix sur main
8. **Cherry-pick** : Application du bugfix sur feature

## 📊 Résultats d'Exécution

```
Résultat addition: 8
Résultat soustraction: 2
```

## 🛠️ Technologies Utilisées

- **Node.js** : Environnement d'exécution JavaScript
- **Git** : Système de contrôle de version
- **GitHub** : Plateforme de collaboration
- **NPM** : Gestionnaire de paquets

## 📈 Compétences Acquises

- Gestion avancée des branches Git
- Résolution de conflits de fusion
- Rebase et cherry-pick
- Développement modulaire en JavaScript
- Collaboration avec Git et GitHub
