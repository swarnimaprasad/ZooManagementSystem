# ZooManagementSystem
##Application Flow:

The application will have a user-friendly command-line interface where you can enter as either an admin or a visitor.

Visitors can enjoy different levels of zoo experiences: "Basic," "Premium,". These levels offer varying perks and access to different areas of the zoo.

Admins can manage the zoo's attractions, animals, and visitor information. They can also add special events and discounts.

##Admin Functionalities:

Enter as Admin: Admins must provide their username and password to access all admin privileges. Make use of a constant for username and password with fixed values to be compared against.

Manage Attractions/Events: Admins can view, add, modify, or remove attractions in the zoo. Each attraction should have a unique ID. Attractions can be any cultural exhibit, such as a safari experience, a botanical garden, a dinosaur show, etc. The attractions are free of cost for the premium members. However, the basic members have to buy a ticket for a fixed price for each attraction.   

Schedule Events: Admins can select when the attractions are open or closed and also select the price of entry ticket necessary for the attractions. The attraction should also maintain the count of ticketed visitors.

Manage Animals: Admins can add animals to specific attractions. They can also update animal details and remove animals when necessary. Animals can be of 3 types - Mammals, Amphibians and Reptiles. Note that there must be at least 2 kinds of animals for each type. For e.g., elephants and monkeys could be the 2 kinds of mammals required. When adding any new animal to the zoo, the animal should belong to one of these 3 categories only.

Set Discounts: Admins can set discount codes on ticket prices for different visitor categories and attractions, such as minors or seniors.
Every minor visitor to the zoo (<18) should get a 10% discount on their tickets and membership amount.
Every senior citizen (>60) should get a 20% discount on their tickets and membership amount
Admin should be able to add or remove any of these discounts as required.

Set Special Deals: The zoo may offer special deals where visitors can enjoy discounts on combined attractions. Admins can set these deals, and they are applied automatically for the the visitors buying the tickets.
If a person buys more than 2 attractions, they get a special discount of 15% on the total amount
If a person buys more than 3 attractions, they get a special discount of 30% on the total amount
Admin should be able to add or remove any of these deals as required.

View Visitor Stats: Admins can access statistics on the number of visitors, revenue, and popular attractions.

View Feedback: Admins should also be able to see the feedback left by the visitors.


##Visitor Functionalities:

Register: Visitors can register by providing their name, age, phone number, balance, email, and password.

Log In: Registered visitors can log in using their email and password to access their account.

Explore the Zoo: Visitors can browse through different attractions and learn about the animals.

Buy Membership:  Visitors can purchase tickets based on their chosen experience level (Basic, Premium).

Buy Tickets: Only basic users can buy tickets for each attraction they want to visit. They can buy tickets for as many attractions as they want and also get special deals. The ticket is a one-time usage ticket and will be invalid after a visit to the attraction.

View Discounts: During the purchase of tickets, visitors can see all the discounts available and select the appropriate discount code. 

Apply Discounts: Visitors can apply any available discount (using the discount codes) to their ticket purchase if they satisfy the eligibility criteria.

Visit Animal: The visitor will choose to visit an animal, this functionality will, in turn, ask the visitor to either choose to feed the animal or read about the animal. Choosing to feed the animal will result in the animal making a noise, for example, if you choose to feed a lion it will “Roar”, reading about the animal will return a brief passage about the animal’s history.

Visit Attractions/Visit Event: Visitors can access attractions based on their experience level and the ticket bought to enjoy unique experiences. A simple “Welcome to the attraction X” statement is enough to be counted as a visit to the attraction. 

Provide Feedback: Visitors can leave feedback about their zoo experience and suggest improvements.


