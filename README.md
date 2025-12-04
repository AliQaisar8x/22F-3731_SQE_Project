# UI Test Automation Framework - SQE Final Project

This is a complete **Software Quality Engineering** project implementation for testing **SauceDemo** (`https://www.saucedemo.com`).

## Tech Stack

- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (Gherkin + BDD)**
- **JUnit 5**
- **Allure Reports**
- **Apache POI** (Excel)
- **JDBC** (MySQL)
- **Jedis** (Redis)

## Project Structure

```
SQE_UI_Framework/
├── pom.xml                                    # Maven dependencies
├── src/test/java/com/nuces/sqe/framework/
│   ├── core/                                 # DriverFactory, ConfigReader
│   ├── pages/                                # Page Object Model (LoginPage, ProductsPage)
│   ├── steps/                                # Cucumber step definitions
│   ├── runners/                              # TestRunner.java
│   └── util/                                 # ExcelUtil, DbUtil, RedisUtil
└── src/test/resources/
    ├── features/                             # Gherkin feature files (15+ test cases)
    ├── testdata/                             # Excel files, SQL scripts
    └── *.properties                          # Configuration files
```

## Prerequisites

1. **Java 17+** installed
2. **Maven** installed
3. **Chrome browser** installed
4. **ChromeDriver** - Download from https://chromedriver.chromium.org/ and place in `drivers/` folder

## Quick Start

### Step 1: Configure WebDriver

1. Download ChromeDriver from https://chromedriver.chromium.org/
2. Create `drivers` folder in project root: `SQE_UI_Framework/drivers/`
3. Place `chromedriver.exe` in that folder
4. Or update `config.properties` with your ChromeDriver path

### Step 2: Run Tests

```bash
cd SQE_UI_Framework
mvn clean test
```

### Step 3: View Allure Report

```bash
mvn allure:serve
```

This will:
- Generate Allure report from test results
- Open report automatically in your browser
- Show passed/failed tests, screenshots, step logs

## Test Cases Included (15+)

### Login Tests (4 tests)
1. ✅ Login with valid credentials
2. ✅ Login with invalid credentials  
3. ✅ Login with empty fields
4. ✅ Logout test

### Product Tests (4 tests)
5. ✅ Search for a product
6. ✅ Open product details page
7. ✅ Add product to cart
8. ✅ Remove product from cart

### Checkout Tests (3 tests)
9. ✅ Fill checkout form
10. ✅ Apply wrong payment data
11. ✅ Successful order placement

### Form Tests (2 tests)
12. ✅ Fill contact form
13. ✅ Submit invalid data

### UI Validation Tests (2 tests)
14. ✅ Verify title and URLs
15. ✅ Verify broken links or images

## Configuration Files

### `config.properties`
```properties
baseUrl=https://www.saucedemo.com
browser=chrome
implicitWaitSeconds=10
headless=false
webdriver.chrome.driver=drivers/chromedriver.exe
```

### `db.properties` (Optional - for database tests)
```properties
db.url=jdbc:mysql://localhost:3306/testdb
db.username=root
db.password=yourpassword
```

### `redis.properties` (Optional - for Redis tests)
```properties
redis.host=localhost
redis.port=6379
```

## Data-Driven Testing

### Excel Data
- Test data stored in: `src/test/resources/testdata/login-data.xlsx`
- Used for login scenarios with multiple user credentials

### Database Integration
- Sample queries in `DbUtil.java`
- Reads product data from MySQL database

### Redis Integration  
- Stores/retrieves session tokens
- Used for authentication state management

## Allure Reports

After running tests, generate report:

```bash
mvn allure:serve
```

Report includes:
- ✅ Passed/Failed test summary
- 📸 Screenshots on failure
- 📝 Step-by-step execution logs
- 📊 Test duration and statistics

## GitHub Setup

1. Initialize git repository:
```bash
cd SQE_UI_Framework
git init
git add .
git commit -m "Initial commit - SQE UI Test Framework"
```

2. Create repository on GitHub
3. Push code:
```bash
git remote add origin <your-github-repo-url>
git branch -M main
git push -u origin main
```

## Project Requirements Checklist

- ✅ **Test Automation Framework** - Complete with Page Object Model
- ✅ **Gherkin + BDD** - All tests written in Cucumber
- ✅ **15+ Test Cases** - Login, Product, Checkout, Form, UI Validation
- ✅ **Allure Reports** - Integrated with screenshots
- ✅ **Data-Driven Tests** - Excel, Database, Redis
- ✅ **Design Patterns** - Page Object Model (POM)
- ✅ **GitHub Ready** - Clean project structure

## Troubleshooting

### ChromeDriver Issues
- Make sure ChromeDriver version matches your Chrome browser version
- Place ChromeDriver in `drivers/` folder or update path in `config.properties`

### Maven Build Fails
- Check Java version: `java -version` (should be 17+)
- Check Maven: `mvn -version`
- Clear Maven cache: `mvn clean`

### Tests Fail
- Check internet connection (tests access saucedemo.com)
- Verify ChromeDriver is accessible
- Check `config.properties` settings

## Next Steps for Submission

1. ✅ Run all tests successfully
2. ✅ Generate Allure report
3. ✅ Record video of complete framework execution
4. ✅ Push code to GitHub
5. ✅ Create documentation (this README)
6. ✅ Prepare for viva demonstration

## Contact

For questions about this framework, refer to the project requirements document.
