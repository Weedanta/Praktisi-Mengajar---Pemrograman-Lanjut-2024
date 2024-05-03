package Generic;

public class Generic<T, U, V> {
    private T nama;
    private U alamat;
    private V noTeleponT;

    public T getNama() {
        return nama;
    }
    public void setNama(T nama) {
        this.nama = nama;
    }
    public U getAlamat() {
        return alamat;
    }
    public void setAlamat(U alamat) {
        this.alamat = alamat;
    }
    public V getNoTeleponT() {
        return noTeleponT;
    }
    public void setNoTelepon(V noTeleponT) {
        this.noTeleponT = noTeleponT;
    }
    
    public void print(){
        System.out.println("---IDENTITAS----");
        System.out.println("Nama       : " + getNama());
        System.out.println("Alamat     : " + getAlamat());
        System.out.println("No telepon : " + getNoTeleponT());
        System.out.println("------CAW-------");
    }

}
