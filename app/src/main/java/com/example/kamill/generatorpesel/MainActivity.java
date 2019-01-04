package com.example.kamill.generatorpesel;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText rok;
    private EditText pesel;
    private String PESEL;
    private Boolean przestepny;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rok = findViewById(R.id.rok_urodzenia_EditText);
        pesel = findViewById(R.id.pesel_editText);
        przestepny = false;



    }

    public void generuj_pesel(View v){
        String rok_urodzenia = rok.getText().toString();
        if(TextUtils.isEmpty(rok_urodzenia)){
            Toast.makeText(getApplicationContext(), "Wpisz rok urodzenia", Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(rok_urodzenia)<1800 || Integer.parseInt(rok_urodzenia)>2299){
            Toast.makeText(getApplicationContext(), "Podaj datę w przedziale 1800-2099", Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(rok_urodzenia)<=1899) {
           //lata 1800-1899
            if ((Integer.parseInt(rok_urodzenia) % 4 == 0 && Integer.parseInt(rok_urodzenia) % 100 != 0) || Integer.parseInt(rok_urodzenia) % 400 == 0) {
                przestepny = true;
            }
            int first = rok_urodzenia.charAt(2) - '0';
            int second = rok_urodzenia.charAt(3) - '0';
            Random rand = new Random();
            int third_and_fourth = rand.nextInt(92 - 81 + 1) + 81;
            int fifth_and_sixth = 0;
            String fifth_and_sixth_s;
            if (third_and_fourth == 81 || third_and_fourth == 83 || third_and_fourth == 85 || third_and_fourth == 87 || third_and_fourth == 88 || third_and_fourth == 90 || third_and_fourth == 92) {
                fifth_and_sixth = rand.nextInt(31 - 1 + 1) + 1;
            } else {
                if (przestepny == true) {
                    if (third_and_fourth == 82) {
                        fifth_and_sixth = rand.nextInt(29 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                } else {
                    if (third_and_fourth == 82) {
                        fifth_and_sixth = rand.nextInt(28 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                }
            }

                if(fifth_and_sixth <10){
                   fifth_and_sixth_s = Integer.parseInt("0")+Integer.toString(fifth_and_sixth);
                }else{
                    fifth_and_sixth_s = String.valueOf(fifth_and_sixth);
                }
                int four_next = rand.nextInt( 9999 - 1000 + 1) + 1000;

                int trzecia_int = Integer.toString(third_and_fourth).charAt(0) - '0';
                String third = String.valueOf(trzecia_int);

                int czwarta_int = Integer.toString(third_and_fourth).charAt(1) - '0';
                String fourth = String.valueOf(czwarta_int);

                int piata_int = fifth_and_sixth_s.charAt(0) - '0';
                String fifth = String.valueOf(piata_int);

                int szosta_int = fifth_and_sixth_s.charAt(1) - '0';
                String sixth = String.valueOf(szosta_int);

                int siodma_int = Integer.toString(four_next).charAt(0) - '0';
                String seventh = String.valueOf(siodma_int);

                int osma_int = Integer.toString(four_next).charAt(1) - '0';
                String eight = String.valueOf(osma_int);

                int dziewiata_int = Integer.toString(four_next).charAt(2) - '0';
                String nineth = String.valueOf(dziewiata_int);

                int dziesiata_int = Integer.toString(four_next).charAt(3) - '0';
                String tenth = String.valueOf(dziesiata_int);



            int suma = 9*first + 7*second + 3*trzecia_int + czwarta_int + 9*piata_int + 7*szosta_int
                    + 3*siodma_int + osma_int + 9*dziewiata_int + 7*dziesiata_int;
            int eleventh = suma%10;
            PESEL =Integer.toString(first)+Integer.toString(second)+third+fourth+fifth+sixth+seventh+eight+nineth+tenth+eleventh;
            } else if(Integer.parseInt(rok_urodzenia)>1999 && Integer.parseInt(rok_urodzenia)<=2099){
            //lata 2000-2099
            if ((Integer.parseInt(rok_urodzenia) % 4 == 0 && Integer.parseInt(rok_urodzenia) % 100 != 0) || Integer.parseInt(rok_urodzenia) % 400 == 0) {
                przestepny = true;
            }
            int first = rok_urodzenia.charAt(2) - '0';
            int second = rok_urodzenia.charAt(3) - '0';
            Random rand = new Random();
            int third_and_fourth = rand.nextInt(32 - 21 + 1) + 21;
            int fifth_and_sixth = 0;
            String fifth_and_sixth_s;
            if (third_and_fourth == 21 || third_and_fourth == 23 || third_and_fourth == 25 || third_and_fourth == 27 || third_and_fourth == 28 || third_and_fourth == 30 || third_and_fourth == 32) {
                fifth_and_sixth = rand.nextInt(31 - 1 + 1) + 1;
            } else {
                if (przestepny == true) {
                    if (third_and_fourth == 22) {
                        fifth_and_sixth = rand.nextInt(29 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                } else {
                    if (third_and_fourth == 22) {
                        fifth_and_sixth = rand.nextInt(28 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                }
            }

            if(fifth_and_sixth <10){
                fifth_and_sixth_s = Integer.parseInt("0")+Integer.toString(fifth_and_sixth);
            }else{
                fifth_and_sixth_s = String.valueOf(fifth_and_sixth);
            }
            int four_next = rand.nextInt( 9999 - 1000 + 1) + 1000;

            int trzecia_int = Integer.toString(third_and_fourth).charAt(0) - '0';
            String third = String.valueOf(trzecia_int);

            int czwarta_int = Integer.toString(third_and_fourth).charAt(1) - '0';
            String fourth = String.valueOf(czwarta_int);

            int piata_int = fifth_and_sixth_s.charAt(0) - '0';
            String fifth = String.valueOf(piata_int);

            int szosta_int = fifth_and_sixth_s.charAt(1) - '0';
            String sixth = String.valueOf(szosta_int);

            int siodma_int = Integer.toString(four_next).charAt(0) - '0';
            String seventh = String.valueOf(siodma_int);

            int osma_int = Integer.toString(four_next).charAt(1) - '0';
            String eight = String.valueOf(osma_int);

            int dziewiata_int = Integer.toString(four_next).charAt(2) - '0';
            String nineth = String.valueOf(dziewiata_int);

            int dziesiata_int = Integer.toString(four_next).charAt(3) - '0';
            String tenth = String.valueOf(dziesiata_int);



            int suma = 9*first + 7*second + 3*trzecia_int + czwarta_int + 9*piata_int + 7*szosta_int
                    + 3*siodma_int + osma_int + 9*dziewiata_int + 7*dziesiata_int;
             int eleventh = suma%10;
            PESEL =Integer.toString(first)+Integer.toString(second)+third+fourth+fifth+sixth+seventh+eight+nineth+tenth+eleventh;



            }else if(Integer.parseInt(rok_urodzenia) >= 1900 && Integer.parseInt(rok_urodzenia)<=1999){
            //lata 1900-1999
            if ((Integer.parseInt(rok_urodzenia) % 4 == 0 && Integer.parseInt(rok_urodzenia) % 100 != 0) || Integer.parseInt(rok_urodzenia) % 400 == 0) {
                przestepny = true;
            }
            int first = rok_urodzenia.charAt(2) - '0';
            int second = rok_urodzenia.charAt(3) - '0';
            Random rand = new Random();
            int third_and_fourth = rand.nextInt(12 - 1 + 1) + 1;
            String third_and_fourth_s = String.valueOf(third_and_fourth);
            if(third_and_fourth<10) {
                third_and_fourth_s = "0" + String.valueOf(third_and_fourth);
            }
            int fifth_and_sixth = 0;
            String fifth_and_sixth_s;
            if (third_and_fourth_s.equals("01") || third_and_fourth_s.equals("03") || third_and_fourth_s.equals("05") || third_and_fourth_s.equals("07") || third_and_fourth_s.equals("08") || third_and_fourth_s.equals("10") || third_and_fourth_s.equals("12")) {
                fifth_and_sixth = rand.nextInt(31 - 1 + 1) + 1;
            } else {
                if (przestepny == true) {
                    if (third_and_fourth_s.equals("02")) {
                        fifth_and_sixth = rand.nextInt(29 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                } else {
                    if (third_and_fourth_s.equals("02")) {
                        fifth_and_sixth = rand.nextInt(28 - 1 + 1) + 1;
                    } else {
                        fifth_and_sixth = rand.nextInt(30 - 1 + 1) + 1;
                    }
                }
            }

            if(fifth_and_sixth <10){
                fifth_and_sixth_s = Integer.parseInt("0")+Integer.toString(fifth_and_sixth);
            }else{
                fifth_and_sixth_s = String.valueOf(fifth_and_sixth);
            }
            int four_next = rand.nextInt( 9999 - 1000 + 1) + 1000;

            int trzecia_int = third_and_fourth_s.charAt(0) - '0';
            String third = String.valueOf(trzecia_int);

            int czwarta_int = third_and_fourth_s.charAt(1) - '0';
            String fourth = String.valueOf(czwarta_int);

            int piata_int = fifth_and_sixth_s.charAt(0) - '0';
            String fifth = String.valueOf(piata_int);

            int szosta_int = fifth_and_sixth_s.charAt(1) - '0';
            String sixth = String.valueOf(szosta_int);

            int siodma_int = Integer.toString(four_next).charAt(0) - '0';
            String seventh = String.valueOf(siodma_int);

            int osma_int = Integer.toString(four_next).charAt(1) - '0';
            String eight = String.valueOf(osma_int);

            int dziewiata_int = Integer.toString(four_next).charAt(2) - '0';
            String nineth = String.valueOf(dziewiata_int);

            int dziesiata_int = Integer.toString(four_next).charAt(3) - '0';
            String tenth = String.valueOf(dziesiata_int);



            int suma = 9*first + 7*second + 3*trzecia_int + czwarta_int + 9*piata_int + 7*szosta_int
                    + 3*siodma_int + osma_int + 9*dziewiata_int + 7*dziesiata_int;
            int eleventh = suma%10;
            PESEL =Integer.toString(first)+Integer.toString(second)+third+fourth+fifth+sixth+seventh+eight+nineth+tenth+eleventh;

        }

            pesel.setText(PESEL);
        }



        //kopiowanie peselu
    public void kopiuj(View v){
        Toast.makeText(getApplicationContext(), "Skopiowano", Toast.LENGTH_SHORT).show();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Skopiowany pesel",pesel.getText().toString());
        clipboard.setPrimaryClip(clip);
    }


    }



