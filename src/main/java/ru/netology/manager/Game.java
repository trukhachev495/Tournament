package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findByNam(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int player1 = findByNam(name1);
        int player2 = findByNam(name2);

        if (player1 == -1) {
            throw new NotRegisteredException("Player " + (name1) + " not found!");
        }
        if (player2 == -1) {
            throw new NotRegisteredException("Player " + (name2) + " not found!");
        }
        int strength1 = players.get(player1).getStrength();
        int strength2 = players.get(player2).getStrength();

        if (strength1 == strength2) {
            return 0;
        }
        if (strength1 > strength2) {
            return 1;
        }
        return 2;
    }
}

