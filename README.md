OSGi Calculator Desktop Application

This is a desktop application that uses the Equinox OSGi framework to provide a flexible and modular architecture for the conversion of words to numbers and mathematical calculations. It is implemented using Java 17.

Requirements

Java JDK 17 or higher
Equinox OSGi Framework

Installation

Clone the repository or download the source code.
Extract the files to a directory of your choice.
Navigate to the root directory of the project.
Open a terminal and run the command mvn clean package. This will create a JAR file in the target directory.
Copy the JAR file to the bundle directory of the Equinox installation.
Start the Equinox framework by running the command java -jar <path-to-equinox>/plugins/org.eclipse.osgi.jar.
In the Equinox console, install the OSGi bundle by running the command install file:/path/to/calculator-bundle.jar.
Start the OSGi bundle by running the command start <bundle-id>.
Usage
Once the OSGi bundle is installed and started, the calculator desktop application can be accessed by opening the application window.

To convert words to numbers, type the words in the input field labeled "Convert words to numbers" and click the "Convert" button. The result will be displayed in the output field labeled "Result".

To perform mathematical calculations, type the equation in the input field labeled "Enter equation" and click the "Calculate" button. The result will be displayed in the output field labeled "Result".

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
This project was created as part of a course on OSGi frameworks and inspired by the Equinox tutorial.
