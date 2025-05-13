package game_data.Utility_Classes;

import game_data.Enemies.Enemy;

import java.util.List;

public class EnemyFormation {
    private List<Enemy> enemyList; //I thought about using an array over a list. It can work but lists are more familiar to me.

    public EnemyFormation(List<Enemy> enemyList) {
        if (enemyList.size() > 5)
            throw new IllegalArgumentException("Enemy formation cannot have more than 5 enemies");
        this.enemyList = enemyList;
    }

    public Enemy getEnemyAtPosition(int position) {
        if (position < 0 || position >= enemyList.size())
            return null;
        return enemyList.get(position);
    }

    public List<Enemy> getEnemies() {
        return enemyList;
    }

    public int size() {
        return enemyList.size();
    }

    //Tried a StringBuilder format
    public String toString() {
        StringBuilder str = new StringBuilder("Enemy Formation: \n");
        for (int i = 0; i < enemyList.size(); i++) {
            str.append(String.format("Position %d: %s%n", i, enemyList.get(i).getName()));
        }
        return str.toString();
    }


}
