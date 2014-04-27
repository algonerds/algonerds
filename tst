# run: ./tst dir/
# for example: ./tst BinarySearch/src/
# requirements: lib/hamcrest-core-1.3.jar  lib/junit-4.11.jar
#
rm $1*.class
javac $1* -cp "lib/*"
test=$(basename $(find $1 -name "*Test.java") .java)
echo "Running $test"
java -cp lib/*:$1 org.junit.runner.JUnitCore $test
