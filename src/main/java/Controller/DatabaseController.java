package Controller;

import Model.Hero;

import java.sql.*;

public class DatabaseController
{

    private static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:./sqlite.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to database has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewTable() {
        // SQLite connection string
        Connection conn = connect();

        // SQL statement for creating a new table
        String sql = "Create Table If Not Exists Heros(\n" +
                " hero_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                " hero_name text NOT NULL,\n" +
                " hero_class text NOT NULL,\n" +
                " hero_att integer  NOT NULL,\n" +
                " hero_def integer  NOT NULL,\n" +
                " hero_hp integer  NOT NULL,\n" +
                " hero_lvl integer  NOT NULL,\n" +
                " hero_xp integer  NOT NULL\n" +
                ");";

        try {
            // create a new table
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InsertHeroRecord(Hero hero) {
        // SQLite connection string
        Connection conn = connect();

        // SQL statement for creating a new table
        String sql = "INSERT INTO Heros ( hero_name, hero_class, hero_att, hero_def, hero_hp, hero_lvl, hero_xp)" +
                "VALUES( " + hero.getHeroName() + ",  " + hero.HeroClass + ", " + hero.HeroHp + ", " + hero.HeroAtt + ", " + hero.HeroDef + ", " + hero.HeroLvl + ", " + hero.HeroXp + ");";

        try {
            // create a new table
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Insert Hero Query Failed: " + e.getMessage());
        }
    }

    public static Hero GetHeroFromTable(String heroName){
        Hero hero = new Hero();

        // SQLite connection string
        Connection conn = connect();

        // SQL statement for creating a new table
        String sql = "Select * from Heros Where hero_name = " + heroName + ";";

        try {
            // create a new table
            Statement stmt = conn.createStatement();
            //stmt.execute(sql);
            ResultSet rs    = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                hero.HeroName = rs.getString("hero_name");
                hero.HeroClass =  rs.getString("hero_class");
                hero.HeroAtt = rs.getInt("hero_att");
                hero.HeroDef =  rs.getInt("hero_def");
                hero.HeroHp = rs.getInt("hero_hp");
                hero.HeroLvl =  rs.getInt("hero_lvl");
                hero.HeroXp = rs.getInt("hero_xp");
            }
        } catch (SQLException e) {
            System.out.println("Select Hero Query Failed: " + e.getMessage());
        }
        return hero;
    }
}
