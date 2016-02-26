# mocking-example

A quick-n-dirty example of Mockito using ```@Mock``` to automatically
inject dependencies and ```@InjectMocks``` to fill in the class
under test automatically. 

Mockito docs at http://mockito.org/

### Details

There's CoolService, which calls java.util.Random to get a random number. 
And then there's CoolServiceTest which injects a mock for 
java.util.Random so you can return whatever specific number you want, 
to make CoolService actually testable.

Note that in this case I declared CoolService.random as package-local 
so I could override it, you could do the same thing with constructor 
dependencies or with get/set methods if you wanted to. 
Lots of ways to skin these cats.
