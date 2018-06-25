
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guru
 */
import java.util.*;

public class password {

    public boolean password(String k, String v) {
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("jai", "12345");
        h.put("zoho", "12345");
        if (h.containsKey(k) && h.get(k).equals(v)) {
            return true;
        }
        return false;
    }
}
