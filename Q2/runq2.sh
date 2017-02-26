file="log.log"
if [ -f $file ] ; then
			rm $file
		fi
		javac q2_main.java
		java q2_main
cat "log.log"
