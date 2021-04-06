import java.util.ArrayList;

public class ItemP extends Item{

    public ItemP(String nama) {
        super(nama);
        super.arrAksi.add("Deskripsi Item");
        super.arrAksi.add("Buka Item");
    }

    @Override
    public void aksi(int x) {
        if (x==1){
            printDescItem();
        }
        else if (x==2){
            if (objGameInfo.getObjPlayer().searchItem("Kunci")) {
                System.out.println("Selamat pintu telah terbuka!");

                //Permainan selesai
                objGameInfo.setGameOver(true);
            }
            else {
                System.out.println("Pintu terkunci!");
            }
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        return (arrAksi);
    }
}
