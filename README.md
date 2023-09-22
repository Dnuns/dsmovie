# DsMovie

This is a full stack project developed @ "Semana Spring React" promoted by Devsuperior. It is a movie evaluator and catalogue.
## Tech Stack

**Client:** React, Bootstrap, TypeScript, Axios

**Server:** Java 17, Spring, Postegres

## Link
https://davidsmovie.netlify.app

## API Reference

#### Get movies

```http
  GET http://david-dsmovie.herokuapp.com/movies
```

#### Get movie by id

```http
  GET http://david-dsmovie.herokuapp.com/movies/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

## Available Scripts

### Frontend

In the frontend project directory, after downloading the project, you can run:

```sh
yarn install - to install all the project dependencies
yarn start - to start the app
```

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

### Backend

In the backend project directory, after downloading the project, you can run:

```sh
./mvnw spring-boot:run or mvnw spring-boot:run - to start the app
```

Runs the app in the development mode.\
Open [http://localhost:8080](http://localhost:8080) to view it in your browser.


## Preview

![](project-img.jpg)

## Author

- [David Nunes](https://www.github.com/Dnuns)
