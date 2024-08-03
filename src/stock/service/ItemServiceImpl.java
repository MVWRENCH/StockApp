/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import stock.ItemDatabase;
import stock.model.TransactionModel;

/**
 *
 * @author reynn
 */
public class ItemServiceImpl implements ItemService{

    private Connection connection;
    
    @Override
    public void insert(TransactionModel request){
     
        //masukkan data ke database
        connection = ItemDatabase.getConnection();
        String query = "INSERT INTO transaction"
                + "(name, item_id, total_price, admin, qty, date_buy)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement= (PreparedStatement) connection.prepareStatement(query);
          
            statement.setString(1, request.getName());
            statement.setInt(2, request.getItem_id());
            statement.setDouble(3, request.getTotal_price());
            statement.setString(4, request.getAdmin());
            statement.setInt(5, request.getQty());
            statement.setString(6, request.getDate_buy().toString());
          
            statement.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public Double getPrice(int id) {
        connection = ItemDatabase.getConnection();
        String query = "select price from items where id = ? limit 1";
        Double result = 0.00;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
           
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getDouble("price");
            } else {
                return 0.00;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return result;
    }

    @Override
    public List<Object[]> report(String request) {
        connection = ItemDatabase.getConnection();
        String query = "select a.name as nama,\n" +
                        "       a.total_price as total_harga,\n" +
                        "       b.name as nama_obat,\n" +
                        "       a.id as nomor_transaksi\n" +
                        "from transaction a\n" +
                        "         join items b on a.item_id = b.id\n" +
                        "where a.name = ?";

        List<Object[]> resultList = new ArrayList<Object[]>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, request);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nama = resultSet.getString("nama");
                    double totalHarga = resultSet.getDouble("total_harga");
                    String namaObat = resultSet.getString("nama_obat");
                    int nomorTransaksi = resultSet.getInt("nomor_transaksi");

                    Object[] resultRow = {nama, totalHarga, namaObat, nomorTransaksi};
                    resultList.add(resultRow);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return resultList;
    }

}
