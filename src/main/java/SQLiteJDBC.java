
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC {

    private Connection c;
    private final String dictionarylocation = "jdbc:sqlite:Dictionary.db";

    public void readDatabase(Dictionary dictionary, String name) {
        try {
            c = DriverManager.getConnection(dictionarylocation);
            Statement stmt = c.createStatement();
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

    public void overwriteDatabase(Dictionary dictionary, String name) {
        String sql = "INSERT INTO " + name + "(word_target,word_explain,pronounce) VALUES(?,?,?)";
        try {
            c = DriverManager.getConnection(dictionarylocation);
            c.setAutoCommit(false);
            c.getTransactionIsolation();
            Statement stmt = c.createStatement();
            stmt.executeUpdate("DELETE FROM " + name + ";");
            PreparedStatement pstmt = c.prepareStatement(sql);
            for (int i = 0; i < dictionary.size(); i++) {
                pstmt.setString(1, dictionary.getWord_target(i));
                pstmt.setString(2, dictionary.getWord_explain(i));
                pstmt.setString(3, dictionary.getPronounce(i));
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            c.commit();
            pstmt.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
