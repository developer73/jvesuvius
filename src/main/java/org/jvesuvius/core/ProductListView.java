package org.jvesuvius.core;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jvesuvius.core.Product;
import org.jvesuvius.core.ProductContainer;
import org.jvesuvius.core.ToJsonConverter;

@Path("list")
public class ProductListView {
    @GET
    @Produces("application/json")
    public String getMessage() {
        ProductContainer pc = new ProductContainer();
        ArrayList<Product> products = pc.getAll();
        ToJsonConverter conv = new ToJsonConverter();
        return conv.convert(products);
    }
}
