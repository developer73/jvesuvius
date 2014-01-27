package org.jvesuvius.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jvesuvius.core.Database;
import org.jvesuvius.core.Product;

/**
* Handles Product related queries.
*/
public class ProductContainer {
    public ArrayList<Product> getAll() {
        ResultSet rs = getResultSetAll();
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            while(rs.next()) {
                Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("product_price"),
                    rs.getString("product_desc"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductById(int id) {
        ResultSet rs = getResultSetProductById(id);
        Product product = null;
        try {
            rs.next();
            product = new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getDouble("product_price"),
                rs.getString("product_desc"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    private ResultSet getResultSetAll() {
        Database db = new Database();
        String template = "select %s from %s";
        String query = String.format(template,
            "product_id, product_name, product_price, product_desc",
            "product");
        ResultSet rs = db.getResultSet(query);
        return rs;
    }
    private ResultSet getResultSetProductById(int id) {
        Database db = new Database();
        String template = "select %s from %s where %s%s";
        String query = String.format(template,
            "product_id, product_name, product_price, product_desc",
            "product",
            "product_id = ",
            id);
        ResultSet rs = db.getResultSet(query);
        return rs;
    }
}
