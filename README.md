# OSGi Framework Calculator Application

This is a Calculator desktop application that is built using the JFrame and converts words of numbers to actual numbers and calculates them. The results are displayed back in words. Currently, the application supports Turkish and English languages.

## Technology Stack

This application is built using the following technologies:

- Java 17
- Equinox OSGi Framework

## Installation

### Prerequisites

To run this project, you need to have the following installed on your system:

- Java 17 JDK
- Equinox OSGi Framework

### Clone the Repository

To get started with the project, clone this repository to your local machine:

```bash
git clone https://github.com/Calculator-OSGi-Framework/osgi-calculator-app.git
```

### Build and Run

You can build and run the project using the following commands:

```bash
cd osgi-calculator-app/
mvn clean install
java -jar target/osgi-calculator-app.jar
```
## Features 

- Converts words of numbers to actual numbers
- Supports both Turkish and English languages
- Performs basic mathematical calculations
- Results are displayed in words

## How to Use

1. Clone the repository
2. Install Java 17 JDK and Equinox OSGi Framework
3. Build and run the project using the following commands:

   ```bash
   cd osgi-calculator-app/
   mvn clean install
   java -jar target/osgi-calculator-app.jar
   ```

4. The user interface will appear on the screen with an input text field and four buttons for the basic arithmetic operations - addition, subtraction, multiplication, and division.
5. Enter the numbers in words in the selected language, followed by the arithmetic symbol (+, -, *, /), and then type in the second number in words in the same.
6. Example is : "one hundred twenty one" (English), "bin yirmi bir"(Turkish)
7. Click the desired arithmetic operation button or press Enter to calculate the result.
8. The result will appear in the output text field, displayed in words.

That's it! You can use this application to perform basic mathematical calculations in English or Turkish.


## Contributing 

Contributions to this project are more than welcome. Please follow the below steps:

1. Clone the repository
2. Create a new branch for your changes
3. Make your changes and commit them
4. Push the changes to your branch
5. Open a pull request

## License

This project is licensed under the MIT License. Please see the [LICENSE.md](https://github.com/dwynwei/Calculator-OSGi-Framework/blob/main/LICENCE.md) file for details.

## Credits

This application was created by [dwynwei](https://github.com/dwynwei). Please feel free to contact me if you have any questions or feedback!
