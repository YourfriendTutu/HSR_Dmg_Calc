package game_data;

public class Enemy extends Entity {

    //game_data.Enemy Constructor
    public Enemy(int id, String name, int hp, int atk, int def, int spd, float elemRes) {
        super(id, 'E', name, hp, atk, def, spd, elemRes);
    }

}
