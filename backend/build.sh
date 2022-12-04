#!/usr/bin/sh

set -xe

cc todo.c `pkg-config --libs libpq` -o todo -W -Wall -Wextra -g -O0
