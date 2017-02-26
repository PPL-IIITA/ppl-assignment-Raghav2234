file="log.log"
if [ -f $file ] ; then
			rm $file
		fi
		javac ques1.java
		java ques1
	cat "log.log"
