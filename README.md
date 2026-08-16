# Book API project

This is a REST API for storing and retrieving books and their authors. This project was made using the following [tutorial](https://www.youtube.com/watch?v=Nv2DERaMx-4&pp=0gcJCfkLAYcqIYzv) and use the 4.1.0 version of the springframework.

Every book contains a isbn which is its personal identifier, it also contains a title and a author. The author has a id, a name and an age.

## REST API

### Books

For retrieving information about books you need the `/books` 
- **PUT** `/books/{isbn}` is used for book creation and full updating when supplying a new author it will automatically insert create that author too
- **GET** `/books` is for retrieving all of the books the api will return a page
- **GET** `/books/{isbn}` for getting one book
- **PATCH** `/books/{isbn}` used for patial updating of the books
- **DELETE** `/books/{isbn}` used for book deletion will return 200 even if the book isn't found

### Authors

For retrieving information about authors you need the `/authors` 
- **PUT** `/authors/{id}` is used for author creation and full updating
- **GET** `/authors` this returns a list of all the authors
- **GET** `/authors/{id}` for getting one author
- **PATCH** `/authors/{id}` used for patial updating of authors
- **DELETE** `/authors/{id}` used for author deletion will return 200 even if the author isn't found
