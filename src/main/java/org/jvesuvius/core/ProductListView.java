package org.jvesuvius.core;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jvesuvius.core.Product;
import org.jvesuvius.core.ProductList;
import org.jvesuvius.core.ToJsonConverter;

@Path("list")
public class ProductListView {
    @GET
    @Produces("application/json")
    public String getMessage() {
        ProductList productList = new ProductList();
        ArrayList<Product> products = productList.getAll();
        ToJsonConverter conv = new ToJsonConverter();
        return conv.convert(products);
    }
}
