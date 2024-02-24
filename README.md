**Module 1 - Reflection**

Reflection 1: Clarity and Security in Implementation

Ensuring clarity and security in implementing edit and delete functionalities was a priority. Readability was enhanced through clear variable and function names, coupled with well-maintained code structure and proper indentation. However, grappling with the MVC concept was challenging due to limited experience, demanding additional effort for comprehension.

Reflection 2: Confidence Post-Test Implementation

Following test implementation, confidence in the program's reliability grew. While no fixed rule dictates the number of tests, it is crucial to cover all scenarios. It's essential to understand that 100% code coverage doesn't guarantee bug-free code; it indicates that each line has been executed at least once. A clean functional test suite aligns with clean code principles, addressing issues such as repetitive code, unclear names, readability, test independence, comprehensive coverage, and effective error handling.

**Module 2 - Code Quality Focus on ProductService Class**

The emphasis on code quality centered on testing and implementing the ProductService class. Specific methods like getProductId() and create() lacked definitions, prompting their inclusion in the ProductService interface and subsequent implementation in the ProductServiceImpl class.

Concerning the implementation workflow, it aligns with CI/CD resolutions. Continuous Integration is maintained through automated tests with each push, ensuring seamless integration. Nevertheless, achieving full Continuous Deployment isn't guaranteed, as manual approvals may be necessary before deploying changes to production.

**Module 3 - SOLID Principles Applied to the Project**

Principles Applied to the Project

Single Responsibility Principle: Responsibilities were segregated in 'ProductController.java' and 'CarController.java,' each handling operations specific to its entity.
Open-Closed Principle: Easy extension in 'Car.java' and 'Product.java' was facilitated for future changes without modifying existing code.
Liskov Substitution Principle: 'ProductServiceImpl' was implemented as a subclass of 'ProductService,' adhering to the interface's method definitions.
Interface Segregation Principle: Interfaces were simplified by removing unnecessary "public" declarations, focusing on essential methods.
Dependency Inversion Principle: Dependency on the 'CarService' interface was established rather than the specific 'CarServiceImpl' class in 'CarController.'
Advantages of Applying SOLID Principles

Enhanced code clarity and maintainability, demonstrated by distinct responsibilities in 'ProductController' and 'CarController.'
Facilitates easy addition of features without altering existing code, as seen in the extensibility of 'Product' and 'Car' classes.
Focused interfaces (CarService and ProductService) streamline code management and expansion.
Disadvantages of Not Applying SOLID Principles

Lack of Single Responsibility may lead to code repetition, complicating error management.
Excessive interdependence between classes can hinder modifications without affecting others.
Code inflexibility and resistance to updates may impede the addition of new features.
Testing challenges may arise from interconnected components, slowing down and compromising reliability.
