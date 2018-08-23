package Model;

public class Map {

    public int      mapX;
    public int      mapY;
    public int      centreX;
    public int      centreY;
    public int      playerX;
    public int      playerY;

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

    public int mapSize(Hero hero){
        //(level-1)*5+10-(level%2)
        int mapSize = (hero.getHeroLvl() - 1) * 5 + 10 - (hero.getHeroLvl() % 2);

        if (mapSize > 19) {
            mapSize = 19;
        }

        setMapX(mapSize);
        setMapY(mapSize);
        setCentreX(mapSize/2);
        setCentreY(mapSize/2);

        return (mapSize);
    }
}
