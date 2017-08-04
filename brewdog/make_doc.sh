#!/bin/bash

JAVA_VERSION=8
PACKAGES="se.itu.brewdog.main se.itu.brewdog.gui se.itu.brewdog.beer"

javadoc -cp lib/* -sourcepath src/ -d docs -link http://docs.oracle.com/javase/${JAVA_VERSION}/docs/api/ $PACKAGES 
