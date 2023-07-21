Resource Manager application

You need to write an application that allows users to manage their resources.
(a resource can be e.g. a map, study, file - generally some creation containing data on the resource
specific type).

Technologies/tools:

● Java 8+

● SpringBoot

● MySql

● Lombok (at your discretion - if you want to practice getters/setters constructors later
you can convert the whole thing to lombok)

Requirements:

The application should contain representations of user and resource. Both user and resource need
save to postgres database. 
One user can own several resources. Useful information can be found under: 

spring data configuration, Spring Data JPA, @OneToMany, Spring Data Id Generation

The user should include the following information:

● id

● nickname

● name

● last name

● creation date

● modification date

● user type: DEFAULT, SUPER_USER


The resource should contain information:

● id

● name

● creation date

● modification date

● owner (user) id

● type: MAP, RESEARCH, FILE

● metadata saved as JSON

REST api should be made available to perform the following operations:
- adding a user
- deleting a user
- editing the user's nickname
- adding a resource (must be assigned to a specific user)
- deleting a resource
- editing resource name and metadata (JSON)
