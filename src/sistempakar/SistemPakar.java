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
    public int infeksiMax[] = new int[6];
    public String infeksiString[] = new String[6];
    
    public SistemPakar() {
    }

    public float mencret(){
        int max = 4;
        float total=0;
        float value=100/max;
        if(gejala[1])total+=value;
        if(gejala[2])total+=value;
        if(gejala[4])total+=value;
        if(gejala[5])total+=value;
        return total;
    }
    
    public float muntah(){
        int max = 3;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[5])total+=value;
        if(gejala[6])total+=value;
        return total;
    }
    
    public float sakit_perut(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[7])total+=value;
        return total;
    }
    
    public float darah_rendah(){
        int max = 3;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[8])total+=value;
        if(gejala[9])total+=value;
        return total;
    }
    
    public float koma(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[8])total+=value;
        if(gejala[10])total+=value;
        return total;
    }
    
    public float demam(){
        int max = 4;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[5])total+=value;
        if(gejala[9])total+=value;
        if(gejala[11])total+=value;
        return total;
    }
    
    public float septicaemia(){
        int max = 4;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[8])total+=value;
        if(gejala[11])total+=value;
        if(gejala[12])total+=value;
        return total;
    }
    
    public float lumpuh(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[4])total+=value;
        if(gejala[13])total+=value;        
        return total;
    }
    
    public float mencret_berdarah(){
        int max = 5;
        float total=0;
        float value=100/max;
        if(gejala[1])total+=value;
        if(gejala[2])total+=value;
        if(gejala[3])total+=value;
        if(gejala[4])total+=value;
        if(gejala[5])total+=value;
        return total;
    }
    
    public float makan_daging(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[14])total+=value;
        if(gejala[15])total+=value;
        return total;
    }
    
    public float makan_jamur(){
        int max = 2;
        float total=0;
        float value=100/2;
        if(gejala[14])total+=value;
        if(gejala[16])total+=value;
        return total;
    }
    
    public float makan_makanan_kaleng(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[14])total+=value;
        if(gejala[17])total+=value;
        return total;
    }
    
    public float minum_susu(){
        int max = 2;
        float total=0;
        float value=100/max;
        if(gejala[8])total+=value;
        if(gejala[19])total+=value;
        return total;
    }
    
    public void inisialisasi(){
        infeksiString[1]="Staphylococcus aureus";
        infeksiString[2]="Jamur Beracun";
        infeksiString[3]="Salmonellae";
        infeksiString[4]="Clostridium botulinum";
        infeksiString[5]="Campylobacter";
        
        infeksiMax[1] = 5;
        infeksiMax[2] = 5;
        infeksiMax[3] = 5;
        infeksiMax[4] = 3;
        infeksiMax[5] = 4;
    }
    
    public void hitung(){
        
        infeksi[1] = (mencret()+muntah()+sakit_perut()+darah_rendah()+makan_daging())/infeksiMax[1];
        infeksi[2] = (mencret()+muntah()+sakit_perut()+koma()+makan_jamur())/infeksiMax[2];
        infeksi[3] = (mencret()+muntah()+sakit_perut()+demam()+septicaemia())/infeksiMax[3];
        infeksi[4] = (muntah()+lumpuh()+makan_makanan_kaleng())/infeksiMax[4];
        infeksi[5] = (mencret_berdarah()+sakit_perut()+demam()+minum_susu())/infeksiMax[5];
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