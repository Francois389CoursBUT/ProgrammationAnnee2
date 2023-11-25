import os
from shutil import copyfile

fichierOriginal = "index.html"
fichierCopie = "indexCopie.html"

copyfile(fichierOriginal, fichierCopie)

with open(fichierCopie, "r") as f:
    text = f.read()

text = text.replace("</body>", "<p>Salut</p>\n</body>")

with open(fichierCopie, "w") as f:
    f.write(text)