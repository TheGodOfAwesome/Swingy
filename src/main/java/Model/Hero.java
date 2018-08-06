package Model;

public class Hero {
    /*Hero name
    • Hero class
    • Level
    • Experience
    • Attack
    • Defense
    • Hit Points
    */
    public String   HeroName;
    public String   HeroClass;
    public int      HeroAtt;
    public int      HeroDef;
    public int      HeroHp;
    public int      HeroLvl;
    public int      HeroXp;

    public String getHeroName() {
        return HeroName;
    }

    public String setHeroName(String Name) {
        HeroName = Name;
        return HeroName;
    }

    public String getHeroClass() {
        return HeroClass;
    }

    public String setHeroClass(String Class) {
        HeroClass = Class;
        return HeroClass;
    }

    public int getHeroAtt() {
        return HeroAtt;
    }

    public int setHeroAtt(int Attack) {
        HeroAtt = Attack;
        return HeroAtt;
    }

    public int getHeroDef() {
        return HeroDef;
    }

    public int setHeroDef(int Defense) {
        HeroAtt = Defense;
        return HeroDef;
    }

    public int getHeroHp() {
        return HeroHp;
    }

    public int setHeroHp(int HitPoints) {
        HeroHp = HitPoints;
        return HeroHp;
    }

    public int getHeroLvl() {
        return HeroLvl;
    }

    public int setHeroLvl(int Level) {
        HeroLvl = Level;
        return HeroLvl;
    }
    public int getHeroXp() {
        return HeroXp;
    }

    public int setHeroXp(int Experience) {
        HeroXp = Experience;
        return HeroXp;
    }
}
