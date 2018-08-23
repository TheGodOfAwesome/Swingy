package Model;

public class Enemy {
    public String   EnemyName;
    public String   EnemyClass;
    public int      EnemyAtt;
    public int      EnemyDef;
    public int      EnemyHp;
    public int      EnemyLvl;
    public int      EnemyXp;
    public int      EnemyX;
    public int      EnemyY;

    public String getEnemyName() {
        return EnemyName;
    }

    public String setEnemyName(String Name) {
        EnemyName = Name;
        return EnemyName;
    }

    public String getEnemyClass() {
        return EnemyClass;
    }

    public String setEnemyClass(String Class) {
        EnemyClass = Class;
        return EnemyClass;
    }

    public int getEnemyAtt() {
        return EnemyAtt;
    }

    public int setEnemyAtt(int Attack) {
        EnemyAtt = Attack;
        return EnemyAtt;
    }

    public int getEnemyDef() {
        return EnemyDef;
    }

    public int setEnemyDef(int Defense) {
        EnemyAtt = Defense;
        return EnemyDef;
    }

    public int getEnemyHp() {
        return EnemyHp;
    }

    public int setEnemyHp(int HitPoints) {
        EnemyHp = HitPoints;
        return EnemyHp;
    }

    public int getEnemyLvl() {
        return EnemyLvl;
    }

    public int setEnemyLvl(int Level) {
        EnemyLvl = Level;
        return EnemyLvl;
    }

    public int getEnemyXp() {
        return EnemyXp;
    }

    public int setEnemyXp(int Experience) {
        EnemyXp = Experience;
        return EnemyXp;
    }

    public int getEnemyX() {
        return EnemyX;
    }

    public int setEnemyX(int newXCoordinate) {
        EnemyX = newXCoordinate;
        return EnemyX;
    }

    public int getEnemyY() {
        return EnemyY;
    }

    public int setEnemyY(int newYCoordinate) {
        EnemyY = newYCoordinate;
        return EnemyY;
    }
}
