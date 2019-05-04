PYTHON := python

venv: venv/bin/activate

venv/bin/activate: requirements.txt
	test -d venv || $(PYTHON) -mvenv ./venv
	. ./venv/bin/activate && pip install --upgrade pip
	. ./venv/bin/activate && pip install -Ur requirements.txt
	touch ./venv/bin/activate

clean:
	rm -fr venv
	find . -name "*.pyc" -delete
	find . -name '__pycache__' | xargs rm -fr
	find . -name '*.egg-info' | xargs rm -fr

.PHONY: clean

# vim: ft=make
