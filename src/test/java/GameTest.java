import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.manager.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Game games = new Game();
    Player player1 = new Player(234, "Nandy", 79);
    Player player2 = new Player(235, "Uex2", 66);
    Player player3 = new Player(236, "Nikitos", 96);
    Player player4 = new Player(237, "Barsa", 80);
    Player player5 = new Player(238, "Ser495", 78);
    Player player6 = new Player(239, "Gucci", 46);
    Player player7 = new Player(240, "ALIGATOR6000", 96);
    Player player8 = new Player(241, "Vanya1", 48);

    @Test
    void secondPlayerWin() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        games.register(player6);
        games.register(player7);
        games.register(player8);

        int actual = games.round("Gucci", "Ser495");
        int expected = 2;

        assertEquals(actual, expected);
    }
    @Test
    void draw() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        games.register(player6);
        games.register(player7);
        games.register(player8);

        int actual = games.round("Nikitos", "ALIGATOR6000");
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    void firstPlayerWin() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);
        games.register(player6);
        games.register(player7);
        games.register(player8);

        int actual = games.round("Nandy", "Vanya1");
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    void roundWithUnRegisteredPlayer1() {
        games.register(player6);
        games.register(player7);
        games.register(player8);

        assertThrows(NotRegisteredException.class, () -> {
            games.round("Vanya1", "SEREGA");
        });
    }
    @Test
    void roundWithUnRegisteredPlayer2() {
        games.register(player6);
        games.register(player7);
        games.register(player8);

        assertThrows(NotRegisteredException.class, () -> {
            games.round("Rise", "ALIGATOR6000");
        });
    }
}
