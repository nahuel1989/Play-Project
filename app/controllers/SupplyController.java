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


public class SupplyController extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addSupply(){
        try {
            JsonNode json = request().body().asJson();
            Supply supply = Json.fromJson(json, Supply.class);
            if(supply.toString().equals("")){
                return badRequest("Missing parameter");
            }
            supply.save();
            return ok();
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    } 
    
    public static Result listSupply(){
        try {
            List<Supply> supplys = new Model.Finder(String.class,Supply.class).all();
            return ok(toJson(supplys));
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    public static Result getSupply(Long id){
        try {
            Supply supply = Supply.find.byId(id);
            if(supply == null){
                return notFound("Supply not exists");
            }
            return ok(toJson(supply));
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    
    @BodyParser.Of(BodyParser.Json.class)
    public static Result updateSupply(Long id){
        try {
            Supply supply = Supply.find.byId(id);
            if(supply == null){
                return notFound("Supply not exists");
            }

            JsonNode json = request().body().asJson();
            supply = Json.fromJson(json, Supply.class);
            supply.update();
            return ok();
   
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
    
    public static Result deleteSupply(Long id){
        try {
            Supply supply = Supply.find.byId(id);
            if(supply == null){
                return notFound("Supply not exists");
            }
            supply.delete();
            return ok();
        } catch (Exception e) {
            return internalServerError("Ocurrió un error");
        }
    }
   
}
