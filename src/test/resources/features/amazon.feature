Feature: Amazon test

  @amazon
  Scenario: Verify About this item section
    When select hamburger menu
    And select "TV, Appliances, Electronics" from "shop by department" present in left section
    And select "Televisions" from "tv, audio & cameras" present in left section
    When select tv brand "Samsung" on electronics home page
    And click on sort by option
    And select option "Price: High to Low" from sort by dropdown
    And click on second highest price option showing on the page
    Then verify that the "About this item" text is present for the product
