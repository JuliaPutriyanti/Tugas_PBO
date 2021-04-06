public class GameInfo {
    private Boolean isGameOver = false;
    private Player objPlayer;
    private Ruangan objRuangan;

    //Mengakses objek yang terdapat di ruangan
    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    //Menyimpan objek yang terdapat di ruangan
    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    //Mengakses objek yang terdapat di player
    public Player getObjPlayer() {
        return objPlayer;
    }

    //Menyimpan objek yang terdapat di player
    public void setObjPlayer(Player objPlayer) {
        this.objPlayer = objPlayer;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }
}
