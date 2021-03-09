# API to play Rock - Paper - Scissors - Lizard - Spock

![alt text](https://upload.wikimedia.org/wikipedia/en/c/cc/Rock_paper_scissors_lizard_spock.png)
## Instructions
### Configuration:
1. Clone the repository.
2. Open the *application.properties* file from `/src/main/resources/application.properties`. 
3. Add the name of your database here (add username and password, if necessary). `spring.datasource.url=jdbc:postgresql://localhost:5432/{yourDatabaseName}`.
4. Run and Play it using any API client (e.g., [Postman](https://www.postman.com/ "Postman")).
5. Enjoy! 

### Game Play:

1. Player sends API a move to play using `POST` request to the [http://localhost:8080/rps/play/](http://localhost:8080/rps/play/ "http://localhost:8080/rps/play/") endpoint in the following format with one of the possible **legal moves (i.e., rock, paper, scissors, lizard, spock)**.

#####  Sample Player Request Format:
```json
{
  "name": "Ponky",
  "move": "rock"
}
```

2. The game engine chooses a move in reaction to player's choice and the player receives a game result in a following format. 

##### Sample Game Result Format:
```json
{
  "moves": [
    {
      "name": "Ponky",
      "move": "rock"
    },
    {
      "name": "Bot",
      "move": "lizard"
    }
  ],
  "result": "Ponky wins"
}
```

### Accessing Results From Database:

As the game results are stored in the PostgreSQL, they can be accessed anytime using `GET` request to the [http://localhost:8080/rps/result/](http://localhost:8080/rps/result/ "http://localhost:8080/rps/result/") endpoint. 

------------
## Tests:

1. **Unit Testing**: Game Logic (e.g., MatchShouldDraw and PaperWinsAgainstRock). 
2. **Postman** for API testing. 

------------
## TODO:

#### Unit tests for Game Controller.
1. Routes should work! - test controller and urls - make custom http client and try to hit the API endpoints with proper and improper data.
2. Make tests to check request body in proper JSON format.
3. Make dummy json body to check if JSON is valid or not.
4. Is the player move legal?
