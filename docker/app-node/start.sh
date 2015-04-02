#!/bin/bash -eu

if [[ ! -e $1 ]]; then
	echo " "
	echo "ERROR:    The executable $1 could not be found!"
	echo "          Did you remember to build the project before launching?"
	echo " "
	exit 1
fi

echo "Launching $@"
bash $@