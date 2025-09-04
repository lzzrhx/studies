build:
	for i in *.hs; do ghc $$i; done
clean:
	for i in *.hs; do rm $${i%.*} $${i%.*}.hi $${i%.*}.o; done
