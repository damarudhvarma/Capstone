Feature: user sorts the fetaured products 
 Scenario: user sorts the products by name A to Z 
 Given user navigates to featured products page
 Then selects a Category
 And sorts by "Name, A to Z"
 Then products are sorted
 
 Scenario: user sorts the products by Price, high to low 
 Given user navigates to featured products page
 Then selects a Category
 And sorts by "Price, high to low"
 Then products are sorted
 
 Scenario: user sorts the products by Price, low to high 
 Given user navigates to featured products page
 Then selects a Category
 And sorts by "Price, low to high"
 Then products are sorted
 
 Scenario: user sorts the products by Sales, highest to lowest 
 Given user navigates to featured products page
 Then selects a Category
 And sorts by "Sales, highest to lowest"
 Then products are sorted