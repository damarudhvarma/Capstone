# Capstone Project — PrestaShop Test Automation Framework

An end-to-end **UI test automation framework** built for the [PrestaShop demo store](https://demo.prestashop.com/#/en/front). It uses **Selenium WebDriver + Cucumber (BDD) + TestNG** with the **Page Object Model (POM)** design pattern to automate and verify core e‑commerce user journeys — signup, login, product search, add-to-cart, checkout (registered & guest), and order history verification.

---

## 1. Project Overview

This is a **Capstone automation project** that simulates real-world QA testing of an online shopping site (PrestaShop). It is written in **Java** and managed with **Maven**. Test scenarios are written in **Gherkin** (plain-English `.feature` files) and mapped to Java step-definition classes, which in turn drive the browser through Page Object classes.

**What is being automated / tested:**
| Flow | Description |
|---|---|
| **User Signup** | New user registration with first name, last name, email, password, and consent checkboxes |
| **User Login** | Login with a registered email/password, including a login loop with valid credentials |
| **Product Search & Cart** | Search a product (e.g. "tshirt"), select it, and add it to the cart |
| **Featured Product Checkout** | Browse "All Featured Products", customize a product (color/quantity), add to cart, checkout |
| **Guest Checkout** | Complete a full checkout as a guest — personal info, address, shipping method, payment method |
| **Registered Checkout / Booking** | Signup → search → add to cart → enter shipping address → select payment (COD) → place order |
| **Order History Verification** | Navigate to "My Orders", open order details, and validate order status/date/product/quantity/price |

**Test reporting & evidence** is captured via **Cucumber HTML reports**, **Allure Reports**, and **automatic screenshots** on every step (extra capture on failure).

---

## 2. Tech Stack / Frameworks Used

| Category | Technology |
|---|---|
| Language | **Java 17** |
| Build Tool | **Maven** |
| Browser Automation | **Selenium WebDriver 4.18.0** |
| BDD Framework | **Cucumber (cucumber-java, cucumber-testng) 7.15.0** |
| Test Runner / Execution | **TestNG 7.9.0** (via `AbstractTestNGCucumberTests`) |
| Driver Management | **WebDriverManager 5.6.3** (auto-downloads/matches ChromeDriver) |
| Reporting | **Allure Reports 2.25.0** (`allure-cucumber7-jvm`, `allure-testng`) + **ExtentReports 5.1.1** (`extentreports-cucumber7-adapter`) + native Cucumber `pretty`/HTML/JSON reports |
| Logging | **Log4j2 2.23.1** (`log4j-core`, `log4j-api`, `log4j-slf4j2-impl`) |
| Design Pattern | **Page Object Model (POM)** using `@FindBy` PageFactory annotations |
| IDE Config | Eclipse (`.project`, `.classpath`, `.settings`) |
| Version Control | Git / GitHub (`damarudhvarma/Capstone`) |

---

## 3. Project File Structure

```
Capstone/
├── pom.xml                          # Maven project config & all dependencies
├── .gitignore
├── .classpath / .project / .settings/   # Eclipse IDE metadata
├── .mvn/                            # Maven wrapper config (maven.config, jvm.config)
├── .allure/                         # Local Allure CLI installation
├── allure-results/                  # Raw Allure result JSON + attachments (generated)
├── test-output/                     # TestNG output (HTML/XML reports, generated)
├── screenshot/                      # Screenshots captured on step execution / failures
├── target/                          # Maven build output (compiled classes, generated reports)
│
└── src/
    ├── main/
    │   └── java/
    │       ├── Capstone_project/
    │       │   └── Capstone_project/
    │       │       └── App.java             # Default Maven-generated entry point ("Hello World")
    │       │
    │       └── pages/                       # ★ Core Page Object Model (production POM classes)
    │           ├── BasePage.java                     # Common driver/PageFactory init for all pages
    │           ├── PrestaShopHomePage.java            # Home page navigation, Sign-in link
    │           ├── PrestaShopLoginPage.java           # Login form + navigate to Create Account
    │           ├── PrestaShopRegistrationPage.java     # New user registration form
    │           ├── PrestaShopProductPage.java          # Featured products, search, add to cart, checkout nav
    │           └── PrestaShopGuestCheckoutPage.java    # Guest personal info, address, shipping, payment
    │
    └── test/
        └── java/
            ├── base/
            │   └── BaseClass.java            # ThreadLocal WebDriver factory (init/get/quit)
            │
            ├── hooks/
            │   └── Hooks.java                 # Cucumber @Before/@After hooks — launch browser,
            │                                  # navigate to site, capture screenshots, quit driver
            │
            ├── Features/                      # ★ Gherkin BDD feature files (test scenarios)
            │   ├── signup.feature                     # User registration scenario outline
            │   ├── user_login.feature                 # Registration, login, search+checkout, guest checkout
            │   ├── FeaturedProduct.feature             # Featured product purchase flow
            │   └── Booking.feature                     # Full purchase + order verification flow
            │
            ├── StepDef/                        # Step definition classes (Gherkin ↔ Java glue code)
            │   ├── SignupDef.java
            │   ├── PrestaShopLoginSteps.java
            │   ├── ShoppingStepDef.java
            │   └── Featuredprodsteps.java
            │
            ├── Runner/                         # ★ TestNG/Cucumber test runners (entry points to execute tests)
            │   ├── TestRunner.java                     # Runs user_login.feature (all 4 scenarios)
            │   ├── SignupRunner.java                    # Runs signup.feature
            │   ├── ShoppingRunner.java                   # Runs Booking.feature
            │   └── Featuredprodrunner.java               # Runs FeaturedProduct.feature
            │
            └── prestapages/                    # Additional / alternate Page Object classes used by
                │                                # some step definitions and older/experimental flows
                ├── AuthPOM.java                          # Signup + Login page objects
                ├── FeaturedProductsPOM.java               # Featured products browsing & cart page object
                ├── CheckoutPage.java                       # Checkout + address page object
                ├── checkoutandshipping.java                # Checkout & shipping page object (variant)
                ├── orderinfo.java                          # My Orders / order details page object
                ├── prestaloginandsignup1.java               # Combined login+signup page object (variant)
                ├── prestarunpages1.java                     # Supplementary page object helper
                ├── TestSignup.java                          # Standalone signup test class
                └── TestFeaturedProducts.java                 # Standalone featured-products test class
```

---

## 4. Page Object Models (POM)

The framework maintains **two POM sets**: a clean production set under `src/main/java/pages`, and an expanded/experimental set under `src/test/java/prestapages` used by some step definitions.

### `src/main/java/pages` (primary POM)
- **`BasePage`** — base class every page extends; initializes `WebDriver` and `PageFactory`.
- **`PrestaShopHomePage`** — home page load, "Sign in" link click.
- **`PrestaShopLoginPage`** — enter login credentials, navigate to "Create your account".
- **`PrestaShopRegistrationPage`** — fills and submits the new-account registration form, verifies success.
- **`PrestaShopProductPage`** — "All Featured Products" navigation, product search, product selection, add-to-cart, proceed-to-checkout, personal-information page verification.
- **`PrestaShopGuestCheckoutPage`** — guest personal information, address entry, shipping method selection, payment method selection, and order placement verification.

### `src/test/java/prestapages` (extended POM used in additional scenarios)
- **`AuthPOM`** — signup + login locators/actions (sign-in link, gender, name, email, password, GDPR checkboxes, sign out, user menu).
- **`FeaturedProductsPOM`** — featured products listing, category filter, sort dropdown, product color/quantity, add-to-cart, continue shopping, cart, checkout.
- **`CheckoutPage` / `checkoutandshipping`** — checkout page, product tile, add-to-cart, proceed-to-checkout, new address form (first/last name, email, address, state, postcode, city, country, GDPR).
- **`orderinfo`** — "My Orders" navigation, order details, order status/date, product name/quantity/total price.
- **`prestaloginandsignup1` / `prestarunpages1`** — variant/combined login-signup page objects and helper runner-style page class.

---

## 5. Feature Files (BDD Scenarios)

| Feature File | Scenarios |
|---|---|
| `signup.feature` | Data-driven user signup with multiple example sets (name, email, password) |
| `user_login.feature` | Registration via email, login with valid credentials, product search → checkout, full guest checkout |
| `FeaturedProduct.feature` | Login → browse featured products → customize → add to cart → checkout → shipping |
| `Booking.feature` | Signup → search → add to cart → checkout → shipping address → payment (COD) → order confirmation, plus order-history verification |

---

## 6. Test Execution Flow

1. **`Hooks.launchBrowser()`** (`@Before`) initializes a `ChromeDriver` via `WebDriverManager` (through `BaseClass`, using a `ThreadLocal<WebDriver>` for thread-safety) and opens `https://demo.prestashop.com/#/en/front`.
2. Cucumber matches Gherkin steps in the `.feature` files to methods in the **StepDef** classes.
3. StepDef classes call methods on the **Page Object** classes (`pages/*` or `prestapages/*`), which use Selenium locators (`@FindBy`) to interact with the UI.
4. **`Hooks.captureScreenshotAfterEveryStep()`** (`@AfterStep`) attaches a screenshot to the Cucumber/Allure report after every step; on scenario failure, an additional screenshot is saved to `/screenshot`.
5. **`Hooks.closeBrowser()`** (`@After`) quits the driver and clears the `ThreadLocal`.
6. Each **Runner** class (`Runner/*.java`) extends `AbstractTestNGCucumberTests` and points to a specific `.feature` file via `@CucumberOptions`, generating `pretty`, HTML, JSON, and Allure output.

---

## 7. How to Run the Tests

**Prerequisites:** Java 17, Maven, Google Chrome installed.

```bash
# Run all tests (TestNG + Cucumber via Maven Surefire)
mvn clean test

# Run a specific runner class only
mvn test -Dtest=Runner.TestRunner
mvn test -Dtest=Runner.SignupRunner
mvn test -Dtest=Runner.ShoppingRunner
mvn test -Dtest=Runner.Featuredprodrunner
```

**View reports:**
```bash
# Cucumber HTML reports (generated under /target)
open target/cucumber-reports/cucumber-html-report.html

# Allure report (uses results in /allure-results)
mvn allure:report
mvn allure:serve
```

TestNG's own results are written to `/test-output` (`emailable-report.html`, `index.html`).

---

## 8. Key Dependencies (from `pom.xml`)

| Dependency | Version | Purpose |
|---|---|---|
| `org.seleniumhq.selenium:selenium-java` | 4.18.0 | Browser automation |
| `io.cucumber:cucumber-java` | 7.15.0 | Gherkin step definitions |
| `io.cucumber:cucumber-testng` | 7.15.0 | Bridges Cucumber with TestNG runner |
| `org.testng:testng` | 7.9.0 | Test execution engine |
| `io.github.bonigarcia:webdrivermanager` | 5.6.3 | Automatic browser driver binary management |
| `tech.grasshopper:extentreports-cucumber7-adapter` | 1.14.0 | ExtentReports adapter for Cucumber |
| `com.aventstack:extentreports` | 5.1.1 | Rich HTML test reporting |
| `io.qameta.allure:allure-cucumber7-jvm` | 2.25.0 | Allure reporting for Cucumber |
| `io.qameta.allure:allure-testng` | 2.25.0 | Allure reporting for TestNG |
| `org.apache.logging.log4j:log4j-core` / `log4j-api` / `log4j-slf4j2-impl` | 2.23.1 | Logging |

Build plugins: `maven-compiler-plugin`, `maven-surefire-plugin`, `maven-clean-plugin`, `maven-resources-plugin`, `maven-jar-plugin`, `allure-maven` (2.12.0).

---

## 9. Application Under Test

- **Site:** [PrestaShop Demo Store](https://demo.prestashop.com/#/en/front)
- **Domain:** Open-source e-commerce platform demo instance, used here purely as a stable public sandbox for practicing/automating shopping-cart QA flows (signup, login, search, cart, checkout, guest checkout, order tracking).

---

## 10. Notes / Known Points

- Two parallel Page Object sets exist (`src/main/java/pages` and `src/test/java/prestapages`) — the latter appears to be an earlier/experimental iteration retained alongside the cleaner production POM.
- Screenshots are captured after **every** Cucumber step (pass or fail) and attached to the Allure/Cucumber report; failed scenarios additionally save a timestamped PNG to `/screenshot`.
- `App.java` under `Capstone_project` is the default Maven-archetype placeholder class and is not part of the test flow.