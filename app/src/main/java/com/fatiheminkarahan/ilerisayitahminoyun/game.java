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





        Random random = new Random();
        int randomNumber = random.nextInt((9999 - 100) + 1) + 10;
        sonucMetinKutusu.setText("Hi" + randomNumber);

        int rbir, ron, ryüz, rbin, deneme;

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
                int gsayi;
                String yazilacakSayi = metinKutusu.getText().toString();
                gsayi = Integer.valueOf(metinKutusu.getText().toString());

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



                if(rbir == gbir && ron == gon && ryüz ==gyüz && rbin ==gbin){
                    sonucMetinKutusu.setText("Doğru sayıyı buldunuz ");

                }

                else if(rbir == gbir && ron != gon && ryüz !=gyüz && rbin !=gbin){
                    yazi.add("+1 ");
                }
                else if(rbir != gbir  && ron == gon  && ryüz !=gyüz && rbin !=gbin){
                    yazi.add("+1 ");
                }
                else if(rbir != gbir&& ron != gon && ryüz ==gyüz && rbin !=gbin){
                    yazi.add("+1 ");
                }
                else if( ron != gon && ryüz !=gyüz && rbir != gbir && rbin == gbin){
                    yazi.add("+1 ");
                }
                else{
                    for(int i =0 ; i<4; i++){
                        for(int j=0; j<4; j++){
                            if(listGirilen.get(i) == listRandom.get(j)){
                                yazi.add("-1 ");
                            }
                        }
                    }
                }


                String denemeyazi = "";

                for(int i = 0; i< yazi.size(); i++){
                    denemeyazi += " " + yazi.get(i);
                }
                sonucMetinKutusu.setText(yazilacakSayi + denemeyazi);






            }
        });


    }
}