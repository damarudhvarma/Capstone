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

An end-to-end **UI test automation framework** built for the [PrestaShop demo store](https://demo.prestashop.com/#/en/front). It uses **Selenium WebDriver 🌐 + Cucumber 🥒 (BDD) + TestNG 🧪** with the **Page Object Model (POM)** design pattern to automate and verify core e-commerce user journeys — signup, login, product search, add-to-cart, checkout (registered & guest), order history verification, contact-us form submission, and multi-product cart validation.

</div>

---

## 📋 1. Project Overview

This is a **Capstone automation project** that simulates real-world QA testing of an online shopping site (PrestaShop). It is written in **☕ Java** and managed with **📦 Maven**. Test scenarios are written in **🥒 Gherkin** (plain-English `.feature` files) and mapped to Java step-definition classes, which in turn drive the browser through Page Object classes.

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

📸 **Test reporting & evidence** is captured via **Cucumber HTML reports**, **Allure Reports**, and **automatic screenshots** on every step (extra capture on failure).

---

## 🧰 2. Tech Stack / Frameworks Used

| Category | Technology |
|---|---|
| ☕ Language | **Java 17** |
| 📦 Build Tool | **Maven** |
| 🌐 Browser Automation | **Selenium WebDriver 4.18.0** |
| 🥒 BDD Framework | **Cucumber (cucumber-java, cucumber-testng) 7.15.0** |
| 🧪 Test Runner / Execution | **TestNG 7.9.0** (via `AbstractTestNGCucumberTests`) |
| 🚗 Driver Management | **WebDriverManager 5.6.3** (auto-downloads/matches ChromeDriver) |
| 📊 Reporting | **Allure Reports 2.25.0** (`allure-cucumber7-jvm`, `allure-testng`) + **ExtentReports 5.1.1** (`extentreports-cucumber7-adapter`) + native Cucumber `pretty`/HTML/JSON reports |
| 📝 Logging | **Log4j2 2.23.1** (`log4j-core`, `log4j-api`, `log4j-slf4j2-impl`) |
| 🏗️ Design Pattern | **Page Object Model (POM)** using `@FindBy` PageFactory annotations |
| 🖥️ IDE Config | Eclipse (`.project`, `.classpath`, `.settings`) |
| 🔧 Version Control | Git / GitHub (`damarudhvarma/Capstone`) |

---

## 🗂️ 3. Project File Structure

```
Capstone/
|-- pom.xml                          # Maven project config & all dependencies
|-- .gitignore
|-- .classpath / .project / .settings/   # Eclipse IDE metadata
|-- .mvn/                            # Maven wrapper config (maven.config, jvm.config)
|-- .allure/                         # Local Allure CLI installation
|-- allure-results/                  # Raw Allure result JSON + attachments (generated)
|-- test-output/                     # TestNG output (HTML/XML reports, generated)
|-- screenshot/                      # Screenshots captured on step execution / failures
|-- target/                          # Maven build output (compiled classes, generated reports)
|
+-- src/
    +-- main/
    |   +-- java/
    |       +-- Capstone_project/
    |       |   +-- Capstone_project/
    |       |       +-- App.java             # Default Maven-generated entry point ("Hello World")
    |       |
    |       +-- pages/                       # 🏗️ Core Page Object Model (production POM classes)
    |           +-- BasePage.java                     # Common driver/PageFactory init for all pages
    |           +-- PrestaShopHomePage.java            # Home page navigation, Sign-in link
    |           +-- PrestaShopLoginPage.java           # Login form + navigate to Create Account
    |           +-- PrestaShopRegistrationPage.java    # New user registration form
    |           +-- PrestaShopProductPage.java         # Featured products, search, add to cart, checkout nav
    |           +-- PrestaShopGuestCheckoutPage.java   # Guest personal info, address, shipping, payment
    |
    +-- test/
        +-- java/
            +-- base/
            |   +-- BaseClass.java            # ThreadLocal WebDriver factory (init/get/quit)
            |
            +-- hooks/
            |   +-- Hooks.java                # 🎣 Cucumber @Before/@After hooks: launch browser,
            |                                 # navigate to site, capture screenshots, quit driver
            |
            +-- Features/                     # 🥒 Gherkin BDD feature files (test scenarios)
            |   +-- signup.feature                    # User registration (outline + empty-field validation)
            |   +-- user_login.feature                # Registration, login loop, search+checkout, guest checkout
            |   +-- FeaturedProduct.feature            # Featured product purchase flow
            |   +-- Booking.feature                    # Full purchase (outline) + order-history verification
            |   +-- ContactUs.feature                  # Contact Us form submission
            |   +-- serachAndAddtoCart.feature         # Search and add a product to cart
            |   +-- addMultipleProducts.feature        # Add multiple products to cart
            |
            +-- StepDef/                      # 🔗 Step definition classes (Gherkin to Java glue code)
            |   +-- SignupDef.java
            |   +-- PrestaShopLoginSteps.java
            |   +-- ShoppingStepDef.java
            |   +-- Featuredprodsteps.java
            |   +-- ContactUsDef.java
            |   +-- SearchAndAddToCartDef.java
            |   +-- MultipleProductsToCart.java
            |
            +-- Runner/                       # 🏃 TestNG/Cucumber test runners (entry points to execute tests)
            |   +-- TestRunner.java                    # Runs user_login.feature (all 4 scenarios)
            |   +-- SignupRunner.java                   # Runs signup.feature
            |   +-- ShoppingRunner.java                 # Runs Booking.feature
            |   +-- Featuredprodrunner.java             # Runs FeaturedProduct.feature
            |   +-- ContactUsRunner.java                # Runs ContactUs.feature
            |   +-- SearchAndAddToCartRunner.java       # Runs serachAndAddtoCart.feature
            |   +-- MultipleProductsRunner.java         # Runs addMultipleProducts.feature
            |
            +-- prestapages/                  # Additional / alternate Page Object classes used by
                |                             # some step definitions and older/experimental flows
                +-- AuthPOM.java                         # Signup + Login page objects
                +-- FeaturedProductsPOM.java              # Featured products browsing & cart page object
                +-- CheckoutPage.java                      # Checkout + address page object
                +-- checkoutandshipping.java               # Checkout & shipping page object (variant)
                +-- orderinfo.java                         # My Orders / order details page object
                +-- prestaloginandsignup1.java              # Combined login+signup page object (variant)
                +-- prestarunpages1.java                    # Supplementary page object helper
                +-- ContactUs.java                         # Contact Us page object
                +-- SearchAndAddToCart.java                # Search and add-to-cart page object
                +-- MultipleProductsAdding.java             # Multiple product cart page object
                +-- SortProducts.java                      # Product sort/filter page object
                +-- TestSignup.java                        # Standalone signup test class
                +-- TestFeaturedProducts.java              # Standalone featured-products test class
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

## 🏃 6. Runner to Feature File Mapping

| Runner Class | Feature File | Scenarios Covered |
|---|---|---|
| `TestRunner.java` | `user_login.feature` | PS01, PS02, PS03, PS04 |
| `SignupRunner.java` | `signup.feature` | SUP-01, SUP-02 |
| `ShoppingRunner.java` | `Booking.feature` | BK-01, BK-02 |
| `Featuredprodrunner.java` | `FeaturedProduct.feature` | FP-01 |
| `ContactUsRunner.java` | `ContactUs.feature` | CU-01 |
| `SearchAndAddToCartRunner.java` | `serachAndAddtoCart.feature` | SAC-01 |
| `MultipleProductsRunner.java` | `addMultipleProducts.feature` | AMP-01 |

---

## ⚙️ 7. Test Execution Flow

1. 🌐 **`Hooks.launchBrowser()`** (`@Before`) initializes a `ChromeDriver` via `WebDriverManager` (through `BaseClass`, using a `ThreadLocal<WebDriver>` for thread-safety) and opens `https://demo.prestashop.com/#/en/front`.
2. 🥒 Cucumber matches Gherkin steps in the `.feature` files to methods in the **StepDef** classes.
3. 🏗️ StepDef classes call methods on the **Page Object** classes (`pages/*` or `prestapages/*`), which use Selenium locators (`@FindBy`) to interact with the UI.
4. 📸 **`Hooks.captureScreenshotAfterEveryStep()`** (`@AfterStep`) attaches a screenshot to the Cucumber/Allure report after every step; on scenario failure, an additional screenshot is saved to `/screenshot`.
5. 🔚 **`Hooks.closeBrowser()`** (`@After`) quits the driver and clears the `ThreadLocal`.
6. 🏃 Each **Runner** class (`Runner/*.java`) extends `AbstractTestNGCucumberTests` and points to a specific `.feature` file via `@CucumberOptions`, generating `pretty`, HTML, JSON, and Allure output.

---

## ▶️ 8. How to Run the Tests

**Prerequisites:** ☕ Java 17, 📦 Maven, 🌐 Google Chrome installed.

```bash
# Run all tests (TestNG + Cucumber via Maven Surefire)
mvn clean test

# Run a specific runner class only
mvn test -Dtest=Runner.TestRunner
mvn test -Dtest=Runner.SignupRunner
mvn test -Dtest=Runner.ShoppingRunner
mvn test -Dtest=Runner.Featuredprodrunner
mvn test -Dtest=Runner.ContactUsRunner
mvn test -Dtest=Runner.SearchAndAddToCartRunner
mvn test -Dtest=Runner.MultipleProductsRunner
```

**📊 View reports:**
```bash
# Cucumber HTML reports (generated under /target)
open target/cucumber-reports/cucumber-html-report.html

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
| `org.apache.logging.log4j:log4j-core` / `log4j-api` / `log4j-slf4j2-impl` | 2.23.1 | 📝 Logging |

**Build plugins:** `maven-compiler-plugin`, `maven-surefire-plugin`, `maven-clean-plugin`, `maven-resources-plugin`, `maven-jar-plugin`, `allure-maven` (2.12.0).

---

## 🛍️ 10. Application Under Test

- **🌐 Site:** [PrestaShop Demo Store](https://demo.prestashop.com/#/en/front)
- **🏬 Domain:** Open-source e-commerce platform demo instance, used here purely as a stable public sandbox for practicing/automating shopping-cart QA flows (signup, login, search, cart, checkout, guest checkout, contact-us, order tracking).

---

## 📝 11. Notes / Known Points

- 🏗️ Two parallel Page Object sets exist (`src/main/java/pages` and `src/test/java/prestapages`) — the latter is an extended set that includes newer page objects for Contact Us, Search and Add to Cart, Multiple Products, and Sort Products alongside earlier variants.
- 📸 Screenshots are captured after **every** Cucumber step (pass or fail) and attached to the Allure/Cucumber report; failed scenarios additionally save a timestamped PNG to `/screenshot`.
- ⚠️ `App.java` under `Capstone_project` is the default Maven-archetype placeholder class and is not part of the test flow.
- 🐛 The feature file `serachAndAddtoCart.feature` has a deliberate typo in the filename ("serach" instead of "search") — kept as-is for backward compatibility with runner configurations.
- 🏷️ Scenario tags (`@Registration`, `@ProductSearch`, `@GuestCheckout`, `@prestashop`, `@checkoutFlow`) can be used with `mvn test -Dcucumber.filter.tags="@TagName"` to run a filtered subset of tests.

---

<div align="center">

Made with ☕ Java · 🥒 Cucumber · 🌐 Selenium · 🧪 TestNG

</div>
