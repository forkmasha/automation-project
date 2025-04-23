Feature: Add Products to Cart

  Background:
    Given open the main page

  Scenario: Add and remove product in cart
    When click on the products button
    * hover over the first product
    * click on the add to cart button
    * click on the continue shopping button
    * click on the cart button
    * verify that the product "Blue Top" is in the cart
    * click on the remove button for the product "Blue Top"
    * verify that the cart is empty
