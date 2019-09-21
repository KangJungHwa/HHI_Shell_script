#!/bin/bash
find ${HOME}/log/* -mtime +10 -delete;
find ${HOME}/oozie-oozi/* -mtime +10 -delete;

