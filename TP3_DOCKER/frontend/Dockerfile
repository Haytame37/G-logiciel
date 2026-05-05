FROM nginx:alpine

# Copier le fichier index.html personnalisé
COPY index.html /usr/share/nginx/html/index.html

# Exposer le port 80
EXPOSE 80

# Démarrer nginx en foreground
CMD ["nginx", "-g", "daemon off;"]
