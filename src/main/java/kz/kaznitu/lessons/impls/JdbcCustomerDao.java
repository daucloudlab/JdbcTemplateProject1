package kz.kaznitu.lessons.impls;


import kz.kaznitu.lessons.interfaces.CustomerDao;
import kz.kaznitu.lessons.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDao implements CustomerDao{
    private DataSource dataSource ;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Customer customer) {
        String sql = "INSERT INTO customer (name, age) VALUES (?, ?)" ;
        Connection conn = null ;
        try{
            conn = dataSource.getConnection() ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setString(1, customer.getName());
            ps.setInt(2,customer.getAge());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public Customer findCustomerById(int custId) {
        String sql = "SELECT * FROM customer WHERE cust_id = ?" ;
        Connection conn = null ;
        try{
            conn = dataSource.getConnection() ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, custId) ;
            ResultSet rs = ps.executeQuery() ;
            Customer customer = null ;
            while (rs.next()){
                customer = new Customer(
                        rs.getInt("cust_id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
            rs.close();
            ps.close();
            return customer ;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
