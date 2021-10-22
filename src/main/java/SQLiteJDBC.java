
import java.sql.*;

public class SQLiteJDBC {

    public SQLiteJDBC(Dictionary dictionary, String name) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:Dictionary.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + name + ";");
            while (rs.next()) {
                String word_target = rs.getString("word_target");
                String word_explain = rs.getString("word_explain");
                String pronounce = rs.getString("pronounce");
                Word word = new Word(word_target, word_explain, pronounce);
                dictionary.addWord(word);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
/*
    public void insert(String word_target, String word_explain, String pronounce) {
        String sql = "INSERT OR REPLACE INTO av(word_target,word_explain,pronounce) VALUES(?,?,?)";
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DriverManager.getConnection("jdbc:sqlite:Dictionary.db");
            pstmt = c.prepareStatement(sql);
            pstmt.setString(1, word_target);
            pstmt.setString(2, word_explain);
            pstmt.setString(3, pronounce);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
*/
}
