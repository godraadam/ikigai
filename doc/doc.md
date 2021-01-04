# Introduction

## ikigai

> _(生き甲斐)_  
> _[ikiɡai]_  
> _japanese for a reason to live_

...travelling is ours  
\~ the creators: **i.k.**- creative owner, **g.a.**- the developer

**a scratch-map mobile app made for a university project**

- scratch the countries you visited
- share your thoughts about the places you've seen
- read fellow travellers' notes
- visit the whole world!

## Definition

This application is meant to connect travel-minded people from around the world. Users can share and recommend their travel experiences, as well as keep track of their own travels via a scratch-map like interface.

## Approach

- The system is based on the **client-server architecture**
- The system will be composed of the following components: a responsive web-client, a mobile client for android devices and a server to provide the underlying API allowing communication between the two different clients.
- The backend server will be implemented as a **Java Spring application** following an enterprise architecture comprising a data access layer, a service layer as well as an API layer. For data access a **MySql** database is used, while the API falls into the **RESTful** category. All of this is made possible by the Spring framework.
- Similarly, the android application will be provided with its own local database, in order to allow the user to view his recorded data without internet connection. For this an **ORMLite** implementation is used, and for communication with the server the **Retrofit API** is used.
- The web client utilizes simple `html`, `css` and `JavaScript` code

## Specification

- Upon first entry, the user is greeted with a login/register form. Once registration is successful the user is redirected to the **main page**

### The main page

- The main page is made up of a **large map** of the world.
- There is a button for social interactions such as viewing other people's maps or adding a user as a 'friend'
- There is a button for user settings

* #### The map

- The map is interactive, meaning that each country can be clicked on individually and the map can be zoomed in and out of as well as moved around.
- In case a country is clicked a dialog window is shown prompting the user whether they would like to mark the given country as visited
- An optional 'commentary' field is also provided when marking a country as visited
- Once a country has been visited, it will be colored differently than the unvisited ones

### Social interactions

- When the **social interactions** button is clicked the application navigates to a new page which contains a search field allowing the user for other users by their username.
- If the searched user is found, the user can add them as a **friend** so that next time they no longer have to search for them but simply see them in their list of friends
- The user can also view the searched user's/friend's map displaying his or her visited countries instead of the user's

### Settings

- When the **settings** button is clicked the application navigates to a new page which involves multiple options for the user to customize the application
- These options involve:

1. **Color theme**: look and feel of the application
2. **Public/private profile**: if the user does not desire other users to see their visits, they can turn their profile private
3. **Logout/login as other user**

# Analysis

<div style="text-align:center">
<img src = "./ucd.png">
Communication with the server is carried out via JSON represented objects
</div>

## The domain layer

> The domain layer (model layer) will contain POJOs representing entities participating in the application. They are as follows:

- **User**: Represents the user using the application. Identified by: `id` (a unique identifier used by the relational database) `username`, `email`. Will contain a `list` of **Visit**s (see below)
- **Visit**: Represents a many-to-many relationship between users and visited countries. That is, a user can visit multiple countries and one country could be visited by multiple users. Associated data members are: `date` and a remark which contains a short description of the visit. Countries themselves are represented as `String` as no additional data is associated to them.

## API layer

> Involves identifying the satisfactory and necessary API endpoints to efficiently communicate with the server. Possible use cases:

- register/login/change password for a **User**
- CRUD operations for **Visit**s on the server
- find a user by username, get their **Visit**s

> From which we identify the following endpoints:

- `POST`: `/api/user/register` --register
- `GET`: `/api/user/login` --login
- `PUT`: `/api/user/{id}` --change password
- `POST`: `/api/user/visit/{name}` -- create visit
- `GET`: `/api/visit/{name}` --get all visits of a user
- `GET`: `/api/user/name/{name}` --find user by name

## Data access layer

>  The server will persist registered users, and their visited countries. The database will have the following tables:

- `users` : with the following fields:
    - `id`: a unique identifier
    - `username`: display name on the platform
    - `email`: for contacting the user when needed (e.g. forgotten password)
    - `password`: for authetification purposes. Needless to say it is crucial the password is properly hashed.
    - a `list` of `visits` representing a many-to-many relatiosnhip between the users and the countries they visited

- `visits`: with fields:
  - `id`: integer (a unique identifer)
  - `country`: string (name of the country)
  - `date`: date of visit
  - `description`: string (short description of said visit)
  - `user`: string (name of user)

# Design

## Application layering

> **horizontal slice architecture**: classes are organized by responsibilty rather than by concern

<p style="text-align: center">
<code>Presentation Layer</code><br>
<code>Service Layer</code><br>
<code>Domain layer</code><br>
<code>Data Acces Layer</code>
<br>/  \<br>
<code>Repo layer | API layer</code>
</p>

## Data structures, algorithms, design patterns

### Data structures


### Design patterns

- **Service**:
  - `Dependency injection`: services are single responsibilty classes 'injected' into other classes that require said services
  - `Factory`: the service initialization is delegated to an appropriate factory class => looser coupling
- **UI**:
  - event handling utilizes the `Observer` design pattern
  - `Composition` for complex design elements
- **Data access**:
  - `Singleton` pattern used for database connection; guarantees a single connection instance to the database thorughout the entire application.
  - `DAO pattern` for data acces/querying
  - `DTO pattern` used for data transfer between the server and client: reduce the size of data passed between the server and client to increase throughput, by only storing the bare minimum amount of data in the transfer objects.
  - `Proxy` for lazy loading from/to local database: store data loaded from disk in program memory to avoid hardware access overhead.

  # Implementation

  ## Domain Layer

  > Consits of POJOs representing the entities participant in the application: users, formalized in the `User` class and visits, formalized in the `Visit` class. They together form a many-to-many relationship, with the 'owner' side being a user since visited countries belong to a user, while users don't belong to any country. Both of these classes will inherit from a base class named `BaseModel`, containing a single attribute called `id` which is of type Long and will serve as a unique identifier as well as primary key used by the database for both the `users` and `visits` tables. Finally these classes are placed in the model `ikigai.server.model` package
<div style="text-align:center">
<img src = "./cd4.png">
</div>

## Repository Layer

>The bulk of data access boiler plate code is handled automagically by Spring framework's data JPA library. Persisted entities and their columns are marked by annotations and data acces code is generated from it, in the background. For the database implementation, `MySql80` is used for its tested performance and reliability, though something more lightweight such as `MongoDB` could do the job just as well. As far as implementation goes, we simply extend the generic `CrudRepository<M, ID>` interface provided by Spring with the corresponding interfaces, that being `UserRepository<User, Long>` and `VisitRepository<Visit, Long>` add any specific query methods(if needed) and then the rest of the implementation is automatically generated upon the start of the application.

<div style="text-align:center">
<img src = "./repo.svg">
</div>




