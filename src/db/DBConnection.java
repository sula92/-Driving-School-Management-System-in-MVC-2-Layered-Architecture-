package db;

import javafx.scene.control.Alert;
import lk.ijse.Encryption.DEPCrypt;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnection {

    public static String host;
    public static String port;
    public static String db;
    public static String username;
    public static String password;
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Properties properties = new Properties();
            File file = new File("resources/application.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();

            String ip = properties.getProperty("sl.ip");
            DBConnection.host = ip;
            String port = properties.getProperty("sl.port");
            String db = properties.getProperty("sl.db");
            DBConnection.db = db;
            String user = DEPCrypt.decode(properties.getProperty("sl.user"),"123");
            DBConnection.username = user;
            String password = DEPCrypt.decode(properties.getProperty("sl.password"),"123");
            DBConnection.password = password;



            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + "?serverTimezone=GMT%2B8", user, password);
            PreparedStatement pstm = connection.prepareStatement("SHOW TABLES");
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()) {

                File dbScriptfile=new File("samadhi_learners.sql");//db-Script
                if (!dbScriptfile.exists()){
                    new Alert(Alert.AlertType.ERROR,"The DB File Does Not Exist,Contact DEPPO");
                    throw new RuntimeException("DB File Can Not Find");

                }

                StringBuilder sb=new StringBuilder();
                BufferedReader brDBScript=new BufferedReader(new InputStreamReader(new FileInputStream(dbScriptfile)));
                brDBScript.lines().forEach(s -> sb.append(s));
                brDBScript.close();
                System.out.println(sb.toString());

                pstm = connection.prepareStatement(sb.toString());
                pstm.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        return (dbConnection == null) ? (dbConnection = new DBConnection()) : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
