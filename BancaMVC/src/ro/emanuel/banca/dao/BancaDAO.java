package ro.emanuel.banca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.banca.helpers.DBHelper;
import ro.emanuel.banca.pojo.Banca;

public class BancaDAO {
	  public static ArrayList<Banca> getBanca() throws SQLException {

	        String select = "select * from banca";

	        Connection con = DBHelper.getConnection();
	        
	        PreparedStatement stmt = con.prepareStatement(select);

	        ArrayList<Banca> result = new ArrayList<Banca>();
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	         
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String adresa = rs.getString("adresa");
	            String telefon = rs.getString("telefon");
	           
	            Banca b = new Banca(id, nume, adresa, telefon);
	            
	            result.add(b);
	        }
	        DBHelper.closeConnection();
	        return result;
	    }

	    public static void createBanca(Banca b) throws SQLException {
	        
	        String insert = "insert into banca (nume, adresa, telefon)" + "value(?,?,?)";

	        
	        Connection con = DBHelper.getConnection();

	        
	        PreparedStatement stmt = con.prepareStatement(insert);
	        stmt.setString(1, b.getNume());
	        stmt.setString(2, b.getAdresa());
	        stmt.setString(3, b.getTelefon());
	       
	        stmt.executeUpdate();

	        DBHelper.closeConnection();
	    }

	    public static void updateBanca(Banca b) throws SQLException {

	        String update = "update banca set nume = ?, adresa=?, telefon=? where id = ?";

	        Connection con = DBHelper.getConnection();

	        PreparedStatement stmt = con.prepareStatement(update);
	        stmt.setString(1, b.getNume());
	        stmt.setString(2, b.getAdresa());
	        stmt.setString(3, b.getTelefon());
	        stmt.setInt(4, b.getId());
	        
	        stmt.executeUpdate();

	        DBHelper.closeConnection();
	    }

	    public static void deleteBanca(Integer id) throws SQLException {

	        String delete = "delete from student where id = ?";

	        Connection con = DBHelper.getConnection();

	        PreparedStatement stmt = con.prepareStatement(delete);
	        stmt.setInt(1, id);
	 
	        stmt.executeUpdate();

	        DBHelper.closeConnection();
	    }

	    public static Banca getBancaByID(int id) throws SQLException {
	        String select = "select * from banca where id =?";
	        Connection con = DBHelper.getConnection();
	        PreparedStatement stmt = con.prepareStatement(select);
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        Banca result = null;
	        if (rs.next()) {
	            String nume = rs.getString("nume");
	            String adresa = rs.getString("adresa");
	            String telefon = rs.getString("telefon");
	            result = new Banca(id, nume, adresa, telefon);
	        }
	        DBHelper.closeConnection();
	        return result;
	    }

	    public static ArrayList<Banca> getBancaByName(String nameQuery) throws SQLException {
	        String select = "select * from banca WHERE nume LIKE ?";
	        Connection con = DBHelper.getConnection();
	        PreparedStatement stmt = con.prepareStatement(select);
	        stmt.setString(1, '%' + nameQuery + '%');
	        ResultSet rs = stmt.executeQuery();
	        ArrayList<Banca> result = new ArrayList<Banca>();
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String adresa = rs.getString("adresa");
	            String telefon = rs.getString("telefon");
	            result.add(new Banca(id, nume, adresa, telefon));
	        }
	        DBHelper.closeConnection();
	        return result;
	    }
}
