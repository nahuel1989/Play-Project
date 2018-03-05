/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

/**
 *
 * @author nahue
 */
/*
*/

public class Util {
    public static ObjectNode createResponse(
      Object response, boolean ok) {
         
        ObjectNode result = Json.newObject();
        result.put("isSuccessfull", ok);
        if (response instanceof String) {
            result.put("body", (String) response);
        }
        else {
            result.put("body", (JsonNode) response);
        }
 
        return result;
    }
}
