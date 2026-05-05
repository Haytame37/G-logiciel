from fpdf import FPDF
import textwrap
import re

class PDF(FPDF):
    def header(self):
        self.set_font('Arial', 'B', 12)
        self.cell(0, 10, 'TP3 - Application Multi-Conteneurs avec Docker', 0, 1, 'C')
        self.ln(10)
    
    def footer(self):
        self.set_y(-15)
        self.set_font('Arial', 'I', 8)
        self.cell(0, 10, f'Page {self.page_no()}', 0, 0, 'C')

def clean_text(text):
    # Nettoyer le texte pour éviter les problèmes d'encodage
    # Remplacer les caractères spéciaux et les emojis
    text = re.sub(r'[^\x00-\x7F]+', '', text)  # Supprimer les caractères non-ASCII
    return text

# Lire le fichier README.md
with open('README.md', 'r', encoding='utf-8') as f:
    content = f.read()

# Nettoyer le contenu
content = clean_text(content)

# Créer le PDF
pdf = PDF()
pdf.add_page()
pdf.set_font('Arial', '', 11)

# Traiter le contenu ligne par ligne
lines = content.split('\n')
for line in lines:
    line = line.strip()
    
    # Titres
    if line.startswith('# '):
        pdf.set_font('Arial', 'B', 16)
        pdf.cell(0, 10, line[2:], 0, 1)
        pdf.set_font('Arial', '', 11)
        pdf.ln(5)
    elif line.startswith('## '):
        pdf.set_font('Arial', 'B', 14)
        pdf.cell(0, 8, line[3:], 0, 1)
        pdf.set_font('Arial', '', 11)
        pdf.ln(3)
    elif line.startswith('### '):
        pdf.set_font('Arial', 'B', 12)
        pdf.cell(0, 7, line[4:], 0, 1)
        pdf.set_font('Arial', '', 11)
        pdf.ln(2)
    elif line.startswith('#### '):
        pdf.set_font('Arial', 'B', 11)
        pdf.cell(0, 6, line[5:], 0, 1)
        pdf.set_font('Arial', '', 11)
    elif line.startswith('- '):
        # Puces
        pdf.cell(5, 6, '', 0, 0)
        wrapped_lines = textwrap.wrap(line[2:], 75)
        for i, wrapped_line in enumerate(wrapped_lines):
            if i == 0:
                pdf.cell(0, 6, wrapped_line, 0, 1)
            else:
                pdf.cell(5, 6, '', 0, 0)
                pdf.cell(0, 6, wrapped_line, 0, 1)
    elif line.startswith('* '):
        # Puces alternatives
        pdf.cell(5, 6, '', 0, 0)
        wrapped_lines = textwrap.wrap(line[2:], 75)
        for i, wrapped_line in enumerate(wrapped_lines):
            if i == 0:
                pdf.cell(0, 6, wrapped_line, 0, 1)
            else:
                pdf.cell(5, 6, '', 0, 0)
                pdf.cell(0, 6, wrapped_line, 0, 1)
    elif line.startswith('`'):
        # Code
        pdf.set_font('Courier', '', 10)
        pdf.cell(0, 6, line, 0, 1)
        pdf.set_font('Arial', '', 11)
    elif line == '':
        # Ligne vide
        pdf.ln(3)
    else:
        # Texte normal
        wrapped_lines = textwrap.wrap(line, 80)
        for wrapped_line in wrapped_lines:
            pdf.cell(0, 5, wrapped_line, 0, 1)
        else:
            pdf.cell(0, 5, line, 0, 1)

# Sauvegarder le PDF
pdf.output('TP3_DOCKER_Rapport.pdf')
print('PDF généré avec succès: TP3_DOCKER_Rapport.pdf')
