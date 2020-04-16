# Answers.md

- What is the complexity of each of the four search methods in terms of array or list size n?

The complexity of findTeamPosition, for both Arrays & Lists it is O(n), while the complexities for findMinFundingFast is O(log n) due to binary search being in use. The complexity of findMinFunding is also O(n).

- What happens in the case of binary search if the array is not sorted?

The search can still happen, yet the returning value could be unexpected since they are not yet sorted.

- What is the purpose of constructor argument validity checking?

To prevent the construction of an object that violates class invariants.

- What is the purpose of using the keyword `final` with variables and arguments?

'Final' is used to stop the changing of a value, any method overriding, and inheritance.

- What are alternatives to using `Optional` and how do they compare?

Alternatives to using 'Optional' would be checking if arguments or method calls were void (null) or not before going on to call another method. The Optional class allows for cleaner formatting in code, also it allows the program to run smoothly even if there is a null pointer exception thrown.
We are able to see what is specifically null this way.
