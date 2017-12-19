/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgisayaroneri;

/**
 *
 * @author dilolokko
 */
public class Hesapla {
    model veri;
    int kullanim_puani, alan_puani;
    void kpHesapla(){
        int yas =Integer.parseInt(veri.getYas()),kullanimPuani = 0;
        String kullanim = veri.getKullanim(), hiz = veri.getHız();
        
        //yas puanı hesaplama
        if(yas <= 20){
            kullanimPuani += 15;
        }
        else if(yas <= 40){
            kullanimPuani += 5;
        }
        else{
            kullanimPuani += 5;
        }
        
        //Kullanım puanı hesaplama
        if(kullanim.equals("Çok Fazla")){
            kullanimPuani += 35;
        }
        else if(kullanim.equals("Fazla")){
            kullanimPuani += 25;
        }
        else if(kullanim.equals("Normal")){
            kullanimPuani += 20;
        }
        else if(kullanim.equals("Az")){
            kullanimPuani += 15;
        }
        else{
            kullanimPuani += 5;
        }
        

        //Hızı hesapla
        if(hiz.equals("Çok Hızlı")){
            kullanimPuani += 25;
        }
        else if(hiz.equals("Hızlı")){
            kullanimPuani += 20;
        }
        else if(hiz.equals("Normal")){
            kullanimPuani += 15;
        }
        else if(hiz.equals("Yavaş")){
            kullanimPuani += 10;
        }
        else{
            kullanimPuani += 5;
        }
        
        this.kullanim_puani = kullanimPuani;
    }
    void apHesapla(){
        int yas =Integer.parseInt(veri.getYas()),alanPuani = 0;
        String tur = veri.getTur(), alan = veri.getAlan();
        //yas puanı hesaplama
        if(yas < 20){
            alanPuani += 15;
        }
        else if(yas < 40){
            alanPuani += 10;
        }
        else{
            alanPuani += 5;
        }
        
        //türü hesaplamak için
        if(tur.equals("Masaüstü")){
            alanPuani += 10;
        }
        else{
            alanPuani += 20;
        }
        
        //alan hesaplamak
        if(alan.equals("Kişisel")){
            alanPuani += 0;
        }
        else if(alan.equals("İş")){
            alanPuani += 10;
        }
        else{
            alanPuani += 20;
        }
        
        this.alan_puani = alanPuani;
        
    }
    public String sonuc(model veri){
        this.veri = veri;
        kpHesapla();
        apHesapla();
        int ortalama = (int) ((this.alan_puani*0.4)+(this.kullanim_puani * 0.6));
        
        System.out.println(String.valueOf((this.alan_puani)));
        System.out.println(String.valueOf((this.kullanim_puani)));
        System.out.println(String.valueOf((this.alan_puani*0.4)));
        System.out.println(String.valueOf((this.kullanim_puani * 0.6)));
        System.out.println(String.valueOf(ortalama));
        if(ortalama <=  20){
            return("1500 TL civarındaki bilgisayar uygundur.");
        }
        else if(ortalama <= 30){
            return("2500 TL civarındaki bilgisayar uygundur.");
        }
        else if(ortalama <= 40){
            return("3500 TL civarındaki bilgisayar uygundur.");
        }
        else if(ortalama <= 50){
            return("4500 TL civarındaki bilgisayar uygundur.");
        }
        else{
            return("5500 TL ve üzeri bir bilgisayar uygundur.");
        }
    }
}
