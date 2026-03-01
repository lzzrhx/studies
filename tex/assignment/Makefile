build:
	lualatex main.tex
dither:
	magick -density 300 main.pdf \( +clone -blur 0x1 \) +swap -ordered-dither 8x8 -gamma 0.1 main-effect.pdf
	magick -density 300 main-effect.pdf -resize 90% -blur 0x0.5 -rotate 0.3 -quality 85 -compress JPEG main-effect.pdf
