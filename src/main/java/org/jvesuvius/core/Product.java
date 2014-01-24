package org.jvesuvius.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jvesuvius.core.Database;

class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}

class ProductList {
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

    private ResultSet getResultSetAll() {
        Database db = new Database();
        String template = "select %s from %s";
        String query = String.format(template,
            "product_id, product_name, product_price, product_desc",
            "product");
        ResultSet rs = db.getResultSet(query);
        return rs;
    }
}
