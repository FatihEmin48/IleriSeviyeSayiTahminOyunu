package com.fatiheminkarahan.ilerisayitahminoyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game extends AppCompatActivity {

    private Button geribttn;
    private Button kontrolbtn;
    EditText metinKutusu;
    TextView sonucMetinKutusu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        metinKutusu  = (EditText) findViewById(R.id.metinKutusu);
        sonucMetinKutusu = (TextView) findViewById(R.id.textViewsonuc);

        geribttn = (Button)findViewById(R.id.buttongeri);

        geribttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(game.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        int rbir, ron, ryüz, rbin, rNum;
        int randomNumber = rastgele();

        if(randomNumber<1000 || randomNumber>9999){
            randomNumber = rastgele();
            rbir = randomNumber%10;
            randomNumber/=10;
            ron = randomNumber%10;
            randomNumber/=10;
            ryüz = randomNumber%10;
            randomNumber/=10;
            rbin = randomNumber%10;

            if(rbir == ron || rbir == ryüz|| rbir == rbin || ron == ryüz|| ron == rbin || ryüz == rbin){
                randomNumber = rastgele();
            }

        }
        sonucMetinKutusu.setText("Hi " + randomNumber);



        rNum = randomNumber;
        rbir = randomNumber%10;
        randomNumber/=10;
        ron = randomNumber%10;
        randomNumber/=10;
        ryüz = randomNumber%10;
        randomNumber/=10;
        rbin = randomNumber%10;
        List<Integer> listRandom =new ArrayList<Integer>();
        listRandom.add(rbin);
        listRandom.add(ryüz);
        listRandom.add(ron);
        listRandom.add(rbir);









        kontrolbtn = (Button)findViewById(R.id.buttonKontol);

        kontrolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gsayi, gNum;
                String yazilacakSayi = metinKutusu.getText().toString();
                gsayi = Integer.valueOf(metinKutusu.getText().toString());
                gNum = gsayi;

                metinKutusu.getText().clear();


                int gbir, gon, gyüz, gbin;

                gbir = gsayi%10;
                gsayi/=10;
                gon = gsayi%10;
                gsayi/=10;
                gyüz = gsayi%10;
                gsayi/=10;
                gbin = gsayi%10;

                List<Integer> listGirilen =new ArrayList<Integer>();
                listGirilen.add(gbin);
                listGirilen.add(gyüz);
                listGirilen.add(gon);
                listGirilen.add(gbir);

                List<String> yazi =new ArrayList<String>();

                String ciktiYazisi = "";



                if(gNum == rNum){
                    ciktiYazisi +="Doğru sayıyı buldunuz ";
                }
                else {
                    ciktiYazisi += "Sayınız: ";
                    ciktiYazisi += yazilacakSayi;

                    int arti=0, eksi=0;



                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if(listGirilen.get(i) == listRandom.get(j)){
                                if(i == j){
                                    arti += 1;
                                }
                                else{
                                    eksi +=1;
                                }


                            }


                        }
                    }

                    ciktiYazisi += "+" + arti + "-"+ eksi;

                }
                sonucMetinKutusu.setText(ciktiYazisi);

            }
        });


    }

    static int rastgele(){
        Random random = new Random();

        int randomNumber= random.nextInt(9000 ) + 1000;
        String ransomNumberS = String.valueOf(randomNumber);
        for(int i = 0; i<4;i++){
            for(int j =i+1; j<4;j++){
                if(ransomNumberS.charAt(i)== ransomNumberS.charAt(j)){
                    randomNumber = rastgele();

                }
            }
        }
        return randomNumber;


    }
}