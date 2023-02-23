package com.dmainali.jdbcdemo.dao;

import com.dmainali.jdbcdemo.ItemException;
import com.dmainali.jdbcdemo.model.Item;
import com.dmainali.jdbcdemo.utils.DbConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDao {

    public int save(Item item) {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "INSERT INTO item(id,item_name,category, quantity, price) values(?,?,?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getItemName());
            stmt.setString(3, item.getCategory());
            stmt.setInt(4, item.getQuantity());
            stmt.setDouble(5, item.getPrice());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ItemException("error.item.exists",e.getLocalizedMessage(),e);
        }
    }


    public List<Item> findAll() {
        Connection con = DbConnection.getConnection();
        try{
            String sql = "SELECT * from item";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Item> items = new ArrayList<>();
            while(rs.next()){
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setItemName(rs.getString("item_name"));
                item.setCategory(rs.getString("category"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getDouble("price"));
                items.add(item);
            }
            return items;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Item findbyID(int id) {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "SELECT * from item where id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Item itemObj=null;
            while(resultSet.next()){
                itemObj = new Item();
                itemObj.setId(resultSet.getInt("id"));
                itemObj.setItemName(resultSet.getString("item_name"));
                itemObj.setCategory(resultSet.getString("category"));
                itemObj.setQuantity(resultSet.getInt("quantity"));
                itemObj.setPrice(resultSet.getDouble("price"));
            }
            return itemObj;

        } catch (SQLException e) {
            throw new ItemException("error.item.exists",e.getLocalizedMessage(),e);
        }
    }

    public Item updateById(Item item, int id) {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "UPDATE item SET item_name =?, category =? , quantity =? , price =? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getQuantity());
            if(item.getPrice() == null) {
                stmt.setDouble(4,0d);
            }else {
                stmt.setDouble(4, item.getPrice());
            }
            stmt.setInt(5, id);
            stmt.executeUpdate();
            return item;

        } catch (SQLException e) {
            throw new ItemException("error.item.exists",e.getLocalizedMessage(),e);
        }
    }

    public int deleteById(Item item) {
        Connection con = DbConnection.getConnection();
        try {
            String sql = "DELETE FROM item WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getId());
            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
