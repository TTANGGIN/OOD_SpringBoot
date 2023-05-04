package deu.se.ood.model.ch06;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddrBookManager {

    private String mysqlServerIp;
    private String mysqlServerPort;
    private String userName;
    private String password;
    private String jdbcDriver;

    public AddrBookManager() {
        log.debug("AddrBookManager(): mysqlServerIp = {}, jdbcDriver = {}", this.mysqlServerIp, this.jdbcDriver);
    }

    public AddrBookManager(String mysqlServerIp, String mysqlServerPort, String userName, String password, String jdbcDriver) {
        this.mysqlServerIp = mysqlServerIp;
        this.mysqlServerPort = mysqlServerPort;
        this.userName = userName;
        this.password = password;
        this.jdbcDriver = jdbcDriver;
        log.debug("AddrBookManager(): mysqlServerIp = {}, jdbcDriver = {}", this.mysqlServerIp, this.jdbcDriver);
    }

    public List<AddrBookRow> getAllRows() {
        List<AddrBookRow> dataList = new ArrayList<>();
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail", this.mysqlServerIp, this.mysqlServerPort);
        log.debug("JDBC_URL = {}: mysqlServerIp = {}, jdbcDriver = {}", JDBC_URL, this.mysqlServerIp, this.jdbcDriver);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(JDBC_URL, userName, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM addrbook";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                dataList.add(new AddrBookRow(email, name, phone));
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생오류: {})", ex.getMessage());
        }
        return dataList;
    }

    public void addRow(String email, String name, String phone) {
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail", this.mysqlServerIp, this.mysqlServerPort);
        log.debug("JDBC_URL = {}", JDBC_URL);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(jdbcDriver);

            conn = DriverManager.getConnection(JDBC_URL, userName, password);

            String sql = "INSERT INTO addrbook VALUES (?,?,?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);

            pstmt.executeUpdate();

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생오류: {})", ex.getMessage());
        }
    }
}