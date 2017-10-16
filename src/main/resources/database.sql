USE test;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(255) NOT NULL,
  author VARCHAR(100) NOT NULL,
  isbn VARCHAR(20) NOT NULL,
  printYear INT NOT NULL ,
  readAlready BOOL NOT NULL
);

INSERT INTO book
(title, description, author, isbn, printYear, readAlready)
VALUES
  ("Effective Java", "Study Java effectively!", "Joshua Bloch", "9788871924816", 2009, false),
  ("Spring in Action 3th (third) edition", "Spring explained", "Craig Walls", "9780935717150", 2011, false),
  ("Big Java", "Java from basics to experts", "Cay S. Horstmann", "9788126508792", 2005, false),
  ("Head First SQL Code Magnet Kit", "SQL from scratch", "Head Team", "9780596154103", 2008, false),
  ("Cathedral and the Bazaar", "Famous book from Eric Raymond", "Eric S. Raymond", "9781607962281", 2010, false),
  ("C Programming Language: ANSI C", "The best book to learn C", "Ritchie Kernighan", "9780131158177", 1990, false),
  ("Patterns of enterprise application architecture", "Mustread from Martin Fowler", "Martin Fowler", "9780321127426", 2002, false),
  ("Refactoring: Improving the Design of Existing Code", "Intro to refactoring", "Martin Fowler", "9780201485677", 1999, false),
  ("Clean Code: A Handbook of Agile Software Craftsmanship", "Famous book from Robert Martin", "Robert C. Martin", "9780132350884", 2008, false),
  ("The Pragmatic Programmer: From Journeyman to Master", "Mustread for any programmer", "Andrew Hunt", "9780201616224", 1999, false),
  ("The Mythical Man-Month: Essays on Software Engineering", "Golden collection of software engineer", "Frederick Phillips Brooks", "9780201006506", 1975, false),
  ("Code Complete: A Practical Handbook of Software Construction, Second Edition", "Know how to build software", "Steve McConnell", "9780735619678", 2004, false),
  ("Design Patterns: Elements of Reusable Object-Oriented Software", "Classic book on patterns", "GoF", "9780201633610", 1994, false),
  ("Introduction to Algorithms, 3rd Edition", "Algorithms completely explained", "Thomas H. Cormen", "9780262033848", 2009, false),
  ("Cracking the Coding Interview: 189 Programming Questions and Solutions ", "Coding interview cracked", "Gayle Laakmann McDowell", "9780984782864", 2015, false),
  ("The Algorithm Design Manual", "Classic book on algorithms", "Steven S Skiena", "9781848000698", 2011, false),
  ("Java 8 in Action: Lambdas, Streams, and functional-style programming", "Gentle intro in the Java 8", "Raoul-Gabriel Urma", "9781617291999", 2014, false),
  ("Java Persistence with Hibernate", "Hibernate explained", "Christian Bauer", "9781617290459", 2015, false),
  ("Building Microservices: Designing Fine-Grained Systems", "Microservices from scratch", "Sam Newman", "9781491950357", 2015, false),
  ("Working Effectively with Legacy Code", "Legacy code support explained", "Michael Feathers", "9780131177055", 2004, false),
  ("Regular Expressions Cookbook: Detailed Solutions in Eight Programming Languages", "Cracking the regexps", "Jan Goyvaerts", "9781449319434", 2012, false);

