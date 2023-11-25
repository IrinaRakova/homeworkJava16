package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinFirstPlayer(){
        Player player1 = new Player(1,"Vova", 1500);
        Player player2 = new Player(2,"Oleg", 1000);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Vova", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer(){
        Player player1 = new Player(1,"Vova", 1500);
        Player player2 = new Player(2,"Oleg", 2000);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Vova", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinBoth(){
        Player player1 = new Player(1,"Vova", 1500);
        Player player2 = new Player(2,"Oleg", 1500);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Vova", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredFirstPlayer(){
        Player player1 = new Player(1,"Vova", 1500);
        Player player2 = new Player(2,"Oleg", 1000);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("Olya", "Oleg")
        );
    }

    @Test
    public void shouldNotRegisteredSecondPlayer(){
        Player player1 = new Player(1,"Vova", 1500);
        Player player2 = new Player(2,"Oleg", 1000);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("Vova", "Olya")
        );
    }
}
