Feature: Shopping Cart
  As a Blazedemo user
  I want to add products
  to be able to buy

  Scenario: Add product to the Shopping Cart
    Given the user is on the main page
    When he add a product to the the shopping cart "Nokia Lumia 1520"
    Then he should see the product "Nokia lumia 1520"
  @PLAY
  Scenario: Add multiple products to the shopping cart
    Given the user is on the main page
    When he add multiple products to the cart "Sony Xperia Z5" and "Nokia Lumia 1520"
    And complete the purchase form
    Then he can see your successful order

  Scenario: Shopping cart empty
    Given the user is on the main page
    When he navigate to the shopping cart with no products
    Then he can see that the cart is empty

  Scenario: Remove product from the Shopping Cart
    Given the user is on the main page
    And he add a product to the the shopping cart "Nokia Lumia 1520"
    When he remove a product from the cart
    Then he can see that the cart is empty

  Scenario: Validate total price in the Shopping Cart
    Given the user is on the main page
    And he add multiple products to the cart "Galaxy S7" and "Google Nexus 6"
    When he navigate to the shopping cart
    Then he should see the total "1450"
