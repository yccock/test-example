package com.test.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * http://www.cnblogs.com/xdp-gacl/p/4007225.html
 * https://www.jianshu.com/p/10241754cdd7
 * https://www.jianshu.com/p/23987c675450
 */
public class DBUtilsCRUD {

    private static DataSource dataSource = JdbcUtils.getDataSource();

    public static void findOne() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from user where id=?";
        Object[] params = {1};
        Object[] query = queryRunner.query(sql, new ArrayHandler(), params);
        Object[] query1 = queryRunner.query(dataSource.getConnection(), sql, new ArrayHandler());
        // UserInfo userInfo = queryRunner.query(sql, params, new BeanHandler<>(UserInfo.class));
        // System.out.println(userInfo);
    }

    public static void findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "select * from user";
        List<UserInfo> userInfos = queryRunner.query(sql, new BeanListHandler<>(UserInfo.class));
        System.out.println(userInfos);
    }

    public static void save() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user(name,age) values(?,?)";
        Object params[] = {"test", 20};
        queryRunner.update(sql, params);
    }

    public static void batchSave() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user(name,age) values(?,?)";
        Object params[][] = new Object[10][];
        for (int i = 0; i < 2; i++) {
            params[i] = new Object[]{"wdx" + i, i};
        }
        queryRunner.batch(sql, params);
    }

    public static void update() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "update user set age=? where id=?";
        Object params[] = {20, 1};
        queryRunner.update(sql, params);
    }

    public static void delete() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "delete from user where id=?";
        queryRunner.update(sql, 1);
    }


    public static void main(String[] args) throws SQLException {
        DBUtilsCRUD.save();
    }
}
