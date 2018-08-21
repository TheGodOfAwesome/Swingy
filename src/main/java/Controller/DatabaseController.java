package Controller;

import Model.Hero;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    public static void createNewDatabase() {

        String url = "jdbc:sqlite:Swingy.db";

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // db parameters
            String url = "jdbc:sqlite:Swingy.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void createHeroTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Swingy.db";

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
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean insertHero(Hero hero) {
        if (!findDuplicateHero(hero.HeroName)) {
            String sql = "INSERT INTO Heros (hero_name, hero_class, hero_att, hero_def, hero_hp, hero_lvl, hero_xp)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?);";
            //System.out.println(hero.HeroName + ", " + hero.HeroClass + ", " + hero.HeroHp + ", " + hero.HeroAtt + ", " + hero.HeroDef + ", " + hero.HeroLvl + ", " + hero.HeroXp);
            try {
                Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, hero.HeroName);
                pstmt.setString(2, hero.HeroClass);
                pstmt.setInt(3, hero.HeroAtt);
                pstmt.setInt(4, hero.HeroDef);
                pstmt.setInt(5, hero.HeroHp);
                pstmt.setInt(6, hero.HeroLvl);
                pstmt.setInt(7, hero.HeroXp);
                pstmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return (false);
    }

    public static List<Hero> selectAll(){
        String sql = "SELECT hero_id, hero_name, hero_class, hero_att, hero_def, hero_hp, hero_lvl, hero_xp FROM Heros";
        List<Hero> heroes = new ArrayList<Hero>();
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            // loop through the result set
            int count = 0;
            while (rs.next()) {
                Hero hero = new Hero();
                hero.HeroName = rs.getString("hero_name");
                hero.HeroClass = rs.getString("hero_class");
                hero.HeroAtt = rs.getInt("hero_att");
                hero.HeroDef = rs.getInt("hero_def");
                hero.HeroHp = rs.getInt("hero_hp");
                hero.HeroLvl = rs.getInt("hero_lvl");
                hero.HeroXp = rs.getInt("hero_xp");
                heroes.add(count, hero);
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (heroes);
    }

    public static Hero selectHero(String HeroName){
        Hero hero = new Hero();
        System.out.println(HeroName);
        //String sql = "SELECT hero_id, hero_name, hero_class, hero_att, hero_def, hero_hp, hero_lvl, hero_xp FROM Heros";
        String sql = "SELECT * FROM Heros";
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                if (HeroName.equalsIgnoreCase(rs.getString("hero_name"))) {
                    hero.HeroName = rs.getString("hero_name");
                    hero.HeroClass = rs.getString("hero_class");
                    hero.HeroAtt = rs.getInt("hero_att");
                    hero.HeroDef = rs.getInt("hero_def");
                    hero.HeroHp = rs.getInt("hero_hp");
                    hero.HeroLvl = rs.getInt("hero_lvl");
                    hero.HeroXp = rs.getInt("hero_xp");
                    //System.out.println("found!");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (hero);
    }

    public static boolean findDuplicateHero(String HeroName){
        String sql = "SELECT hero_id, hero_name, hero_class, hero_att, hero_def, hero_hp, hero_lvl, hero_xp FROM Heros";
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                if (rs.getString("hero_name").equalsIgnoreCase(HeroName))
                    return (true);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (false);
    }

    public static void updateHero(Hero hero) {
        String sql = "UPDATE Heros SET"
                + " hero_class = ? ,"
                + " hero_att = ? ,"
                + " hero_def = ? ,"
                + " hero_hp = ? ,"
                + " hero_lvl = ? ,"
                + " hero_xp = ? "
                + "WHERE hero_name = ?";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, hero.HeroClass);
            pstmt.setInt(2, hero.HeroAtt);
            pstmt.setInt(3, hero.HeroDef);
            pstmt.setInt(4, hero.HeroHp);
            pstmt.setInt(5, hero.HeroLvl);
            pstmt.setInt(6, hero.HeroXp);
            pstmt.setString(7, hero.HeroName);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteHero(Hero hero) {
        String sql = "DELETE FROM Heros WHERE hero_name = ?";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, hero.HeroName);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
