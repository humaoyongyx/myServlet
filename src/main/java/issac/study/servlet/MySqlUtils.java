package issac.study.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author issac.hu
 */
public class MySqlUtils {

    public static List<Map<String, Object>> query() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "root";
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from config";
            pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            ResultSetMetaData metaData = pstm.getMetaData();
            List<String> columns = new ArrayList<>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
            }
            List<Map<String, Object>> result = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> item = new LinkedHashMap<>();
                for (String column : columns) {
                    Object object = resultSet.getObject(column);
                    item.put(column, object);
                }
                result.add(item);
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return new ArrayList<>();
    }
}
