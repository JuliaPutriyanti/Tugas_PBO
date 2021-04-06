import java.util.ArrayList;

public class NPC extends Item{

    //NPC menyimpan kunci
    private Item objKunci;

    private GameInfo objGameInfo;
    boolean isKnow = false;

    public NPC(){
        super("NPC");
        objKunci = new Item("Kunci");
        objKunci.setDesc("Kunci besi berkarat");

        super.arrAksi.add("Perkenalan");
        super.arrAksi.add("Meminta item");
    }

    @Override
    public void aksi (int x){
        if(x==1){
            String namaNPC = "Ghirah si penjaga pintu";
            System.out.println("Halo saya "+namaNPC+" salam kenal");
            isKnow = true;
        }
        else if(x==2){
            //Berkenalan
            if(isKnow){
                if(objKunci == null){
                    System.out.println("Kunci sudah diberikan!");
                }
                else{
                    System.out.println("Kunci diberikan pada player!");
                    //Menambahkan kunci pada item player
                    objGameInfo.getObjPlayer().addItem(objKunci);
                    objKunci = null;
                }
            }
            else{
                System.out.println("Kita tidak saling mengenal!");
            }
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

}
