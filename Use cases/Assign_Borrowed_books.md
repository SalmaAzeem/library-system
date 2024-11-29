## Assign Borrowed books use case
## ID
**UC-002**
## Name
**Log in**
## Actors
**Librarian, User, Library System**
## Precondition
**Librarian must be logged in, User must exist, Borrowed book ID is valid**
## Main flow
1. Librarian enters User’s ID to the system
2. Librarian gets the ID of the borrowed book
3. Librarian validates the IDs
4. Librarian assigns the ID to the User
5. Librarian determines a valid due date for the book
6. Librarian finishes process by clicking “Confirm”
7. Library system sends a confirmation message
## Alternative flow
3. Either one of the IDs is not valid
4. System displays an Error message
## Postcondition
**Book is assigned to the User**





