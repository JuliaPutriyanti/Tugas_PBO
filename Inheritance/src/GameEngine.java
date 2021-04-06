import java.util.Scanner;

public class GameEngine {
    Scanner in = new Scanner(System.in);
    Player objPlayer = new Player();
    Ruangan objRuangan = new Ruangan();
    GameInfo objGameInfo = new GameInfo();

    //Constructor
    public GameEngine() {
        //init ruangannya
        objRuangan.setObjGameInfo(objGameInfo);
        objPlayer.setRuanganAktif(objRuangan);  //set ruangan aktif player
        objPlayer.setObjGameInfo(objGameInfo);

        objGameInfo.setObjPlayer(objPlayer);
        objGameInfo.setObjRuangan(objRuangan);
    }

    private void aksi() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("    LOCKED ROOM GAME     ");
        System.out.println("=========================");
        System.out.println("1. Aksi di ruangan");
        System.out.println("2. Aksi player");
        System.out.println("3. Keluar");
        System.out.println("=========================");
        System.out.print("Pilih Aksi: ");
        int pil = in.nextInt();
        System.out.println("--");
        if (pil==3) {
            objGameInfo.setGameOver(true); //keluar
        } else if (pil==1) {
            objRuangan.aksiRuangan(); //
        } else if (pil==2) {
            objPlayer.aksiPlayer();
        }
    }

    public void mulai() {
        while (!objGameInfo.getGameOver()) {
            aksi();
        }
    }

    public static void main(String[] args) {
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        objGameEngine.mulai();
    }
}