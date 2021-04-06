import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);

    //Array barang yang dimiliki player
    private final ArrayList<Item> arrItem = new ArrayList<>();

    //Barang default player
    private final Item objCincin;

    public int health = 100;
    private Ruangan ruanganAktif;

    //Constructor
    public Player(){
        //Menambahkan item cincin pada array item player
        objCincin = new Item ("Cincin Emas");
        objCincin.setDesc("Cincin emas dengan ukiran nama!");
        arrItem.add(objCincin);
    }

    //Prosedur untuk menambahkan item pada array item player
    public void addItem (Item objItem){
        arrItem.add(objItem);
    }

    //Prosedur untuk menghapus item dari array item player
    public void deleteItem (Item objItem){
        arrItem.remove(objItem);
    }

    //Fungsi untuk mencari item dari array item player
    public boolean searchItem (String nama){
        for(Item objItem:arrItem){

            //Jika item yang dicari sama dengan salah satu item dari array item player maka kondisi terpenuhi
            if(objItem.getNamaItem().equals(nama)){
                return (true);
            }
        }
        //Jika tidak maka kondisi tidak terpenuhi atau item tidak ada
        return (false);
    }

    //Prosedur untuk mencetak nama dan stats player
    public void printInfoPlayer(){
        System.out.println("=========================");
        System.out.println("        PLAYER INFO      ");
        System.out.println("=========================");
        //Nama dan Status Player
        String namaPlayer = "Julia";
        System.out.println("Nama\t: "+ namaPlayer);
        System.out.println("Health\t: "+ health);
        System.out.println("=========================");
    }

    public void aksiPlayer(){
        int x=0, y;

        printInfoPlayer();
        System.out.println("ITEM PLAYER:");

        for(Item objItem:arrItem){
            //Melakukan penomoran
            x++; y=0;
            System.out.println(objItem.getNamaItem());

            //Mengambil aksi yang bisa dilakukan Item
            ArrayList<String> arrAksi = objItem.getAksi();

            for(String strAksi:arrAksi){
                y++;
                System.out.printf("%d%d. %s\n", x, y, strAksi);
            }
        }

        System.out.println("\n00. Kembali\n");

        //Memilih menu
        System.out.print("Pilih Aksi: ");
        String strAksi = in.next();

        int n = Integer.parseInt(strAksi.substring(0,1));
        y = Integer.parseInt(strAksi.substring(1,2));

        if(n==0){
            System.out.println();
        }
        else{
            Item objPilih = arrItem.get(n-1);
            objPilih.aksi(y);
        }
    }

    //Set Objek Cincin ke Game Info
    public void setObjGameInfo (GameInfo objGameInfo) {
        objCincin.setObjGameInfo(objGameInfo);
    }

    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
}
