import java.util.ArrayList;

public class Item {

    //Menyimpan nama item
    private final String namaItem;

    //Menyimpan deskripsi item
    private String descItem;

    //Set ruangan dan game info
    private Ruangan objRuangan;
    protected GameInfo objGameInfo;

    ArrayList<String> arrAksi = new ArrayList<>();

    //Constructor
    public Item (String nama){
        this.namaItem = nama;
    }

    public void setDesc (String desc){
        this.descItem = desc;
    }

    //Prosedur untuk mencetak deskripsi item
    public void printDescItem(){
        System.out.println(descItem);
    }

    //Membuang item
    private void thrown() {
        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().deleteItem(this); //hapus dari player
        objGameInfo.getObjRuangan().addItem(this);  //tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan(); // set ruangan
    }

    //Mengambil item
    private void take() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.deleteItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }

    //Aksi yang dilakukan player
    public void aksi (int x){
        if (x==1){
            printDescItem();
        }
        else if (x==2){
            if(objRuangan==null){
                thrown();
            }
            else{
                take();
            }
        }
    }

    //Menyimpan tulisan aksi ke dalam array secara dinamis
    public ArrayList<String> getAksi(){
        ArrayList<String> arrOut = new ArrayList<>();
        if(objRuangan == null){
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        }
        else{
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return (arrOut);
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }
}
