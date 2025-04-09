package game_data;

public class Relic extends Entity {
    private String set;
    private String piece;

    //game_data.Relic Constructor
    public Relic(int id, String name, int hp, int atk, int def, int spd, float cr, float cd, float bonusDmg,
                 String set, String piece) {
        super(id, name, hp, atk, def, spd, cr, cd, bonusDmg);
        this.set = set;
        this.piece = piece;
    }

    //Current available relic sets as of HSR V3.2
    private static final String[] setsList = {"Passerby of Wandering Cloud", "Musketeer of Wild Wheat",
            "Knight of Purity Palace", "Hunter of Glacial Forest", "Champion of Streetwise Boxing", "Guard of Wuthering Snow",
            "Firesmith of Lava-Forging", "Genius of Brilliant Stars", "Band of Sizzling Thunder", "Eagle of Twilight Line",
            "Theif of Shooting Meteor", "Wastelander of Banditry Desert", "Longevous Disciple", "Messenger of Traversing Hackerspace",
            "The Ashblazing Grand Duke", "Prisoner in Deep Confinement", "Pioneer Diver of Dead Waters",
            "Watchmaker, Master of Dream Machiantions", "Iron Cavalry Against the Scourge", "The Wind-Soaring Valorous",
            "Sacerdos' Relived Ordeal", "Scholar Lost in Erudition", "Hero of Triumphant Song", "Poet of Mourning Collapse",
            "Warrior of Goddess of Daythunder", "Captain Over Cursed Waves", "Space Sealing Station", "Fleet of the Ageless",
            "Pan-Cosmic Commercial Enterprise", "Belobog of the Architects", "Celestial Differentiator", "Inert Salsotto",
            "Talia: Kingdom of Banditry", "Sprightly Vonwacq", "Rutilant Arena", "Broken Keel", "Firmament Frontline: Glamoth",
            "Penacony, Land of the Dreams", "Sigonia, the Unclaimed Desolation", "Izumo Gensei and Takama Divine Realm",
            "Duran, Dynasty of Running Wolves", "Forge of the Kalpagni Lantern", "Lushaka, the Sunken Seas", "The Wondorous BananAmusement Park",
            "Bone Collection's Serene Demesne", "Giant Tree of Rapt Brooding"};

    private static final String[] pieceList = {"Head", "Hands", "Body", "Feet", "Planar Sphere", "Link Rope"};

    public String getSet() {return set;}
    public String getPiece() {return piece;}
    public void setSet() {this.set = set;}
    public void setPiece() {this.piece = piece;}

    public static void equipRelic(Character c, Relic r) {
        c.setHp(c.getHp() + r.getHp());
        c.setAtk(c.getAtk() + r.getAtk());
        c.setDef(c.getDef() + r.getDef());
        c.setSpd(c.getSpd() + r.getSpd());
        c.setCr(c.getCr() + r.getCr());
        c.setCr(c.getCd() + r.getCd());
        c.setBonusDmg(c.getBonusDmg() + r.getBonusDmg());
    }


}
