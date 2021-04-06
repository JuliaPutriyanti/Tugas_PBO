import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan{
    Scanner in = new Scanner(System.in);

    //Membuat array untuk item di dalam ruangan
    private final ArrayList<Item> arrObj = new ArrayList<>();

    private NPC objNPC;

    public Ruangan(){
        //Insiasi item
        ItemFood objRoti = new ItemFood("Roti");
        objRoti.setDesc("Roti rasa coklat sedikit berjamur");
        arrObj.add(objRoti);

        ItemP objPintu = new ItemP("Pintu");
        objPintu.setDesc("Pintu berwarna merah dengan tulisan exit");
        arrObj.add(objPintu);

        objNPC = new NPC();
        arrObj.add(objNPC);
    }

    //Prosedur untuk menambahkan item pada array item ruangan
    public void addItem (Item objItem){
        arrObj.add(objItem);
    }

    //Prosedur untuk menghapus item dari array item ruangan
    public void deleteItem (Item objItem){
        arrObj.remove(objItem);
    }

    //Aksi yang bisa dilakukan dalam ruangan
    public void aksiRuangan(){
        System.out.println("=========================");
        System.out.println("          RUANGAN        ");
        System.out.println("=========================");
        System.out.println("AKSI RUANGAN: ");

        int x =0, y;
        //Menampilkan item dan pintu menggunakan polymorphism
        for (Item objObj:arrObj){
            //Melakukan penomoran
            x++; y=0;
            System.out.println(objObj.getNamaItem());

            //Mengambil aksi yang bisa dilakukan Item
            ArrayList<String> arrAksi = objObj.getAksi();

            for(String strAksi:arrAksi){
                y++;
                System.out.printf("%d%d. %s\n", x, y, strAksi);
            }
        }

        System.out.println("\n00. Kembali\n");

        System.out.print("Pilih Aksi: ");
        String strAksi = in.next();

        int n = Integer.parseInt(strAksi.substring(0,1));
        y = Integer.parseInt(strAksi.substring(1,2));

        if(n==0){
            System.out.println();
        }
        else{
            arrObj.get(n-1).aksi(y);
        }
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrObj) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    //Fungsi untuk mencari item dari array item ruangan
    public boolean searchItem (String nama){
        for(Item objItem:arrObj){

            //Jika item yang dicari sama dengan salah satu item dari array item player maka kondisi terpenuhi
            if(objItem.getNamaItem().equals(nama)){
                return (true);
            }
        }
        //Jika tidak maka kondisi tidak terpenuhi atau item tidak ada
        return (false);
    }
}
