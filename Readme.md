# Selenium UI Automation Framework

A production-grade UI test automation framework built with **Java + Selenium WebDriver**, following industry-standard design patterns to ensure scalability, maintainability, and reusability.

---

## 🛠 Tech Stack

| Tool | Purpose |
|------|---------|
| Java | Core programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and management |
| Maven | Build and dependency management |
| ExtentReports | HTML test execution reports |
| Log4j | Logging |
| Gson & Jackson | JSON parsing |
| Apache POI | Excel file reading |

---

## 🏗 Framework Architecture

```
Selenium_Automation_Framework/
│
├── config/
│   ├── QA.properties         # Environment URL (Properties format)
│   └── config.json           # Multi-environment config (QA/UAT/PROD) in JSON format
│
├── testData/
│   ├── loginData.json        # Test data in JSON format
│   ├── loginData.xlsx        # Test data in Excel format
│   └── loginData.csv         # Test data in CSV format
│
├── src/test/java/
│   ├── com/constants/
│   │   ├── Browser.java      # Enum for supported browsers (CHROME, EDGE)
│   │   └── Env.java          # Enum for environments (QA, DEV, UAT)
│   │
│   ├── com/ui/
│   │   ├── dataproviders/
│   │   │   └── LoginDataProvider.java   # Supplies test data via @DataProvider (JSON/CSV/Excel)
│   │   │
│   │   ├── listeners/
│   │   │   ├── testListner.java         # ITestListener - Reporting + Screenshot on failure
│   │   │   └── MyRetryAnalyser.java     # IRetryAnalyzer - Retries failed tests up to 3 times
│   │   │
│   │   ├── pages/
│   │   │   ├── HomePage.java            # Page Object - Landing page actions
│   │   │   ├── LoginPage.java           # Page Object - Login page actions & locators
│   │   │   └── Myaccount.java           # Page Object - Post-login account page
│   │   │
│   │   ├── pojos/
│   │   │   ├── Config.java              # Maps config.json structure
│   │   │   ├── Environment.java         # Maps environment-level data (URL)
│   │   │   ├── TestData.java            # Maps loginData.json (List of Users)
│   │   │   └── User.java               # Represents a single user (email + password)
│   │   │
│   │   └── tests/
│   │       ├── TestBase.java            # @BeforeMethod - Browser setup before each test
│   │       └── Signup3.java            # Test class - Login flow via JSON, CSV, Excel
│   │
│   └── com/utility/
│       ├── BrowserUtility.java          # Abstract base - ThreadLocal WebDriver + reusable actions
│       ├── PropertiesUtil.java          # Reads QA.properties
│       ├── JSONUtility.java             # Reads config.json using Gson
│       ├── ExtentReportsUtility.java    # Thread-safe ExtentReports utility
│       ├── loggerUtility.java           # Singleton Log4j logger
│       ├── Excelreader.java             # Reads Excel test data
│       └── CSVReaderUtility.java        # Reads CSV test data
│
└── src/test/resources/
    └── log4j2.xml                       # Log4j configuration
```

---

## 🔑 Key Design Patterns & Concepts

### 1. Page Object Model (POM)
Each web page has a dedicated Java class containing locators and actions. Test scripts only call page methods — no locators in test classes. This ensures a single place to update if UI changes.

### 2. Inheritance-Based Architecture
All Page classes extend `BrowserUtility`, which provides reusable WebDriver actions (`click`, `enterText`, `getText`, `takescreenshot`). Tests extend `TestBase`, which handles browser setup via `@BeforeMethod`.

### 3. Thread-Safe WebDriver (ThreadLocal)
`BrowserUtility` uses `ThreadLocal<WebDriver>` to ensure each test thread gets its own driver instance — enabling safe parallel test execution.

### 4. Data-Driven Testing (DDT)
Login tests are executed with multiple data sets from three different sources:
- **JSON** → parsed using Gson and Jackson
- **Excel** → read using Apache POI
- **CSV** → read using CSVReaderUtility

### 5. Environment Configuration
Two approaches implemented to demonstrate flexibility:
- `.properties` file → simple key-value, one file per environment
- `config.json` → structured JSON with all environments (QA/UAT/PROD) in one file, parsed via Gson into POJOs

### 6. Enums for Type Safety
`Browser.java` and `Env.java` use Java enums to avoid hardcoded strings, eliminating typo-related bugs.

### 7. TestNG Listeners
- `testListner` implements `ITestListener` for lifecycle hooks: initializes ExtentReports, logs pass/fail/skip, captures screenshots on failure
- `MyRetryAnalyser` implements `IRetryAnalyzer` to retry flaky tests up to 3 times before marking as failed

### 8. Singleton & ThreadLocal Patterns
- `loggerUtility` uses Singleton to ensure one logger instance per class
- `ExtentReportsUtility` uses `ThreadLocal<ExtentTest>` for thread-safe reporting during parallel runs

---

## ⚙️ How to Run

### Prerequisites
- Java 17+
- Maven
- Chrome or Edge browser

### Run via Maven
```bash
mvn test
```

### Run specific TestNG suite
```bash
mvn test -DsuiteXmlFile=testNGParallel.xml
```

### Switch browser
Update `config/QA.properties` or pass as Maven argument:
```bash
mvn test -Dbrowser=chrome
```

---

## 📊 Reporting
After test execution, an HTML report is generated at:
```
Extentreport.html
```
Open in any browser to view detailed pass/fail results with logs.

---

## 📌 Application Under Test
**Automation Exercise** — [https://automationexercise.com](https://automationexercise.com)  
An e-commerce practice site used to demonstrate the framework capabilities.

---

## 👤 Author
**Shivayogi B K**  
GitHub: [ShivaBK777](https://github.com/ShivaBK777)
