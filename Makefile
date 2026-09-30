all:
	@echo 'Building project...'
	@echo 'Compiling Java sources...'
	javac -d bin -cp src/main/java $(shell find src/main/java -name '*.java')
	@echo 'Project built successfully.'

test:
	@echo 'Running tests...'
	@echo 'Compiling test sources...'
	javac -d bin -cp src/test/java $(shell find src/test/java -name '*.java')
	@echo 'Running tests...'
	java -cp bin com.example.pediatricicudrugcalculator.InputProcessorTest
	java -cp bin com.example.pediatricicudrugcalculator.DosageCalculatorTest
	java -cp bin com.example.pediatricicudrugcalculator.SafetyValidatorTest

clean:
	@echo 'Cleaning project...'
	rm -rf bin
	rm -rf target
