
# Carbohydrate Calculator Automation Tests

Automated UI testing for [Carbohydrate Calculator](https://www.calculator.net/carbohydrate-calculator.html)  
Built using **Selenium**, **Cucumber**, and **JUnit** in a **Maven** project.

---

## Structure

```
Veeva-questionnaire-q5-bonus/
├── pom.xml
├── src/
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   └── stepDefinitions/
│       │       └── CarbohydrateCalculatorSteps.java
│       └── resources/
│           └── carbohydrate_calculator.feature
```

---

## Features Covered

| Test Case | Description |
|-----------|-------------|
| TC-001 | Valid age input test |
| TC-005 | Full valid form (Male, 25 y/o, 180cm, 75kg) |
| TC-014 | Page loads correctly in Chrome |

---

## How to Run the Tests

### 1. Clone the Repository

```bash
git clone https://github.com/mohdels/Veeva-questionnaire-q5-bonus.git
cd Veeva-questionnaire-q5-bonus
```

---

### 2. Install Requirements

Make sure you have:
- **Java 11+**
- **Maven**
- **Chrome browser**
- **ChromeDriver** installed and added to your system PATH  
  (Download: https://chromedriver.chromium.org/downloads)

---

### 3. Import the Project in IntelliJ or Eclipse

- Open your IDE
- File → Open → Select the project folder
- Wait for Maven to import dependencies

---

### 4. Run the Tests
- Navigate to `TestRunner.java`
- Right-click → Run `TestRunner`

---

## 🧪 Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber**
- **JUnit 4**
- **Maven**
