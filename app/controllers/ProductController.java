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


public class ProductController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addProduct(){
        try {
            JsonNode json = request().body().asJson();
            Product product = Json.fromJson(json, Product.class);
            if(product.toString().equals("")){
                return badRequest("Missing parameter");
            }
            product.save();
            return ok();
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    } 
    
    public static Result listProduct(){
        try {
            List<Product> products = new Model.Finder(String.class,Product.class).all();
            return ok(toJson(products));
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    public static Result getProduct(Long id){
        try {
            Product product = Product.find.byId(id);
            if(product == null){
                return notFound("Product not exists");
            }
            return ok(toJson(product));
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result updateProduct(Long id){
        try {
            Product product = Product.find.byId(id);
            if(product == null){
                return notFound("Product not exists");
            }

            JsonNode json = request().body().asJson();
            Product productUpdate = Json.fromJson(json, Product.class);
            product = productUpdate;
            product.update();

            return ok();
   
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    public static Result deleteProduct(Long id){
        try {
            Product product = Product.find.byId(id);
            if(product == null){
                return notFound("Product not exists");
            }
            product.delete();
            return ok();
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
   
}
