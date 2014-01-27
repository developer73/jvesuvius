package org.jvesuvius.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jvesuvius.core.ProductContainer;
import org.jvesuvius.core.ToJsonConverter;

@Path("{id}")
public class ProductView {
    @GET
    @Produces("application/json")
    public String getMessage(@PathParam("id") int id) {
        ProductContainer pc = new ProductContainer();
        Product product = pc.getProductById(id);
        ToJsonConverter conv = new ToJsonConverter();
        return conv.convert(product);
    }
}
