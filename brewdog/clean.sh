#!/bin/bash

find . -name '*~' -or -name '*.class' | xargs -r rm
