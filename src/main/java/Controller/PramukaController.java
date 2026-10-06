package Controller;

import java.util.ArrayList;
import Model.AnggotaPramuka;
import Model.Siswa;
import Model.Pembina;
import Model.Kwarran;
import Model.GugusDepan;
import Model.InfoPramuka;

public class PramukaController {
    private final ArrayList<AnggotaPramuka> anggotaPramuka = new ArrayList<>();
    private final ArrayList<GugusDepan> gugusDepan = new ArrayList<>();
    private final ArrayList<Kwarran> kwarran = new ArrayList<>();
    
    public PramukaController() {
        gugusDepan.add(new GugusDepan(1122, "Ki Hajar Dewantara - Dewi Sartika", "SMAN 1 Berau"));
        kwarran.add(new Kwarran(170301, "Tanjung Redeb"));
        anggotaPramuka.add(new Siswa(1001, "Farel Awaluddin", "Laki-Laki", 1122, 170301, "Penegak"));
        anggotaPramuka.add(new Pembina(2001, "Pak Kaspul Anwar", "Laki-Laki", 1122, 170301, "KMD"));
    }
    
    public ArrayList<GugusDepan> getGugusDepanList() {return gugusDepan;}
    public ArrayList<Kwarran> getKwarranList() {return kwarran;}
    public ArrayList<AnggotaPramuka> getAnggotaList() {return anggotaPramuka;}

    // Gugus Depan
    public void tambahGudep(int kodeGugusDepan, String namaGugusDepan, String pangkalan) {
        gugusDepan.add(new GugusDepan(kodeGugusDepan, namaGugusDepan, pangkalan));
    }

    public boolean updateGudep(int kodeGugusDepan, String namaGugusDepanBaru, String pangkalanBaru) {
        for (GugusDepan gugusDepanObjek : gugusDepan) {
            if (gugusDepanObjek.getKodeGugusDepan() == kodeGugusDepan) {
                gugusDepanObjek.setNamaGugusDepan(namaGugusDepanBaru);
                gugusDepanObjek.setPangkalan(pangkalanBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusGudep(int kodeGugusDepan) {
        for (int i = 0; i < gugusDepan.size(); i++) {
            if (gugusDepan.get(i).getKodeGugusDepan() == kodeGugusDepan) {
                gugusDepan.remove(i);
                return true;
            }
        }
        return false;
    }

    // Kwartir Ranting
    public void tambahKwarran(int idKwarran, String namaKwarran) {
        kwarran.add(new Kwarran(idKwarran, namaKwarran));
    }

    public boolean updateKwarran(int idKwarran, String namaKwarranBaru) {
        for (Kwarran kwarranObjek : kwarran) {
            if (kwarranObjek.getIdKwarran() == idKwarran) {
                kwarranObjek.setNamaKwarran(namaKwarranBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusKwarran(int idKwarran) {
        for (int i = 0; i < kwarran.size(); i++) {
            if (kwarran.get(i).getIdKwarran() == idKwarran) {
                kwarran.remove(i);
                return true;
            }
        }
        return false;
    }

    // Anggota Pramuka
    public void tambahSiswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        anggotaPramuka.add(new Siswa(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, tingkatPramuka));
    }

    public void tambahPembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina) {
        anggotaPramuka.add(new Pembina(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, hakBina));
    }

    public boolean updateAnggota(int idAnggota, String namaAnggotaBaru, String jenisKelaminBaru, int kodeGugusDepanBaru, int idKwarranBaru, String atributKhususBaru) {
        for (AnggotaPramuka anggota : anggotaPramuka) {
            if (anggota.getIdAnggota() == idAnggota) {
                anggota.setNamaAnggota(namaAnggotaBaru);
                anggota.setJenisKelamin(jenisKelaminBaru);
                anggota.setKodeGugusDepan(kodeGugusDepanBaru);
                anggota.setIdKwarran(idKwarranBaru);

                if (anggota instanceof Siswa) {
                    ((InfoPramuka) anggota).dataAnggota();
                    ((Siswa) anggota).setTingkatPramuka(atributKhususBaru);
                } else if (anggota instanceof Pembina) {
                    ((InfoPramuka) anggota).dataAnggota();
                    ((Pembina) anggota).setHakBina(atributKhususBaru);
                }
                return true;
            }
        }
        return false;
    }

    public boolean hapusAnggota(int idAnggota) {
        for (int i = 0; i < anggotaPramuka.size(); i++) {
            if (anggotaPramuka.get(i).getIdAnggota() == idAnggota) {
                anggotaPramuka.remove(i);
                return true;
            }
        }
        return false;
    }
}