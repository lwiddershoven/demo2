
echo "Local application.properties overrides the properties in the compiled-in file, but not the file itself"
cat ./application.properties

echo ""

echo "An individual property can be set on the command line"
java -jar ../01-hardcoded/target/Hardcoded-0.0.1-SNAPSHOT.jar --demo2.one=two

echo ""
echo "Pay special attention to demo2.two and demo2.one"
