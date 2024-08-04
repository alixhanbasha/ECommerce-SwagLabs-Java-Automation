# Swag Labs E-Commerce Features

### This is a demo app, but for the sake of simplicity we will treat it as a real app

* The _Login_ feature
  * If the user has an account, and uses the correct credentials, the user can log in
  * If the user does not have an account, or uses the incorrect credentials, then he/she cannot log in

* The _Inventory_ feature
  * Once logged in, the user should see a list of products in the Inventory page
  * Each product should have an image, a title, description and price visible.
  * When "Add to cart" is clicked for a product, that product should be added to the users shopping cart
  * If the product title is clicked, then the user should be redirected to the Product page
  * The user can use filters to change how items are displayed
    * A-Z
    * Z-A
    * Price Low-High
    * Price High-Low
  * The header should be visible at all times
    * Contains the navigation menu, and the shopping cart
  * The footer should be visible at all times
    * Contains copyright info, and social links
 
* The _Product Page_
  * Once the user is in the Inventory Page, they can select one of the products for a more detailed view
  * The product should have an image, a title, description and price visible.
    * Also, there should be a button for "Add to cart" visible and functional
  * When "Add to cart" is clicked for the product, it should be added to the users shopping cart
  * The header should be visible at all times
    * Contains the navigation menu, and the shopping cart
    * Contains "Back to products button", which will redirect the user to the previous page (Inventory)
  * The footer should be visible at all times
      * Contains copyright info, and social links

* The _Shopping Cart_ feature
  * Can be accessed from the header, by clicking the shopping cart icon
  * If the user has added a product to the cart, then it should be visible in the "Your Cart" page
  * The "Your Cart" page is accessible at all times, so if the user has not added anything to their cart, the page should have
    * The header
    * The footer
    * "Continue shopping" button
    * NOTE: In a real app, the "Checkout" button would be disabled since there is nothing to do, here however you can continue further
  * The label near the shopping cart icon should act accordingly, by displaying the amount of products in present in the cart
  * Once the user decides they are happy with the products, and they want to proceed, they will see the "Checkout: Your Information" page
    * Contains a form for user details
    * Contains "Cancel" and "Continue" buttons
    * The header and the footer.
    * The form cannot have an empty input field
      * Error messages are displayed accordingly
  * When the form is filled with valid data, and the "Continue" button is clicked
    * User is redirected to "Checkout: Overview" page
      * Contains the header and the footer
      * A list of the item/items that will be bought
      * Payment information
      * Shipping Info
      * Price total
      * Tax
      * "Cancel" and "Finish" button
    * If user clicks cancel, he/she is redirected to the Inventory page, but the item will remain in the cart
    * Otherwise, the user will be redirected to "Checkout: Complete!" page
      * Contains the header, and footer
      * Thank you for your order message
      * Back home button
      * The cart will now be empty
    * Clicking the "Back Home" button redirects the user to the Inventory page
