/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistempakar;

/**
 *
 * @author irvan
 */
public class SistemPakar {
  
    public boolean gejala[] = new boolean[25];
    public int threshold=0;
    public float infeksi[] = new float[6];
    public String infeksiString[] = new String[6];
    
    public SistemPakar() {
    }

    public float mencret(){
        float total=0;
        float value=25;
        if(gejala[1]==true)total+=value;
        if(gejala[2]==true)total+=value;
        if(gejala[4]==true)total+=value;
        if(gejala[5]==true) total+=value;
        return total;
    }
    
    public float muntah(){
        float total=0;
        float value=(float)33.333333333;
        if (gejala[4]==true)total+=value;
        if(gejala[5]==true)total+=value;
        if(gejala[6]==true) total+=value;
        return total;
    }
    
    public float sakit_perut(){
        float total=0;
        float value=50;
        if(gejala[4]==true)total+=value;
        if(gejala[7]==true)total+=value;
        return total;
    }
    
    public float darah_rendah(){
        float total=0;
        float value=(float) 33.333333333;
        if(gejala[4]==true)total+=value;
        if(gejala[8]==true)total+=value;
        if(gejala[9]==true)total+=value;
        return total;
    }
    
    public float koma(){
        float total=0;
        float value=50;
        if(gejala[8]==true)total+=value;
        if(gejala[10]==true)total+=value;
        return total;
    }
    
    public float demam(){
        float total=0;
        float value=25;
        if(gejala[4]==true)total+=value;
        if(gejala[5]==true)total+=value;
        if(gejala[9]==true)total+=value;
        if(gejala[11]==true)total+=value;
        return total;
    }
    
    public float septicaemia(){
        float total=0;
        float value=25;
        if(gejala[4]==true)total+=value;
        if(gejala[8]==true)total+=value;
        if(gejala[11]==true)total+=value;
        if(gejala[12]==true)total+=value;
        return total;
    }
    
    public float lumpuh(){
        float total=0;
        float value=50;
        if(gejala[4]==true)total+=value;
        if(gejala[13]==true)total+=value;        
        return total;
    }
    
    public float mencret_berdarah(){
        float total=0;
        float value=20;
        if(gejala[1]==true)total+=value;
        if(gejala[2]==true)total+=value;
        if(gejala[3]==true)total+=value;
        if(gejala[4]==true)total+=value;
        if(gejala[5]==true)total+=value;
        return total;
    }
    
    public float makan_daging(){
        float total=0;
        float value=50;
        if(gejala[14]==true)total+=value;
        if(gejala[15]==true)total+=value;
        return total;
    }
    
    public float makan_jamur(){
        float total=0;
        float value=50;
        if(gejala[14]==true)total+=value;
        if(gejala[16]==true)total+=value;
        return total;
    }
    
    public float makan_makanan_kaleng(){
        float total=0;
        float value=50;
        if(gejala[14]==true)total+=value;
        if(gejala[17]==true)total+=value;
        return total;
    }
    
    public float minum_susu(){
        float total=0;
        float value=50;
        if(gejala[8]==true)total+=value;
        if(gejala[19]==true)total+=value;
        return total;
    }
    
    
    public void hitung(){
        infeksiString[1]="Staphylococcus aureus";
        infeksiString[2]="Jamur Beracun";
        infeksiString[3]="Salmonellae";
        infeksiString[4]="Clostridium botulinum";
        infeksiString[5]="Campylobacter";
        infeksi[1] = (mencret()+muntah()+sakit_perut()+darah_rendah()+makan_daging())/5;
        infeksi[2] = (mencret()+muntah()+sakit_perut()+koma()+makan_jamur())/5;
        infeksi[3] = (mencret()+muntah()+sakit_perut()+demam()+septicaemia())/5;
        infeksi[4] = (muntah()+lumpuh()+makan_makanan_kaleng())/3;
        infeksi[5] = (mencret_berdarah()+sakit_perut()+demam()+minum_susu())/4;
    }
    
    public String getHasil(){
        String string;
        string = infeksiString[1]+" : "+String.format("%.3f", infeksi[1])+"% \n"
                + infeksiString[2]+" : "+String.format("%.3f", infeksi[2])+"% \n"
                + infeksiString[3]+" : "+String.format("%.3f", infeksi[3])+"% \n"
                + infeksiString[4]+" : "+String.format("%.3f", infeksi[4])+"% \n"
                + infeksiString[5]+" : "+String.format("%.3f", infeksi[5])+"% \n";
        return string;
    }
    
    public String diagnosa(){
        String string="";
        float terbesar=0;
        for(int i=1; i<=5;i++){
            if(terbesar<infeksi[i]){
                terbesar=infeksi[i];
                string= infeksiString[i];
            }
        }
        
        if(threshold>terbesar)string="tidak ada infeksi";
        return string;
    }

}