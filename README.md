# Movies App
Application that show popular, top ranked and upcoming movies.
Works offline

## Tech 

MVVM
Retrofit
RxJava
RxKotlin
Koin
Glide
Room

## Architecture

Based in the MVVM architecture, I have created four groups of files, Views, Models, ViewModels, Services.
**database** Here there are the classes to manage the database.
**ui:** I placed the activity, fragmentes and adapters in the __ui__ package: 
*MainActivy*, contains a tabview with the 3 categories of movies, where each category is a *MovieFragment*
*MovieFragment*, containt a recyclerview and use the *MovieRecyclerViewAdapter*.
*MovieRecyclerViewAdapter*, shows a short description of a movie in a list.
*MovieDetailActivity*, shows the complete despcription of a movie.

**Models** In this group I hold application data. They’re structs and simple classes, these are abstractions of the real things into the app..
*Movie*, represents the movie element that the view needs.
*MovieDBResponse*, represents the movie element returned by the remote api.
*Category*, represent the category of the movie
*CategoryMovie*, represente the relation between category and movie

**ViewModel**
I added a *XMovieViewModel* class for each fragment, the viewmodel has the responsibility to provide the information to the view, in this case, the popular movie list, the top ranked movie list and the upcoming movie list,  

**Services**
I added *Services* and *MovieDBServices* classes that request the information from moviedbapi.
The *repository* class transform that into a values that can be displayed on the view and store in the database.
Also, when some error happen (example: not connection) It return data from the datababase.

## Single responsability principle
This is the first principle of the **S**OLID principiles. It means that every module or class should have one responsability, and with this we obtain a clearer and more maintainable code.

## Clean code
In general *clean code* is about the use of good practices.
- Give a good names to variables, classes or methods to help to developers to understand the function of each.
- Keep the clases and methods short, the code will be easer to read.
- Some good practices help to improve the performance, and reduce boilerplate code.
