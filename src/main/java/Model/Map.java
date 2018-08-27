package Model;

import java.util.*;

public class Map {

    public int          mapX;
    public int          mapY;
    public int          centreX;
    public int          centreY;
    public int          playerX;
    public int          playerY;
    public int          previousPlayerX;
    public int          previousPlayerY;
    public List<Enemy>  enemies;
    public String       gameState;
    public String[][]   mapLayout;


    public Map(Hero hero) {
        generateMap(hero);
        setEnemies(generateEnemies(hero));
        setMapLayout(loadMap(hero));
    }


    public String getGameState() {
        return gameState;
    }

    public String setGameState(String newGameState) {
        gameState = newGameState;
        return gameState;
    }

    public int getMapX() {
        return mapX;
    }

    public int setMapX(int newMapX) {
        mapX = newMapX;
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public int setMapY(int newMapY) {
        mapY = newMapY;
        return mapY;
    }

    public int getCentreX() {
        return centreX;
    }

    public int setCentreX(int newCentreX) {
        centreX = newCentreX;
        return centreX;
    }

    public int getCentreY() {
        return centreY;
    }

    public int setCentreY(int newCentreY) {
        centreY = newCentreY;
        return centreY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int setPlayerX(int newPlayerX) {
        playerX = newPlayerX;
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int setPlayerY(int newPlayerY) {
        playerY = newPlayerY;
        return playerY;
    }

    public int getPreviousPlayerX() {
        return previousPlayerX;
    }

    public int setPreviousPlayerX(int newPreviousPlayerX) {
        previousPlayerX = newPreviousPlayerX;
        return previousPlayerX;
    }

    public int getPreviousPlayerY() {
        return previousPlayerY;
    }

    public int setPreviousPlayerY(int newPreviousPlayerY) {
        previousPlayerY = newPreviousPlayerY;
        return previousPlayerY;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Enemy> setEnemies(List<Enemy> newEnemies ) {
        enemies = newEnemies;
        return enemies;
    }

    public String[][] getMapLayout() {
        return mapLayout;
    }

    public String[][] setMapLayout(String[][] newMapLayout) {
        mapLayout = newMapLayout;
        return mapLayout;
    }

    public int generateMap(Hero hero){
        //(level-1)*5+10-(level%2)
        int mapSize = (hero.getHeroLvl() - 1) * 5 + 10 - (hero.getHeroLvl() % 2);

        if (mapSize > 19) {
            mapSize = 19;
        }

        setMapX(mapSize);
        setMapY(mapSize);
        setCentreX(mapSize/2);
        setCentreY(mapSize/2);
        setPlayerX(getCentreX());
        setPlayerY(getCentreY());

        /*
        System.out.print("Map Generated: \n"
                + "Map X: " + getMapX() + "\n"
                + "Map Y: " + getMapY() + "\n"
                + "Centre X: " + getCentreX() + "\n"
                + "Centre Y: " + getCentreY() + "\n"
                + "Player X: " + getPlayerX() + "\n"
                + "Player Y: " + getPlayerY() + "\n");
        */

        return (mapSize);
    }

    public List<Enemy> generateEnemies(Hero hero) {
        Random rand = new Random();

        int         baseEnemyHp = 100;
        int         baseEnemyAtt = 5;
        int         baseEnemyDef = 5;
        int         baseEnemyXp = 100;
        int         enemyLvl = 1;

        int         count = 0;
        int         coordinateLimit = getMapX();
        int         numberOfEnemies = rand.nextInt(10) + 1;

        List<Enemy> generatedEnemies = new ArrayList<Enemy>();

        String[]    enemyClass = {"Kobol", "Mimic", "Blink Dog", "Succubus", "Vampire", "Wearwolf", "Banshee","OwlBear", "Giant", "Dragon"};

        enemyLvl = hero.HeroLvl;
        if (enemyLvl > 10)
            enemyLvl = 10;
        while(numberOfEnemies >= count) {
            int      enemyX = 0;
            int      enemyY = 0;
            Enemy enemy = new Enemy();

            enemy.setEnemyName(enemyClass[enemyLvl - 1] + count);
            enemy.setEnemyClass(enemyClass[enemyLvl - 1]);
            enemy.setEnemyAtt(baseEnemyAtt * enemyLvl);
            enemy.setEnemyDef(baseEnemyDef * enemyLvl);
            enemy.setEnemyHp(baseEnemyHp + (10 * enemyLvl));
            enemy.setEnemyXp(baseEnemyXp * enemyLvl);

            enemyX = rand.nextInt(coordinateLimit);
            enemyY = rand.nextInt(coordinateLimit);

            for (Enemy newEnemy : generatedEnemies) {
                if ((newEnemy.getEnemyX() == enemyX) && (newEnemy.getEnemyY() == enemyY)
                        || (this.getCentreX() == enemyX) && (this.getCentreY() == enemyY)) {
                    enemyX = rand.nextInt(coordinateLimit);
                    enemyY = rand.nextInt(coordinateLimit);
                }
            }

            enemy.setEnemyX(enemyX);
            enemy.setEnemyY(enemyY);

            generatedEnemies.add(enemy);
            count++;
        }

        /*
        for (Enemy newEnemy : generatedEnemies) {
            System.out.print("Enemy: " + newEnemy.getEnemyName() + "\n"
                                        + newEnemy.getEnemyClass() + "\n"
                                        + newEnemy.getEnemyAtt() + "\n"
                                        + newEnemy.getEnemyDef() + "\n"
                                        + newEnemy.getEnemyHp() + "\n"
                                        + newEnemy.getEnemyXp() + "\n"
                                        + newEnemy.getEnemyX() + "\n"
                                        + newEnemy.getEnemyY() + "\n");
        }
        */

        return generatedEnemies;
    }

    public void removeEnemy(Enemy enemy) {
        List<Enemy> enemies = getEnemies();
        enemies.remove(enemy);
    }

    public String[][] loadMap(Hero player) {
        int rows = getMapX();
        int cols = getMapY();

        mapLayout = new String[rows][cols];

        for(int x = 0; x < getMapX(); x++) {
            for(int y = 0; y < getMapY(); y++){
                mapLayout[x][y] = "_";
            }
        }
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies = getEnemies();
        for (Enemy newEnemy : enemies) {
            mapLayout[newEnemy.getEnemyX()][newEnemy.getEnemyY()] = newEnemy.getEnemyClass().substring(0,1);
        }
        mapLayout[getPlayerX()][getPlayerY()] = player.getHeroName().substring(0, 1);

        //System.out.println(Arrays.deepToString(mapLayout));

        setMapLayout(mapLayout);
        return mapLayout;
    }

    public String[][] reloadMap(Hero player) {
        int rows = getMapX();
        int cols = getMapY();

        mapLayout = new String[rows][cols];

        for(int x = 0; x < getMapX(); x++) {
            for(int y = 0; y < getMapY(); y++){
                mapLayout[x][y] = "_";
            }
        }
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies = getEnemies();
        for (Enemy newEnemy : enemies) {
            mapLayout[newEnemy.getEnemyX()][newEnemy.getEnemyY()] = newEnemy.getEnemyClass().substring(0,1);
        }
        mapLayout[getPlayerX()][getPlayerY()] = player.getHeroName().substring(0, 1);

        //System.out.println(Arrays.deepToString(mapLayout));

        setMapLayout(mapLayout);
        return mapLayout;
    }

    public Enemy checkForEnemies() {
        List<Enemy> enemies = getEnemies();
        for (Enemy newEnemy : enemies) {
            if (newEnemy.getEnemyX() == getPlayerX() && newEnemy.getEnemyY() == getPlayerY()){
                return newEnemy;
            }
        }
        return null;
    }

}
