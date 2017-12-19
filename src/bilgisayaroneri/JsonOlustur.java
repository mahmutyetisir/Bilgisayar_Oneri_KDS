/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgisayaroneri;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author dilolokko
 */
public class JsonOlustur {
    List<model> veriler;
    JsonOlustur(List<model> veriler, String[] sonuclar) {
        try{
            JSONObject kok = new JSONObject();
            JSONArray list = new JSONArray();
            int i = 0;
            for(model veri : veriler){
                JSONObject obj = new JSONObject();
                obj.put("Yas", veri.getYas());
                obj.put("Tür", veri.getTur());
                obj.put("Kullanım", veri.getKullanim());
                obj.put("Hız", veri.getHız());
                obj.put("Alan", veri.getAlan());
                obj.put("Sonuc", sonuclar[i]);
                i++;
                System.out.println(obj);
                list.put(obj);
            }
            kok.put("Veriler", list);
            System.out.println(list);
            System.out.println(kok);
            try (FileWriter file = new FileWriter("/home/"+new com.sun.security.auth.module.UnixSystem().getUsername().toString()+"/Desktop/Veriler.json")) {
                file.write(kok.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
