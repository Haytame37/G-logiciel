from fpdf import FPDF
import textwrap
import re

class PDF(FPDF):
    def header(self):
        self.set_font('Arial', 'B', 12)
        self.cell(0, 10, 'TP1 - Programmation Orientee Objet', 0, 1, 'C')
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
        pdf.cell(0, 6, line[4:], 0, 1)
        pdf.set_font('Arial', '', 11)
        pdf.ln(2)
    # Lignes vides
    elif not line:
        pdf.ln(5)
    # Code blocks
    elif line.startswith('```'):
        pdf.set_font('Courier', '', 10)
        pdf.set_fill_color(245, 245, 245)
        pdf.cell(0, 5, line, 0, 1, 'L', True)
        pdf.set_font('Arial', '', 11)
    # Listes
    elif line.startswith('- ') or line.startswith('* '):
        pdf.cell(10, 5, '', 0, 0)  # Indentation
        pdf.cell(0, 5, line[2:], 0, 1)
    # Tableaux (lignes avec |)
    elif '|' in line and line.count('|') >= 2:
        # Simple traitement des tableaux
        cells = line.split('|')
        for cell in cells:
            if cell.strip():
                pdf.cell(40, 5, cell.strip(), 1, 0, 'C')
        pdf.ln()
    # Texte normal
    else:
        # Gérer les lignes trop longues
        if len(line) > 80:
            wrapped_lines = textwrap.wrap(line, 80)
            for wrapped_line in wrapped_lines:
                pdf.cell(0, 5, wrapped_line, 0, 1)
        else:
            pdf.cell(0, 5, line, 0, 1)

# Sauvegarder le PDF
pdf.output('TP1_POO_Rapport.pdf')
print('PDF généré avec succès: TP1_POO_Rapport.pdf')
