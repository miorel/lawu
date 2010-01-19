#!/bin/bash
svn2cl --group-by-day --linelen=80 --authors=authors.xml --break-before-msg --stdout | tee ChangeLog
