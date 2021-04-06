import java.util.ArrayList;

public class ItemFood extends Item{

    public ItemFood(String nama) {
        super(nama);

        super.arrAksi.add("Deskripsi Item");
        super.arrAksi.add("Makan Item");
    }

    private void eat(){
        objGameInfo.getObjRuangan().deleteItem(this);
        objGameInfo.getObjPlayer().health=0;
    }

    @Override
    public void aksi(int x){
        if(x==1){
            printDescItem();
        }
        else if(x==2){
            //Jika roti terdapat di ruangan maka bisa dimakan
            if(objGameInfo.getObjRuangan().searchItem("Roti")){
                System.out.println("Roti beracun!\nAnda gagal dalam permainan!");
                eat();
                if(objGameInfo.getObjPlayer().health==0){
                    objGameInfo.setGameOver(true);
                }
            }
        }
    }

    @Override
    public ArrayList<String> getAksi(){
        return (arrAksi);
    }

}
