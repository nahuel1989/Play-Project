package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import models.*;

import static play.data.Form.form;

import play.*;

import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import static play.libs.Json.toJson;

import play.mvc.*;

import views.html.*;


public class SaleController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result newSale(){
        try {
            JsonNode json = request().body().asJson();
            Sale sale = Json.fromJson(json, Sale.class);
            if(sale.toString().equals("")){
                return badRequest("Missing parameter");
            }
            synchronized(SaleController.class){
                boolean stockOK = true;
                Product prod = Product.find.byId(sale.getProduct().getId());
                for(Supply supply: prod.getSupplys()){
                    if(supply.getStock()<sale.getAmount()){
                        stockOK = false;
                    }
                }
                if(stockOK){
                    for(Supply supply: prod.getSupplys()){
                        supply.setStock(supply.getStock()-sale.getAmount());
                        supply.update();
                    }
                    sale.save();
                    return ok();
                }
                return internalServerError("No hay suficiente stock para realizar la venta");
            }
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    } 
    
    
   
}
