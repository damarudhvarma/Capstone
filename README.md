<div align="center">

# 🛒 Capstone Project — PrestaShop Test Automation Framework

### 🥒 Selenium + Cucumber (BDD) + TestNG | ☕ Java | Page Object Model

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.18.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.15.0-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)](https://cucumber.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.9.0-F7941E?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-2.25.0-FF5A5F?style=for-the-badge&logo=qameta&logoColor=white)](https://qameta.io/)
[![Log4j2](https://img.shields.io/badge/Log4j2-2.23.1-005A9C?style=for-the-badge&logo=apache&logoColor=white)](https://logging.apache.org/log4j/2.x/)

An end-to-end **UI test automation framework** built for the [PrestaShop demo store](https://demo.prestashop.com/#/en/front). It uses **Selenium WebDriver 🌐 + Cucumber 🥒 (BDD) + TestNG 🧪** with the **Page Object Model (POM)** design pattern to automate and verify core e-commerce user journeys — signup, login, product search, add-to-cart, checkout (registered & guest), order history verification, contact-us form submission, multi-product cart validation, and product sort/filter.

</div>

---

## 📋 1. Project Overview

This is a **Capstone automation project** that simulates real-world QA testing of an online shopping site (PrestaShop). It is written in **☕ Java** and managed with **📦 Maven**. Test scenarios are written in **🥒 Gherkin** (plain-English `.feature` files) and mapped to Java step-definition classes, which in turn drive the browser through Page Object classes. The framework also includes **standalone TestNG test classes** (in the `Testng` package) that run flows independently of Cucumber, and a **utilities layer** (`utils`) that provides Excel-based data reading and externalized configuration via a properties file.

### 🎯 What is being automated / tested

| Flow | Description |
|---|---|
| 👤 **User Signup** | New user registration with first name, last name, email, password, and consent checkboxes; also validates empty-field error messages |
| 🔐 **User Login** | Login with a registered email/password (valid credentials loop) |
| ✉️ **User Registration via Email** | Full account creation flow from Sign In → Create Your Account → fill form → verify My Account page |
| 🔍 **Product Search & Cart** | Search a product (e.g. "tshirt"), select it, and add it to the cart |
| ⭐ **Featured Product Checkout** | Login → browse "All Featured Products" → customize a product (color/quantity) → add to cart → checkout → shipping |
| 🛍️ **Guest Checkout** | Complete a full checkout as a guest — personal info, address, shipping method, payment method |
| 📦 **Registered Checkout / Booking** | Signup → search → add to cart → enter shipping address → select payment (COD) → place order |
| 🧾 **Order History Verification** | Navigate to "My Orders", open order details, and validate order status/date/product/quantity/price |
| 📩 **Contact Us Form** | Navigate to Contact Us page, enter email & message, submit form, verify success |
| 🛒 **Search and Add to Cart** | Search for a product from home page and verify it is added to the shopping cart |
| ➕ **Add Multiple Products to Cart** | Search and add multiple products; verify both appear in the cart |
| 🔀 **Sort Products** | Sort products by Name (A→Z), Price (high→low / low→high), and Sales (highest→lowest) |

📸 **Test reporting & evidence** is captured via **Cucumber HTML reports**, **Allure Reports**, **ExtentReports (Spark)**, and **automatic screenshots** on every step (extra capture on failure).

---

## 🧰 2. Tech Stack / Frameworks Used

| Category | Technology |
|---|---|
| ☕ Language | **Java 17** |
| 📦 Build Tool | **Maven** |
| 🌐 Browser Automation | **Selenium WebDriver 4.18.0** |
| 🥒 BDD Framework | **Cucumber (cucumber-java, cucumber-testng) 7.15.0** |
| 🧪 Test Runner / Execution | **TestNG 7.9.0** (via `AbstractTestNGCucumberTests` for Cucumber runners; standalone `@Test` classes in `Testng` package) |
| 🚗 Driver Management | **WebDriverManager 5.6.3** (auto-downloads/matches ChromeDriver) |
| 📊 Reporting | **Allure Reports 2.25.0** (`allure-cucumber7-jvm`, `allure-testng`) + **ExtentReports 5.1.1** (`extentreports-cucumber7-adapter`) + native Cucumber `pretty`/HTML/JSON reports |
| 📝 Logging | **Log4j2 2.23.1** (`log4j-core`, `log4j-api`, `log4j-slf4j2-impl`) — configured via `src/main/resources/log4j2.xml` |
| 📂 Test Data | **Apache POI** — reads `Book1.xlsx` for data-driven login; path externalized in `data.propertites` |
| 🏗️ Design Pattern | **Page Object Model (POM)** using `@FindBy` PageFactory annotations |
| 🖥️ IDE Config | Eclipse (`.project`, `.classpath`, `.settings`) |
| 🔧 Version Control | Git / GitHub (`damarudhvarma/Capstone`) |

---

## 🗂️ 3. Project File Structure

```
Capstone/
|-- pom.xml                          # Maven project config & all dependencies
|-- testng.xml                       # Root TestNG suite (BDD Cucumber Test Suite)
|-- .gitignore
|-- .classpath / .project / .settings/   # Eclipse IDE metadata
|-- .mvn/                            # Maven wrapper config (maven.config, jvm.config)
|-- .allure/                         # Local Allure CLI installation
|-- allure-results/                  # Raw Allure result JSON + attachments (generated)
|-- test-output/                     # TestNG output (HTML/XML reports, generated)
|-- screenshot/                      # Screenshots captured on step execution / failures
|-- target/                          # Maven build output (compiled classes, generated reports)
|-- extent.properties                # Root-level ExtentReports config (legacy / override)
|
+-- testngpom/                       # 🧪 TestNG XML suites for standalone (non-BDD) tests
|   +-- Contactus.xml                # Suite config for Contactustestng (browser + URL params)
|
+-- src/
    +-- main/
    |   +-- java/
    |   |   +-- Capstone_project/
    |   |   |   +-- Capstone_project/
    |   |   |       +-- App.java             # Default Maven-generated entry point ("Hello World")
    |   |   |
    |   |   +-- pages/                       # 🏗️ Core Page Object Model (production POM classes)
    |   |       +-- BasePage.java                     # Common driver/PageFactory init for all pages
    |   |       +-- PrestaShopHomePage.java            # Home page navigation, Sign-in link
    |   |       +-- PrestaShopLoginPage.java           # Login form + navigate to Create Account
    |   |       +-- PrestaShopRegistrationPage.java    # New user registration form
    |   |       +-- PrestaShopProductPage.java         # Featured products, search, add to cart, checkout nav
    |   |       +-- PrestaShopGuestCheckoutPage.java   # Guest personal info, address, shipping, payment
    |   |
    |   +-- resources/
    |       +-- log4j2.xml                   # 📝 Log4j2 configuration (Console + File appenders, DEBUG level)
    |
    +-- test/
        +-- java/
        |   +-- base/
        |   |   +-- BaseClass.java            # ThreadLocal WebDriver factory (init/get/quit)
        |   |
        |   +-- hooks/
        |   |   +-- Hooks.java                # 🎣 Cucumber @Before/@After hooks: launch browser,
        |   |                                 # navigate to site, capture screenshots, quit driver
        |   |
        |   +-- Features/                     # 🥒 Gherkin BDD feature files (test scenarios)
        |   |   +-- signup.feature                    # User registration (outline + empty-field validation)
        |   |   +-- user_login.feature                # Registration, login loop, search+checkout, guest checkout
        |   |   +-- FeaturedProduct.feature            # Featured product purchase flow
        |   |   +-- Booking.feature                    # Full purchase (outline) + order-history verification
        |   |   +-- ContactUs.feature                  # Contact Us form submission
        |   |   +-- serachAndAddtoCart.feature         # Search and add a product to cart
        |   |   +-- addMultipleProducts.feature        # Add multiple products to cart
        |   |   +-- SortProducts.feature               # Sort products by name, price, sales
        |   |
        |   +-- StepDef/                      # 🔗 Step definition classes (Gherkin to Java glue code)
        |   |   +-- SignupDef.java
        |   |   +-- PrestaShopLoginSteps.java
        |   |   +-- ShoppingStepDef.java
        |   |   +-- Featuredprodsteps.java
        |   |   +-- ContactUsDef.java                  # Now uses Log4j2 logger for step-level logging
        |   |   +-- SearchAndAddToCartDef.java
        |   |   +-- MultipleProductsToCart.java
        |   |
        |   +-- Runner/                       # 🏃 TestNG/Cucumber test runners (entry points to execute tests)
        |   |   +-- TestRunner.java                    # Runs user_login.feature (all 4 scenarios)
        |   |   +-- SignupRunner.java                   # Runs signup.feature
        |   |   +-- ShoppingRunner.java                 # Runs Booking.feature
        |   |   +-- Featuredprodrunner.java             # Runs FeaturedProduct.feature
        |   |   +-- ContactUsRunner.java                # Runs ContactUs.feature
        |   |   +-- SearchAndAddToCartRunner.java       # Runs serachAndAddtoCart.feature
        |   |   +-- MultipleProductsRunner.java         # Runs addMultipleProducts.feature
        |   |   +-- SortProductsRunner.java             # Runs SortProducts.feature (4 sort scenarios)
        |   |
        |   +-- Testng/                       # 🧪 Standalone TestNG test classes (non-BDD, direct flow tests)
        |   |   +-- Signuptestng.java                  # Signup + Excel data-driven login (Log4j2 + Apache POI)
        |   |   +-- Shoppingtestng.java                # Full shopping flow: signup → cart → checkout → orders
        |   |   +-- Contactustestng.java               # Contact Us flow; supports browser/URL @Parameters
        |   |   +-- SearchandAddtocart.java            # Standalone search + add-to-cart flow
        |   |   +-- multipleproducts.java              # Standalone multiple products cart flow
        |   |
        |   +-- prestapages/                  # Additional / alternate Page Object classes used by
        |   |   |                             # some step definitions and older/experimental flows
        |   |   +-- AuthPOM.java                         # Signup + Login page objects
        |   |   +-- FeaturedProductsPOM.java              # Featured products browsing & cart page object
        |   |   +-- CheckoutPage.java                      # Checkout + address page object
        |   |   +-- checkoutandshipping.java               # Checkout & shipping page object (variant)
        |   |   +-- orderinfo.java                         # My Orders / order details page object
        |   |   +-- prestaloginandsignup1.java              # Combined login+signup page object (variant)
        |   |   +-- prestarunpages1.java                    # Supplementary page object helper
        |   |   +-- ContactUs.java                         # Contact Us page object
        |   |   +-- SearchAndAddToCart.java                # Search and add-to-cart page object
        |   |   +-- MultipleProductsAdding.java             # Multiple product cart page object
        |   |   +-- SortProducts.java                      # Product sort/filter page object
        |   |   +-- TestSignup.java                        # Standalone signup test class
        |   |   +-- TestFeaturedProducts.java              # Standalone featured-products test class
        |   |
        |   +-- utils/                        # 🔧 Utility / test data layer
        |       +-- Book1.xlsx                            # Excel workbook — credentials & test data (Sheet1)
        |       +-- data.propertites                      # Properties file — externalizes excelPath key
        |
        +-- resources/
            +-- extent.properties             # ⚙️ ExtentReports / Spark config (output path, screenshots dir)
```

---

## 🏗️ 4. Page Object Models (POM)

The framework maintains **two POM sets**: a clean production set under `src/main/java/pages`, and an expanded/experimental set under `src/test/java/prestapages` used by some step definitions.

### 📁 `src/main/java/pages` (primary POM)
- 🧱 **`BasePage`** — base class every page extends; initializes `WebDriver` and `PageFactory`.
- 🏠 **`PrestaShopHomePage`** — home page load, "Sign in" link click.
- 🔐 **`PrestaShopLoginPage`** — enter login credentials, navigate to "Create your account".
- ✍️ **`PrestaShopRegistrationPage`** — fills and submits the new-account registration form, verifies success.
- 🛍️ **`PrestaShopProductPage`** — "All Featured Products" navigation, product search, product selection, add-to-cart, proceed-to-checkout, personal-information page verification.
- 💳 **`PrestaShopGuestCheckoutPage`** — guest personal information, address entry, shipping method selection, payment method selection, and order placement verification.

### 📁 `src/test/java/prestapages` (extended POM used in additional scenarios)
- 🔑 **`AuthPOM`** — signup + login locators/actions (sign-in link, gender, name, email, password, GDPR checkboxes, sign out, user menu).
- ⭐ **`FeaturedProductsPOM`** — featured products listing, category filter, sort dropdown, product color/quantity, add-to-cart, continue shopping, cart, checkout.
- 🧾 **`CheckoutPage` / `checkoutandshipping`** — checkout page, product tile, add-to-cart, proceed-to-checkout, new address form (first/last name, email, address, state, postcode, city, country, GDPR).
- 📦 **`orderinfo`** — "My Orders" navigation, order details, order status/date, product name/quantity/total price.
- 📩 **`ContactUs`** — Contact Us page navigation, email field, message textarea, submit button, success confirmation.
- 🔍 **`SearchAndAddToCart`** — product search bar, product selection from results, add-to-cart and cart count verification.
- ➕ **`MultipleProductsAdding`** — search and add multiple distinct products to cart, verify combined cart contents.
- 🔀 **`SortProducts`** — product sort/filter controls on listing pages.
- 🔗 **`prestaloginandsignup1` / `prestarunpages1`** — variant/combined login-signup page objects and helper runner-style page class.

---

## 🧪 4a. Standalone TestNG Test Classes (`Testng` Package)

In addition to the BDD Cucumber runners, the framework includes **pure TestNG test classes** that execute flows directly without Gherkin feature files. These are useful for rapid debugging and exploratory execution.

| Class | Description |
|---|---|
| `Signuptestng` | Signup with `@DataProvider`, then reads credentials from `Book1.xlsx` (via `data.propertites`) and logs in; uses **Log4j2** for step logging |
| `Shoppingtestng` | End-to-end shopping flow split into 12 prioritized `@Test` methods: signup → featured products → search → cart → checkout → shipping → payment → order confirmation → order history |
| `Contactustestng` | Contact Us form test; supports **cross-browser execution** via `@Parameters({"browser","url"})` configured from `testngpom/Contactus.xml` |
| `SearchandAddtocart` | Standalone search + add-to-cart flow against the live PrestaShop demo |
| `multipleproducts` | Searches and adds two separate products to the cart, then verifies combined cart contents |

---

## 📝 4b. Logging Configuration (`log4j2.xml`)

Log4j2 is configured in `src/main/resources/log4j2.xml` with **two appenders**:

| Appender | Target | Pattern |
|---|---|---|
| `Console` | `SYSTEM_OUT` | `%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger - %msg%n` |
| `FileLogger` | `/application/logs` | `%d %-5p %c - %m%n` |

- **Root log level:** `DEBUG` (captures all log levels from all classes)
- Both appenders are active by default for the root logger
- `Logger` instances are declared in `Signuptestng` and `ContactUsDef` (with further adoption planned across step definition classes)

---

## ⚙️ 4c. ExtentReports Configuration (`extent.properties`)

Located at `src/test/resources/extent.properties`, this file controls ExtentReports output paths used by the `extentreports-cucumber7-adapter`:

```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=test-output/SparkReport/Spark.html

basefolder.name=test-output/ExtentReports
basefolder.datetimepattern=dd-MM-yyyy_HH-mm-ss

screenshot.dir=test-output/screenshots/
screenshot.rel.path=../screenshots/
```

The generated **Spark HTML report** is written to `test-output/SparkReport/Spark.html` and timestamped report folders are created under `test-output/ExtentReports/`.

---

## 🔧 4d. Test Data Layer (`utils` Package)

The `src/test/java/utils/` directory provides externalized test data for data-driven tests:

| File | Purpose |
|---|---|
| `Book1.xlsx` | Excel workbook (Sheet1) containing credentials and test data read by `Signuptestng` via Apache POI |
| `data.propertites` | Java properties file that externalizes the Excel file path (`excelPath=src/test/java/utils/Book1.xlsx`) so that tests remain path-agnostic |

**How it works in `Signuptestng`:**
1. `FileInputStream` reads `data.propertites`
2. `Properties.getProperty("excelPath")` resolves the path to `Book1.xlsx`
3. `XSSFWorkbook` / `XSSFSheet` (Apache POI) reads `Sheet1` — extracts username (cell 0) and password (cell 1) from row 0
4. Log4j2 logs each read operation (`logger.info("read username from excel....")`)
5. Credentials are passed to `prestaloginandsignup1.signin(username, pass)`

---

## 🥒 5. Feature Files & Scenarios (BDD Test Cases)

### 📄 `signup.feature` — PrestaShop User Signingup

| ID | Scenario | Type |
|---|---|---|
| SUP-01 | ✅ **User signs up successfully** — data-driven signup with first name, last name, email & password for 2 example rows | Scenario Outline |
| SUP-02 | ⚠️ **Registration with mandatory fields empty** — submits blank form and verifies validation messages are displayed | Scenario |

**Example Data (SUP-01):**

| fname | lname | email | password |
|---|---|---|---|
| Damarudh | Varma | damarudh@test.com | Test@1234$ |
| abc | Def | abd@test.com | Test@12$ |

---

### 📄 `user_login.feature` — PrestaShop Authentication Engine

| ID | Scenario | Tag |
|---|---|---|
| PS01 | ✉️ **Verify user registration using email** — Sign In → Create Your Account → fill details → verify My Account page | `@Registration` |
| PS02 | 🔐 **User Login Verification Loop with Valid Credentials** — navigate to sign-in screen and submit registered email & password | *(untagged)* |
| PS03 | 🔍 **Search Product Add To Cart And Checkout** — browse featured products, search "tshirt", add to cart, proceed to checkout, verify personal information page | `@ProductSearch` |
| PS04 | 🛍️ **Complete Guest Checkout** — search "tshirt" → add to cart → checkout → fill guest personal info, address, shipping, payment → verify order placed | `@GuestCheckout` |

---

### 📄 `FeaturedProduct.feature` — Featured Product Checkout Flow

| ID | Scenario | Tag |
|---|---|---|
| FP-01 | ⭐ **User purchases a featured product successfully** — login → navigate to featured products → select & customize product → add to cart → proceed through checkout & shipping → verify checkout page displayed | `@prestashop @checkoutFlow` |

---

### 📄 `Booking.feature` — PrestaShop User Shopping Flow

| ID | Scenario | Type |
|---|---|---|
| BK-01 | 📦 **User login search and buys a product** — signup → browse featured products → search → add to cart → proceed to checkout → enter shipping name/address/postcode/city → select payment mode (COD) → confirm order → verify order placed | Scenario Outline |
| BK-02 | 🧾 **User order booking verification** — go to My Orders section → click order details → verify order details (status, date, product, quantity, price) | Scenario |

**Example Data (BK-01):**

| fname | lname | address | postcode | city | payment |
|---|---|---|---|---|---|
| Damarudh | Varma | Hyderabad Colony | 90001 | California | cod |

---

### 📄 `ContactUs.feature` — Contact Us Form Submission

| ID | Scenario | Type |
|---|---|---|
| CU-01 | 📩 **Submit Contact Us form successfully** — navigate to Contact Us page → enter contact email → enter issue message → click "Send your message" → verify form submitted successfully | Scenario |

---

### 📄 `serachAndAddtoCart.feature` — Search and Add to Cart

| ID | Scenario | Type |
|---|---|---|
| SAC-01 | 🔍 **Add searched product to cart** — start from home page → search and select a product → verify searched product is added to shopping cart | Scenario |

---

### 📄 `addMultipleProducts.feature` — Add Multiple Products to Cart

| ID | Scenario | Type |
|---|---|---|
| AMP-01 | ➕ **Add multiple products to cart** — start from home page → search product and add to cart (repeat for second product) → verify two products are present in the cart | Scenario |

---

### 📄 `SortProducts.feature` — Sort Products

| ID | Scenario | Tag |
|---|---|---|
| SP-01 | 🔀 **User sorts the products by name A to Z** | *(untagged)* |
| SP-02 | 🔀 **User sorts the products by Price, high to low** | *(untagged)* |
| SP-03 | 🔀 **User sorts the products by Price, low to high** | *(untagged)* |
| SP-04 | 🔀 **User sorts the products by Sales, highest to lowest** | *(untagged)* |

---

## 🏃 6. Runner to Feature File Mapping

### Cucumber BDD Runners (`Runner/`)

| Runner Class | Feature File | Scenarios Covered |
|---|---|---|
| `TestRunner.java` | `user_login.feature` | PS01, PS02, PS03, PS04 |
| `SignupRunner.java` | `signup.feature` | SUP-01, SUP-02 |
| `ShoppingRunner.java` | `Booking.feature` | BK-01, BK-02 |
| `Featuredprodrunner.java` | `FeaturedProduct.feature` | FP-01 |
| `ContactUsRunner.java` | `ContactUs.feature` | CU-01 |
| `SearchAndAddToCartRunner.java` | `serachAndAddtoCart.feature` | SAC-01 |
| `MultipleProductsRunner.java` | `addMultipleProducts.feature` | AMP-01 |
| `SortProductsRunner.java` | `SortProducts.feature` | SP-01, SP-02, SP-03, SP-04 |

### Standalone TestNG Suites (`testngpom/`)

| XML Suite | TestNG Class | Notes |
|---|---|---|
| `testngpom/Contactus.xml` | `Testng.Contactustestng` | Parameterized: `browser=chrome`, `url=https://demo.prestashop.com/...` |

---

## ⚙️ 7. Test Execution Flow

1. 🌐 **`Hooks.launchBrowser()`** (`@Before`) initializes a `ChromeDriver` via `WebDriverManager` (through `BaseClass`, using a `ThreadLocal<WebDriver>` for thread-safety) and opens `https://demo.prestashop.com/#/en/front`.
2. 🥒 Cucumber matches Gherkin steps in the `.feature` files to methods in the **StepDef** classes.
3. 🏗️ StepDef classes call methods on the **Page Object** classes (`pages/*` or `prestapages/*`), which use Selenium locators (`@FindBy`) to interact with the UI.
4. 📝 **Log4j2** logs key actions (e.g., account creation, data reads, login) via `Logger` instances configured by `log4j2.xml` — output goes to console and file appender.
5. 📸 **`Hooks.captureScreenshotAfterEveryStep()`** (`@AfterStep`) attaches a screenshot to the Cucumber/Allure report after every step; on scenario failure, an additional screenshot is saved to `/screenshot`.
6. 🔚 **`Hooks.closeBrowser()`** (`@After`) quits the driver and clears the `ThreadLocal`.
7. 🏃 Each **Runner** class (`Runner/*.java`) extends `AbstractTestNGCucumberTests` and points to a specific `.feature` file via `@CucumberOptions`, generating `pretty`, HTML, JSON, Allure, and ExtentReports Spark output.

---

## ▶️ 8. How to Run the Tests

**Prerequisites:** ☕ Java 17, 📦 Maven, 🌐 Google Chrome installed.

```bash
# Run all tests (TestNG + Cucumber via Maven Surefire)
mvn clean test

# Run a specific Cucumber/BDD runner class only
mvn test -Dtest=Runner.TestRunner
mvn test -Dtest=Runner.SignupRunner
mvn test -Dtest=Runner.ShoppingRunner
mvn test -Dtest=Runner.Featuredprodrunner
mvn test -Dtest=Runner.ContactUsRunner
mvn test -Dtest=Runner.SearchAndAddToCartRunner
mvn test -Dtest=Runner.MultipleProductsRunner
mvn test -Dtest=Runner.SortProductsRunner

# Run a standalone TestNG class (non-BDD)
mvn test -Dtest=Testng.Signuptestng
mvn test -Dtest=Testng.Shoppingtestng
mvn test -Dtest=Testng.SearchandAddtocart
mvn test -Dtest=Testng.multipleproducts

# Run Contact Us standalone TestNG via its XML suite (parameterized browser/URL)
# Use Eclipse TestNG plugin → right-click testngpom/Contactus.xml → Run As → TestNG Suite
```

**📊 View reports:**
```bash
# Cucumber HTML reports (generated under /target)
open target/cucumber-reports/cucumber-html-report.html

# ExtentReports Spark HTML report
open test-output/SparkReport/Spark.html

# Allure report (uses results in /allure-results)
mvn allure:report
mvn allure:serve
```

TestNG's own results are written to `/test-output` (`emailable-report.html`, `index.html`).

---

## 📦 9. Key Dependencies (from `pom.xml`)

| Dependency | Version | Purpose |
|---|---|---|
| `org.seleniumhq.selenium:selenium-java` | 4.18.0 | 🌐 Browser automation |
| `io.cucumber:cucumber-java` | 7.15.0 | 🥒 Gherkin step definitions |
| `io.cucumber:cucumber-testng` | 7.15.0 | 🔗 Bridges Cucumber with TestNG runner |
| `org.testng:testng` | 7.9.0 | 🧪 Test execution engine |
| `io.github.bonigarcia:webdrivermanager` | 5.6.3 | 🚗 Automatic browser driver binary management |
| `tech.grasshopper:extentreports-cucumber7-adapter` | 1.14.0 | 📊 ExtentReports adapter for Cucumber |
| `com.aventstack:extentreports` | 5.1.1 | 📈 Rich HTML test reporting |
| `io.qameta.allure:allure-cucumber7-jvm` | 2.25.0 | 📊 Allure reporting for Cucumber |
| `io.qameta.allure:allure-testng` | 2.25.0 | 📊 Allure reporting for TestNG |
| `org.apache.logging.log4j:log4j-core` / `log4j-api` / `log4j-slf4j2-impl` | 2.23.1 | 📝 Logging (configured via `log4j2.xml`) |
| `org.apache.poi:poi-ooxml` | *(see pom.xml)* | 📂 Apache POI — reads `Book1.xlsx` Excel data |

**Build plugins:** `maven-compiler-plugin`, `maven-surefire-plugin`, `maven-clean-plugin`, `maven-resources-plugin`, `maven-jar-plugin`, `allure-maven` (2.12.0).

---

## 🛍️ 10. Application Under Test

- **🌐 Site:** [PrestaShop Demo Store](https://demo.prestashop.com/#/en/front)
- **🏬 Domain:** Open-source e-commerce platform demo instance, used here purely as a stable public sandbox for practicing/automating shopping-cart QA flows (signup, login, search, cart, checkout, guest checkout, contact-us, order tracking).

---

## 📝 11. Notes / Known Points

- 🏗️ Two parallel Page Object sets exist (`src/main/java/pages` and `src/test/java/prestapages`) — the latter is an extended set that includes newer page objects for Contact Us, Search and Add to Cart, Multiple Products, and Sort Products alongside earlier variants.
- 📸 Screenshots are captured after **every** Cucumber step (pass or fail) and attached to the Allure/Cucumber report; failed scenarios additionally save a timestamped PNG to `/screenshot`. ExtentReports Spark captures screenshots separately under `test-output/screenshots/`.
- 📝 **Log4j2** is active in `Signuptestng` and `ContactUsDef`; the `log4j2.xml` config file in `src/main/resources` is picked up automatically at runtime. Extend logging to other step-definition classes by declaring `private static final Logger logger = LogManager.getLogger(YourClass.class)`.
- 📂 **Data-driven login** in `Signuptestng` reads from `src/test/java/utils/Book1.xlsx` — the path is loaded from `src/test/java/utils/data.propertites` to avoid hardcoding. Ensure the `excelPath` key points to the correct relative/absolute path for the execution environment.
- ⚠️ `App.java` under `Capstone_project` is the default Maven-archetype placeholder class and is not part of the test flow.
- 🐛 The feature file `serachAndAddtoCart.feature` has a deliberate typo in the filename ("serach" instead of "search") — kept as-is for backward compatibility with runner configurations.
- 🏷️ Scenario tags (`@Registration`, `@ProductSearch`, `@GuestCheckout`, `@prestashop`, `@checkoutFlow`) can be used with `mvn test -Dcucumber.filter.tags="@TagName"` to run a filtered subset of tests.
- 🌐 `Contactustestng` supports **cross-browser** execution (Chrome / Edge) via TestNG `@Parameters` — configure browser and URL in `testngpom/Contactus.xml`.

---

<div align="center">

Made with ☕ Java · 🥒 Cucumber · 🌐 Selenium · 🧪 TestNG · 📝 Log4j2 · 📂 Apache POI

</div>
