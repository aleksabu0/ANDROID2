package com.example.studentskasluzba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button but1;
    Button butAddStudent;
    Button butAddPredmet;

    Button butStudentList;
    Button butEnter2;
    Button butEnter3;
    Button butSearch;
    Button butEnter;
    Button butEnterPrStud;
    Button enterStudent;
    Button butNazad;
    int brojKat;
    String selectedStudent="";
    String izabraniKorisnik;
    Button dodajPredmet;
    Button obrisiStudenta;
    Button spisakPolozenih;
    Button spisakNepolozenih;
    Button nazaduListu;

    Button sveOcene;

    Button predKategorije;

    Button studentiPolozili;

    Button studentiSlusaju;

    Button studentiPoloziliSacOcenom;

    Button butGodine;

    Button nazadStudent;

    Button spisakPredmeta;

    Button nazadListaPredmeta;

    Button butOcenaFiltar;
    Button nazadGodina;

    Button nazadPredmeti;

    Button errorClose;

    Button nazadPredmetiOpcije;

    Button novaGodina;
    //TextView studentList;
    TextView textAll;

    TextView studentImePrezime;

    TextView textKategorije;

    TextView errorPopup;

    TextInputEditText userText;

    TextInputEditText textOcenaFiltar;
    EditText passText;
    TextInputEditText roleText;

    TextInputEditText txpredmet;
    TextInputEditText txgodina;
    TextInputEditText txbrojKat;



    TextInputEditText k1;
    TextInputEditText k1min;
    TextInputEditText k1max;
    TextInputEditText k2;

    TextInputEditText osv1;
    TextInputEditText osv2;
    TextInputEditText osv3;
    TextInputEditText osv4;
    TextInputEditText osv5;
    TextInputEditText k2min;
    TextInputEditText k2max;
    TextInputEditText k3;
    TextInputEditText k3min;
    TextInputEditText k3max;
    TextInputEditText k4;
    TextInputEditText k4min;
    TextInputEditText k4max;
    TextInputEditText k5;
    TextInputEditText k5min;
    TextInputEditText k5max;

    ListView listStudenti;

    ListView listSveOcene;

    ListView listPredmeti;

    ListView listGodine;

    ListView listPolozeniPredmeti;

    ListView listNepolozeniPredmeti;

    ListView listStudentiSlusaju;
    ListView listStudentiPolozili;
    ListView listStudentiPoloziliSaOcenom;

    ListView listDostupneGodine;

    ListView listPolozeniStudent;

    ListView listNepolozeniStudent;


    TextInputEditText unosGodine;
    TextInputEditText studentIme;
    TextInputEditText studentPrezime;
    TextInputEditText studentJMBG;
    TextInputEditText studentIndeks;

    public static ArrayAdapter<String> arr;

    public static ArrayAdapter<String> arrPred;
    public static ArrayAdapter<String> arrGod;

    public static ArrayAdapter<String> arrDostupneGod;

    public static ArrayAdapter<String> arrSlu;

    public static ArrayAdapter<String> arrPol;

    public static ArrayAdapter<String> arrPolOce;

    public static ArrayAdapter<String> arrPolPr;

    public static ArrayAdapter<String> arrNepPr;

    public static ArrayAdapter<String> arrPs;

    public static ArrayAdapter<String> arrNs;

    public static ArrayAdapter<String> arrSveOce;
    public static String studentiNiz[];
    public static String predmetiNiz[];

    public static String sveOceneNiz[];


    public static String slusajuNiz[];
    public static String poloziliNiz[];
    public static String poloziliOcenaNiz[];

    public static String polozeniPredmeti[];

    public static String nepolozeniPredmeti[];

    public static String polozeniStudent[];

    public static String nepolozeniStudent[];
    int godina;

    int unosKategorija=1;
    String imePredmeta;

    String studentUsername;

    String izabranaGodina;
    String izabraniPredmet;
    String izabraniStudent;

    String tableNameKorisnici = "korisnici";
    String columnNameUser = "username";
    String columnNamePass = "password";
    String columnNameRole = "role";
    int studentView=0;
    int adminView=0;

    String godineNiz[];

    String godineDBNiz[];
    public static ArrayList<student> studenti;
    public static ArrayList<admin> admini;
    public static ArrayList<korisnik> korisnici;
    public static ArrayList<predmet> predmeti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.button);
        userText=findViewById(R.id.textUser);
        passText=findViewById(R.id.textPass);
        roleText=findViewById(R.id.textRole);
        textAll=findViewById(R.id.textAll);
        errorPopup=findViewById(R.id.textPopup);
        sveOcene=findViewById(R.id.sveOceneStudent);
        //studentList=findViewById(R.id.studentList);
        butAddStudent = findViewById(R.id.buttonAddStudent);
        butSearch = findViewById(R.id.buttonSearch);
        butStudentList =findViewById(R.id.buttonStudentList);
        butEnter = findViewById(R.id.Enter);
        butNazad=findViewById(R.id.buttonBack);
        butAddPredmet=findViewById(R.id.buttonAddPredmet);
        txpredmet = findViewById(R.id.textPredmet);
        txgodina = findViewById(R.id.textGodina);
        txbrojKat = findViewById(R.id.textBrojKategorija);
        enterStudent=findViewById(R.id.enterStudent);
        studentImePrezime=findViewById(R.id.studentImePrezime);
        errorClose=findViewById(R.id.buttonErrorClose);

        osv1=findViewById(R.id.textOsv1);
        osv2=findViewById(R.id.textOsv2);
        osv3=findViewById(R.id.textOsv3);
        osv4=findViewById(R.id.textOsv4);
        osv5=findViewById(R.id.textOsv5);
        butEnterPrStud=findViewById(R.id.buttonPredmetStud);

        nazadListaPredmeta = findViewById(R.id.nazadListaPredmeta);


        butEnter2 = findViewById(R.id.enter2);
        butEnter3 = findViewById(R.id.enter3);
        butGodine=findViewById(R.id.buttonGodine);
        nazadPredmeti=findViewById(R.id.buttonNazadPredmeti);
        nazadPredmetiOpcije=findViewById(R.id.buttonNazadPredmetiOpcije);

        dodajPredmet= findViewById(R.id.buttonDodajPredmet);
        obrisiStudenta= findViewById(R.id.buttonBrisiStudenta);
        spisakNepolozenih= findViewById(R.id.buttonSpisakNepolozenih);
        spisakPolozenih= findViewById(R.id.buttonSpisakPolozenih);
        nazaduListu= findViewById(R.id.buttonBackToList);

        studentIme = findViewById(R.id.studentIme);
        studentPrezime = findViewById(R.id.studentPrezime);
        studentJMBG = findViewById(R.id.studentJMBG);
        studentIndeks = findViewById(R.id.studentIndeks);

        unosGodine = findViewById(R.id.unosGodine);
        novaGodina = findViewById(R.id.buttonNovaGodina);
        nazadGodina = findViewById(R.id.buttonBackGodina);
        textKategorije= findViewById(R.id.textKategorije);

        k1=findViewById(R.id.textk1);
        k1max=findViewById(R.id.textk1max);
        k1min=findViewById(R.id.textk1min);
        k2=findViewById(R.id.textk2);
        k2max=findViewById(R.id.textk2max);
        k2min=findViewById(R.id.textk2min);
        k3=findViewById(R.id.textk3);
        k3max=findViewById(R.id.textk3max);
        k3min=findViewById(R.id.textk3min);
        k4=findViewById(R.id.textk4);
        k4max=findViewById(R.id.textk4max);
        k4min=findViewById(R.id.textk4min);
        k5=findViewById(R.id.textk5);
        k5max=findViewById(R.id.textk5max);
        k5min=findViewById(R.id.textk5min);

        nazadStudent=findViewById(R.id.buttonNazadStudent);

        spisakPredmeta=findViewById(R.id.butSpisakPredmet);
        predKategorije=findViewById(R.id.predKategorije);
        studentiSlusaju=findViewById(R.id.studSlusaju);
        studentiPolozili=findViewById(R.id.studPolozili);
        studentiPoloziliSacOcenom=findViewById(R.id.studSaOcenom);
        butOcenaFiltar=findViewById(R.id.buttonUnosOceneFiltar);
        textOcenaFiltar=findViewById(R.id.textOcenaFilt);


        korisnici = new ArrayList<korisnik>();
        studenti = new ArrayList<student>();
        admini = new ArrayList<admin>();
        predmeti = new ArrayList<predmet>();

        sveOceneNiz = new String[50];
        Arrays.fill(sveOceneNiz,"");

        studentiNiz = new String[50];
        Arrays.fill(studentiNiz,"");

        predmetiNiz = new String[50];
        Arrays.fill(predmetiNiz,"");

        godineNiz = new String[50];
        Arrays.fill(godineNiz,"");

        godineDBNiz = new String[50];
        Arrays.fill(godineDBNiz,"");

        polozeniPredmeti = new String[50];
        Arrays.fill(polozeniPredmeti,"");

        nepolozeniPredmeti = new String[50];
        Arrays.fill(nepolozeniPredmeti,"");

        polozeniStudent = new String[50];
        Arrays.fill(nepolozeniPredmeti,"");

        nepolozeniStudent = new String[50];
        Arrays.fill(nepolozeniPredmeti,"");

        slusajuNiz = new String[50];
        Arrays.fill(slusajuNiz,"");
        poloziliNiz = new String[50];
        Arrays.fill(poloziliNiz,"");
        poloziliOcenaNiz = new String[50];
        Arrays.fill(poloziliOcenaNiz,"");


        korisniciDbHelper databaseHelper = new korisniciDbHelper(this);
        SQLiteDatabase databaseKorisnici = databaseHelper.getWritableDatabase();

        predmetiDbHelper predmetiHelper = new predmetiDbHelper(this);
        SQLiteDatabase databasePredmeti = predmetiHelper.getWritableDatabase();

        studentiDbHelper studentiHelper = new studentiDbHelper(this);
        SQLiteDatabase databaseStudenti = studentiHelper.getWritableDatabase();

        godineDbHelper godineHelper = new godineDbHelper(this);
        SQLiteDatabase databaseGodine = godineHelper.getWritableDatabase();

        databaseKorisnici.delete(tableNameKorisnici, null, null);
        databasePredmeti.delete("kategorije", null, null);
        databasePredmeti.delete("predmeti", null, null);
        databaseStudenti.delete("studenti",null,null);
        databaseStudenti.delete("student_predmeti",null,null);
        databaseGodine.delete("godine",null,null);

        readAllEntriesKorisnici(databaseKorisnici);
        readAllEntriesGodine(databaseGodine);
        writeDatabaseContent(databasePredmeti);
        readAllEntriesStudenti(databaseStudenti);

        //provera sta je sve uneseno
        for(korisnik k1:korisnici){
            System.out.println(k1.getUsername());
        }

        listStudenti = findViewById(R.id.single_list_view);
        arr
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                studentiNiz);
        listStudenti.setAdapter(arr);

        listSveOcene = findViewById(R.id.list_sve_ocene);
        arrSveOce
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                sveOceneNiz);
        listSveOcene.setAdapter(arrSveOce);

        listStudentiSlusaju = findViewById(R.id.list_studenti_slusaju);
        arrSlu
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                slusajuNiz);
        listStudentiSlusaju.setAdapter(arrSlu);

        listStudentiPolozili = findViewById(R.id.list_studenti_polozili);
        arrPol
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                poloziliNiz);
        listStudentiPolozili.setAdapter(arrPol);

        listStudentiPoloziliSaOcenom = findViewById(R.id.list_studenti_polozili_ocena);
        arrPolOce
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                poloziliOcenaNiz);
        listStudentiPoloziliSaOcenom.setAdapter(arrPolOce);

        listPredmeti = findViewById(R.id.single_list_view2);
        arrPred
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                predmetiNiz);
        listPredmeti.setAdapter(arrPred);

        listGodine = findViewById(R.id.single_list_view3);
        arrGod
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                godineNiz);
        listGodine.setAdapter(arrGod);

        // za unos godine
        listDostupneGodine = findViewById(R.id.list_godine);
        arrDostupneGod
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                godineDBNiz);
        listDostupneGodine.setAdapter(arrDostupneGod);

        listPolozeniPredmeti = findViewById(R.id.list_polozeni_predmeti);
        arrPolPr
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                polozeniPredmeti);
        listPolozeniPredmeti.setAdapter(arrPolPr);

        listNepolozeniPredmeti = findViewById(R.id.list_nepolozeni_predmeti);
        arrNepPr
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                nepolozeniPredmeti);
        listNepolozeniPredmeti.setAdapter(arrNepPr);

        listPolozeniStudent = findViewById(R.id.list_polozeni_predmeti_student);
        arrPs
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                polozeniStudent);
        listPolozeniStudent.setAdapter(arrPs);

        listNepolozeniStudent = findViewById(R.id.list_nepolozeni_predmeti_student);
        arrNs
                = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                nepolozeniStudent);
        listNepolozeniStudent.setAdapter(arrNs);

        //String text = list.getItemAtPosition(position).toString();



        listStudenti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listStudenti.getItemAtPosition(myItemInt));
                System.out.println(selectedFromList);
                if(!selectedFromList.equals("")) {
                    String number=selectedFromList;
                    {
                        final Matcher m = Pattern.compile("(?<!\\d)\\d{4}(?!\\d)").matcher(number);
                        if(m.find()){
                            selectedStudent = m.group(); // retrieve the matched substring
                            System.out.println(selectedStudent);

                            izabraniStudent=selectedStudent;
                            listStudenti.setVisibility(myView.GONE);
                            dodajPredmet.setVisibility(myView.VISIBLE);
                            obrisiStudenta.setVisibility(myView.VISIBLE);
                            spisakNepolozenih.setVisibility(myView.VISIBLE);
                            spisakPolozenih.setVisibility(myView.VISIBLE);
                            butNazad.setVisibility(myView.GONE);
                            nazaduListu.setVisibility(myView.VISIBLE);

                        }
                        else {
                            selectedStudent = null; // no match found
                        }
                    }
                }
            }
        });

        listNepolozeniStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listNepolozeniStudent.getItemAtPosition(myItemInt));
                System.out.println(selectedFromList);
                if(!selectedFromList.equals("")) {
                        listNepolozeniStudent.setVisibility(myView.GONE);
                        listPolozeniStudent.setVisibility(myView.GONE);
                        listGodine.setVisibility(myView.GONE);
                        textKategorije.setVisibility(myView.VISIBLE);
                        izabraniPredmet = selectedFromList;
                        //findPredmetKategorije(izabraniPredmet, databasePredmeti);
                    System.out.println("test1 "+izabranaGodina);
                    System.out.println(izabraniPredmet);

                    String imeKat[]=new String[10];
                    String minBod[]=new String[10];
                    String maxBod[]=new String[10];
                    int[] osvBod =new int[10];
                    for(predmet p1:predmeti) {
                        System.out.println(p1.getImePredmeta());
                        if (p1.getImePredmeta().equals(izabraniPredmet)) {
                            System.out.println("Pronadjen predmet");
                            p1.setIzabranaGodina(izabranaGodina);
                            System.out.println(izabranaGodina);

                            int cntG=0;
                            String g1 = new String();
                            for(String god1:p1.getGodina()){
                                g1=p1.getGodina().get(cntG);
                                System.out.println(p1.getImePredmeta());
                                System.out.println("godina "+g1);
                                cntG++;
                            }

                            System.out.println(p1.getKategorije());
                            imeKat=p1.getKategorije();
                            minBod=p1.getBodovi_minimum();
                            maxBod=p1.getBodovi();
                        }
                    }
                    int cntPr=0;
                    System.out.println(izabraniStudent);
                    loop1:
                    for(student s1:studenti){
                        System.out.println(s1.getIme());
                        if(s1.getJmbg().equals(izabraniStudent)){
                            System.out.println("pronadjen student");
                            ArrayList<int[]> test1= s1.getOsvBodovi();
                            for(int[] int1:test1){
                                System.out.println("test"+int1);
                            }
                            for(String pr1:s1.getPredmeti()){
                                if(pr1.equals(izabraniPredmet)){
                                    osvBod=s1.getOsvBodovi(cntPr);
                                    break loop1;
                                }
                                cntPr++;
                            }
                        }
                    }



                    textKategorije.setText("Ime kategorije: " + imeKat[0]+ ", osvojeni bodovi: " + osvBod[0]+ ", minimalan broj bodova: "+minBod[0]+", maksimalan broj bodova:"
                            +maxBod[0]);
                    if(imeKat[1]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[1]+ ", osvojeni bodovi: " + osvBod[1] + ", minimalan broj bodova: "+minBod[1]+", maksimalan broj bodova:"
                                +maxBod[1]);
                    }
                    if(imeKat[2]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[2]+ ", osvojeni bodovi: " + osvBod[2] + ", minimalan broj bodova: "+minBod[2]+", maksimalan broj bodova:"
                                +maxBod[2]);
                    }
                    if(imeKat[3]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[3]+ ", osvojeni bodovi: " + osvBod[3]+ ", minimalan broj bodova: "+minBod[3]+", maksimalan broj bodova:"
                                +maxBod[3]);
                    }
                    if(imeKat[4]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[4]+ ", osvojeni bodovi: " + osvBod[4]+ ", minimalan broj bodova: "+minBod[4]+", maksimalan broj bodova:"
                                +maxBod[4]);
                    }


                }
            }
        });

        listPolozeniStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listPolozeniStudent.getItemAtPosition(myItemInt));
                System.out.println(selectedFromList);
                if(!selectedFromList.equals("")) {
                    listNepolozeniStudent.setVisibility(myView.GONE);
                    listPolozeniStudent.setVisibility(myView.GONE);
                    listGodine.setVisibility(myView.GONE);
                    textKategorije.setVisibility(myView.VISIBLE);
                    izabraniPredmet = selectedFromList;
                    //findPredmetKategorije(izabraniPredmet, databasePredmeti);
                    System.out.println("test1 "+izabranaGodina);
                    System.out.println(izabraniPredmet);

                    String imeKat[]=new String[10];
                    String minBod[]=new String[10];
                    String maxBod[]=new String[10];
                    int[] osvBod =new int[10];
                    for(predmet p1:predmeti) {
                        System.out.println(p1.getImePredmeta());
                        if (p1.getImePredmeta().equals(izabraniPredmet)) {
                            System.out.println("Pronadjen predmet");
                            p1.setIzabranaGodina(izabranaGodina);
                            System.out.println(izabranaGodina);

                            int cntG=0;
                            String g1 = new String();
                            for(String god1:p1.getGodina()){
                                g1=p1.getGodina().get(cntG);
                                System.out.println(p1.getImePredmeta());
                                System.out.println("godina "+g1);
                                cntG++;
                            }

                            System.out.println(p1.getKategorije());
                            imeKat=p1.getKategorije();
                            minBod=p1.getBodovi_minimum();
                            maxBod=p1.getBodovi();
                        }
                    }
                    int cntPr=0;
                    System.out.println(izabraniStudent);
                    loop1:
                    for(student s1:studenti){
                        System.out.println(s1.getIme());
                        if(s1.getJmbg().equals(izabraniStudent)){
                            System.out.println("pronadjen student");
                            ArrayList<int[]> test1= s1.getOsvBodovi();
                            for(int[] int1:test1){
                                System.out.println("test"+int1);
                            }
                            for(String pr1:s1.getPredmeti()){
                                if(pr1.equals(izabraniPredmet)){
                                    osvBod=s1.getOsvBodovi(cntPr);
                                    break loop1;
                                }
                                cntPr++;
                            }
                        }
                    }



                    textKategorije.setText("Ime kategorije: " + imeKat[0]+ ", osvojeni bodovi: " + osvBod[0]+ ", minimalan broj bodova: "+minBod[0]+", maksimalan broj bodova:"
                            +maxBod[0]);
                    if(imeKat[1]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[1]+ ", osvojeni bodovi: " + osvBod[1] + ", minimalan broj bodova: "+minBod[1]+", maksimalan broj bodova:"
                                +maxBod[1]);
                    }
                    if(imeKat[2]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[2]+ ", osvojeni bodovi: " + osvBod[2] + ", minimalan broj bodova: "+minBod[2]+", maksimalan broj bodova:"
                                +maxBod[2]);
                    }
                    if(imeKat[3]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[3]+ ", osvojeni bodovi: " + osvBod[3]+ ", minimalan broj bodova: "+minBod[3]+", maksimalan broj bodova:"
                                +maxBod[3]);
                    }
                    if(imeKat[4]!=null) {
                        textKategorije.append("\n" +"Ime kategorije: "+ imeKat[4]+ ", osvojeni bodovi: " + osvBod[4]+ ", minimalan broj bodova: "+minBod[4]+", maksimalan broj bodova:"
                                +maxBod[4]);
                    }


                }
            }
        });


        listPredmeti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listPredmeti.getItemAtPosition(myItemInt));
                System.out.println(selectedFromList);
                if(!selectedFromList.equals("")) {
                    if(adminView==1) {
                        listPredmeti.setVisibility(myView.GONE);
                        listGodine.setVisibility(myView.VISIBLE);
                        int exists=0;
                        if (unosKategorija == 1) {
                        butEnterPrStud.setVisibility(myView.GONE);
                        nazadPredmetiOpcije.setVisibility(myView.GONE);
                        } else {
                            nazadPredmetiOpcije.setVisibility(myView.VISIBLE);
                        }
                        izabraniPredmet = selectedFromList;
                        nazadListaPredmeta.setVisibility(myView.GONE);
                        findPredmetKategorije(izabraniPredmet, databasePredmeti);
                    }
                    else{}
                    //Arrays.fill(godineNiz,"");
                }
            }
        });

        listGodine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList =(String) (listGodine.getItemAtPosition(myItemInt));
                System.out.println(selectedFromList);
                osv1.setVisibility(myView.GONE);
                osv2.setVisibility(myView.GONE);
                osv3.setVisibility(myView.GONE);
                osv4.setVisibility(myView.GONE);
                osv5.setVisibility(myView.GONE);
                butEnterPrStud.setVisibility(myView.GONE);
                if(!selectedFromList.equals("")) {
                    izabranaGodina = selectedFromList;
                    if (adminView == 1) {

                        for (predmet p1 : predmeti) {
                            if (p1.getImePredmeta().equals(izabraniPredmet)) {
                                System.out.println("izbor " + izabranaGodina);
                                p1.setIzabranaGodina(izabranaGodina);
                                String kat[] = p1.getKategorije();
                                System.out.println(unosKategorija);
                                //ako se unosi
                                if (unosKategorija == 1) {
                                    int cntG = 0;
                                    int existsGod = 0;
                                    int existsIme=0;
                                    System.out.println("izbor pr "+izabranaGodina);
                                    System.out.println(izabraniPredmet);
                                    loop1:
                                    for (student s1 : studenti) {
                                        System.out.println(s1.getIme());
                                        cntG = 0;
                                        for (String pr1 : s1.getPredmeti()) {
                                            System.out.println(pr1);
                                            System.out.println("godina pr "+s1.getGodina(cntG));
                                            if (pr1.equals(izabraniPredmet)) {
                                                existsIme=1;
                                                if(s1.getGodina(cntG).equals(izabranaGodina)) {
                                                    existsGod = 1;
                                                    System.out.println("Predmet vec postoji za studenta na drugoj godini");
                                                    //unosKategori

                                                    break loop1;
                                                }
                                            }
                                            cntG++;
                                        }
                                    }

                                    if (existsIme==0 || (existsIme==1 && existsGod==1)) {
                                        butEnterPrStud.setVisibility(myView.VISIBLE);
                                        osv2.setVisibility(myView.GONE);
                                        osv3.setVisibility(myView.GONE);
                                        osv4.setVisibility(myView.GONE);
                                        osv5.setVisibility(myView.GONE);

                                        osv1.setVisibility(myView.VISIBLE);
                                        brojKat = 1;
                                        if (kat[1] != null) {
                                            osv2.setVisibility(myView.VISIBLE);
                                            brojKat = 2;
                                        }
                                        if (kat[2] != null) {
                                            osv3.setVisibility(myView.VISIBLE);
                                            brojKat = 3;
                                        }
                                        if (kat[3] != null) {
                                            osv4.setVisibility(myView.VISIBLE);
                                            brojKat = 4;
                                        }
                                        if (kat[4] != null) {
                                            osv5.setVisibility(myView.VISIBLE);
                                            brojKat = 5;
                                        }
                                        break;
                                    }
                                }
                                //ako se ne unosi
                                else {
                                        predKategorije.setVisibility(myView.VISIBLE);
                                        studentiSlusaju.setVisibility(myView.VISIBLE);
                                        studentiPolozili.setVisibility(myView.VISIBLE);
                                        studentiPoloziliSacOcenom.setVisibility(myView.VISIBLE);
                                }
                                System.out.println("succ");
                            }
                        }
                    }
                    //deo za studenstku stranu
                    else {
                        izabranaGodina = selectedFromList;
                        String podaci[] = findStudentByUsername(studentUsername, databaseStudenti);
                        int i = 0;
                        int cnt1 = 0;
                        int cnt2 = 0;
                        Arrays.fill(polozeniStudent, "");
                        Arrays.fill(nepolozeniStudent, "");


                        for (student s1 : studenti) {
                            if (s1.getJmbg().equals(podaci[2])) {
                                //pronadjen student
                                System.out.println("jmbg " + s1.getJmbg());
                                for (String pr1 : s1.getGodina()) {
                                    System.out.println("godina " + pr1);
                                    //System.out.println(izabranaGodina);
                                    if (pr1.equals(izabranaGodina)) {
                                        System.out.println(pr1);
                                        if (s1.getPolozeno(i).equals("Polozen")) {
                                            polozeniStudent[cnt1] = s1.getPredmeti().get(i);
                                            cnt1++;
                                        } else {
                                            nepolozeniStudent[cnt2] = s1.getPredmeti().get(i);
                                            cnt2++;
                                        }
                                    }
                                    i++;
                                }


                                break;
                            }
                        }

                        listPolozeniStudent.setVisibility(myView.VISIBLE);
                        listNepolozeniStudent.setVisibility(myView.VISIBLE);
                        nazadStudent.setVisibility(myView.VISIBLE);
                        listGodine.setVisibility(myView.GONE);
                        studentImePrezime.setVisibility(myView.GONE);
                        sveOcene.setVisibility(myView.GONE);
                    }
                }
                }
        });





        //brisanje citave tabele
        /**/


        //dodaj novog admina ako je tabela prazna
        /*long rowCount = DatabaseUtils.queryNumEntries(databaseKorisnici, tableNameKorisnici);
        if (rowCount == 0) {
            ContentValues values = new ContentValues();
            values.put(columnNameUser, "AdminTest");
            values.put(columnNamePass, "MyPass");
            values.put(columnNameRole, "Admin");

            long newRowId = databaseKorisnici.insert(tableNameKorisnici, null, values);
            if (newRowId != -1) {
                System.out.println("Added");
            } else {
                System.out.println("Failed to add");
            }
        }*/



        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                String userInput = String.valueOf(userText.getText());
                System.out.println(userInput);
                String passInput = String.valueOf(passText.getText());
                System.out.println(passInput);
                String roleInput = String.valueOf(roleText.getText());
                System.out.println(roleInput);

                /*for(korisnik k1:korisnici){
                    if(userInput.equals(k1.getUsername()) && passInput.equals(k1.getPassword()) && roleInput.equals(k1.getAdmin())){
                        System.out.println("Pass");
                    }
                }*/
                if(findUser(userInput,passInput,roleInput,databaseKorisnici)==true){
                    System.out.println("Logged");
                    if(roleInput.equals("Admin")){
                        adminView=1;
                        userText.setVisibility(v.GONE);
                        passText.setVisibility(v.GONE);
                        roleText.setVisibility(v.GONE);
                        but1.setVisibility(v.GONE);
                        butSearch.setVisibility(v.GONE);
                        butAddStudent.setVisibility(v.VISIBLE);
                        butAddPredmet.setVisibility(v.VISIBLE);
                        //textAll.setVisibility(v.VISIBLE);
                        butStudentList.setVisibility(v.VISIBLE);
                        butGodine.setVisibility(v.VISIBLE);
                        spisakPredmeta.setVisibility(v.VISIBLE);
                    }
                    else{
                        //studentski deo
                        adminView=0;
                        String podaci[]=findStudentByUsername(userInput,databaseStudenti);
                        //String parentId=findStudent(izabraniStudent,databaseStudenti,0);
                        studentImePrezime.setText("Ime: "+podaci[0]+"\n"+"Prezime: "+podaci[1]+"\n"+"JMBG: "+podaci[2]+"\n"+"Indeks:" +
                                podaci[3]);
                        userText.setVisibility(v.GONE);
                        passText.setVisibility(v.GONE);
                        roleText.setVisibility(v.GONE);
                        but1.setVisibility(v.GONE);
                        studentUsername=userInput;
                        Arrays.fill(godineNiz,"");

                        int i=0;
                        for(student s1:studenti){
                            if(s1.getJmbg().equals(podaci[2])){
                                izabraniStudent=s1.getJmbg();
                                for(String god1:s1.getGodina()) {
                                    godineNiz[i] = s1.getGodina(i);
                                    i++;
                                }
                            }
                        }

                        studentImePrezime.setVisibility(v.VISIBLE);
                        listGodine.setVisibility(v.VISIBLE);
                        sveOcene.setVisibility(v.VISIBLE);

                        TextView textView1 = new TextView(v.getContext());
                        textView1.setText("Polozeni predmeti");
                        listPolozeniStudent.addHeaderView(textView1);
                        TextView textView2 = new TextView(v.getContext());
                        textView2.setText("Nepolozeni predmeti");
                        listNepolozeniStudent.addHeaderView(textView2);
                    }
                }
                else{
                    if(userInput.equals("AdminTest") && passInput.equals("MyPass") && roleInput.equals("Admin")){
                        adminView=1;
                        userText.setVisibility(v.GONE);
                        passText.setVisibility(v.GONE);
                        roleText.setVisibility(v.GONE);
                        but1.setVisibility(v.GONE);
                        butSearch.setVisibility(v.GONE);
                        butAddStudent.setVisibility(v.VISIBLE);
                        butAddPredmet.setVisibility(v.VISIBLE);
                        //textAll.setVisibility(v.VISIBLE);
                        butStudentList.setVisibility(v.VISIBLE);
                        butGodine.setVisibility(v.VISIBLE);
                        spisakPredmeta.setVisibility(v.VISIBLE);
                    }
                    else {
                        System.out.println("Wrong");
                    }
                }
            }
        });

        nazaduListu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.VISIBLE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.VISIBLE);
                nazaduListu.setVisibility(v.GONE);
            }
        });

        sveOcene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSveOcene.setVisibility(v.VISIBLE);
                nazadStudent.setVisibility(v.VISIBLE);
                studentImePrezime.setVisibility(v.GONE);
                listGodine.setVisibility(v.GONE);
                sveOcene.setVisibility(v.GONE);
                int cnt=0;
                Arrays.fill(sveOceneNiz,"");
                for(student s1:studenti){
                    if(s1.getJmbg().equals(izabraniStudent)){
                        for(String pr1:s1.getPredmeti()){
                            sveOceneNiz[cnt]=s1.getPredmeti().get(cnt)+" "+s1.getOcena(cnt);
                            cnt++;
                        }
                        break;
                    }
                }
            }
        });

        nazadStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentImePrezime.setVisibility(v.VISIBLE);
                listGodine.setVisibility(v.VISIBLE);
                sveOcene.setVisibility(v.VISIBLE);
                listSveOcene.setVisibility(v.GONE);
                nazadStudent.setVisibility(v.GONE);
                listPolozeniStudent.setVisibility(v.GONE);
                listNepolozeniStudent.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
            }
        });

        obrisiStudenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("brisanje");
                System.out.println(izabraniStudent);
                String parentId=findStudent(izabraniStudent,databaseStudenti,0);
                String username=findStudent(izabraniStudent,databaseStudenti,1);
                databaseStudenti.delete("studenti", ParentTableStudenti.COLUMN_ID + " = ?", new String[]{parentId});
                databaseStudenti.delete("student_predmeti", ChildTableStudenti.COLUMN_PARENT_ID + " = ?", new String[]{parentId});
                databaseKorisnici.delete(tableNameKorisnici, "username" + " = ?", new String[]{username});
                listStudenti.setVisibility(v.VISIBLE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.VISIBLE);
                nazaduListu.setVisibility(v.GONE);
                for(student s1:studenti){
                    if(s1.getJmbg().equals(izabraniStudent)){
                        studenti.remove(s1);
                    }
                }
                readAllEntriesStudenti(databaseStudenti);
            }
        });

        nazadPredmeti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setVisibility(v.GONE);
                passText.setVisibility(v.GONE);
                roleText.setVisibility(v.GONE);
                but1.setVisibility(v.GONE);
                //butSearch.setVisibility(v.VISIBLE);
                butAddStudent.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.VISIBLE);
                //textAll.setVisibility(v.VISIBLE);
                butStudentList.setVisibility(v.VISIBLE);
                butGodine.setVisibility(v.VISIBLE);
                spisakPredmeta.setVisibility(v.VISIBLE);
                listPredmeti.setVisibility(v.GONE);
                nazadPredmeti.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
            }
        });

        nazadPredmetiOpcije.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPredmeti.setVisibility(v.VISIBLE);
                nazadPredmeti.setVisibility(v.VISIBLE);
                listGodine.setVisibility(v.GONE);
                predKategorije.setVisibility(v.GONE);
                studentiSlusaju.setVisibility(v.GONE);
                studentiPolozili.setVisibility(v.GONE);
                studentiPoloziliSacOcenom.setVisibility(v.GONE);
                listStudentiPolozili.setVisibility(v.GONE);
                listStudentiSlusaju.setVisibility(v.GONE);
                listStudentiPoloziliSaOcenom.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
                nazadPredmetiOpcije.setVisibility(v.GONE);
                nazadPredmeti.setVisibility(v.VISIBLE);
            }
        });

        predKategorije.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                listGodine.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                predKategorije.setVisibility(v.GONE);
                studentiSlusaju.setVisibility(v.GONE);
                studentiPolozili.setVisibility(v.GONE);
                studentiPoloziliSacOcenom.setVisibility(v.GONE);
                textKategorije.setVisibility(v.VISIBLE);

                String imeKat[]=new String[10];
                String minBod[]=new String[10];
                String maxBod[]=new String[10];
                for(predmet p1:predmeti) {
                    if (p1.getImePredmeta().equals(izabraniPredmet)) {
                        p1.setIzabranaGodina(izabranaGodina);
                        System.out.println(izabranaGodina);
                        System.out.println(p1.getKategorije());
                        imeKat=p1.getKategorije();
                        minBod=p1.getBodovi_minimum();
                        maxBod=p1.getBodovi();
                    }
                }

                textKategorije.setText("Ime kategorije: " + imeKat[0]+ ", minimalan broj bodova: "+minBod[0]+", maksimalan broj bodova:"
                           +maxBod[0]);
                if(imeKat[1]!=null) {
                    textKategorije.append("\n" +"Ime kategorije: " + imeKat[1]+ ", minimalan broj bodova: "+minBod[1]+", maksimalan broj bodova:"
                            +maxBod[1]);
                }
                if(imeKat[2]!=null) {
                    textKategorije.append("\n" +"Ime kategorije: " + imeKat[2]+ ", minimalan broj bodova: "+minBod[2]+", maksimalan broj bodova:"
                            +maxBod[2]);
                }
                if(imeKat[3]!=null) {
                    textKategorije.append("\n" +"Ime kategorije: " + imeKat[3]+ ", minimalan broj bodova: "+minBod[3]+", maksimalan broj bodova:"
                            +maxBod[3]);
                }
                if(imeKat[4]!=null) {
                    textKategorije.append("\n" +"Ime kategorije: " + imeKat[4]+ ", minimalan broj bodova: "+minBod[4]+", maksimalan broj bodova:"
                            +maxBod[4]);
                }
            }
        });

        studentiSlusaju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                listGodine.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                predKategorije.setVisibility(v.GONE);
                studentiSlusaju.setVisibility(v.GONE);
                studentiPolozili.setVisibility(v.GONE);
                studentiPoloziliSacOcenom.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
                listStudentiSlusaju.setVisibility(v.VISIBLE);

                Arrays.fill(slusajuNiz,"");
                int i;
                int j=0;
                for(student s1:studenti){
                    i=0;
                    for(String p1:s1.getPredmeti()){
                        if(p1.equals(izabraniPredmet)&& s1.getGodina(i).equals(izabranaGodina)){
                            slusajuNiz[j]=(s1.getIme()+" "+s1.getPrezime());
                            j++;
                            break;
                        }
                            i++;
                    }
                }

            }
        });

        studentiPolozili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                listGodine.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                predKategorije.setVisibility(v.GONE);
                studentiSlusaju.setVisibility(v.GONE);
                studentiPolozili.setVisibility(v.GONE);
                studentiPoloziliSacOcenom.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
                listStudentiPolozili.setVisibility(v.VISIBLE);

                Arrays.fill(poloziliNiz,"");
                int i;
                int j=0;
                for(student s1:studenti){
                    i=0;
                    for(String p1:s1.getPredmeti()){
                        if(p1.equals(izabraniPredmet)&& s1.getGodina(i).equals(izabranaGodina)){
                            if(s1.getPolozeno(i).equals("Polozen")){
                                poloziliNiz[j]=(s1.getIme()+" "+s1.getPrezime());
                                j++;
                                break;
                            }
                        }
                        i++;
                    }
                }

            }
        });

        studentiPoloziliSacOcenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                listGodine.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                predKategorije.setVisibility(v.GONE);
                studentiSlusaju.setVisibility(v.GONE);
                studentiPolozili.setVisibility(v.GONE);
                studentiPoloziliSacOcenom.setVisibility(v.GONE);
                textKategorije.setVisibility(v.GONE);
                textOcenaFiltar.setVisibility(v.VISIBLE);
                butOcenaFiltar.setVisibility(v.VISIBLE);
            }
        });

        butOcenaFiltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Filtriranje po oceni");
                int izabranaOcena = Integer.parseInt(String.valueOf(textOcenaFiltar.getText()));
                textOcenaFiltar.setVisibility(v.GONE);
                butOcenaFiltar.setVisibility(v.GONE);
                listStudentiPoloziliSaOcenom.setVisibility(v.VISIBLE);

                Arrays.fill(poloziliOcenaNiz,"");
                int i;
                int j=0;
                for(student s1:studenti){
                    i=0;
                    for(String p1:s1.getPredmeti()){
                        if(p1.equals(izabraniPredmet)&& s1.getGodina(i).equals(izabranaGodina)){
                            System.out.println("Pronadjen predmet");
                            if(s1.getPolozeno(i).equals("Polozen")){
                                System.out.println("Polozen predmet");
                                int ocenaStudenta = s1.getOcena(i);
                                if(izabranaOcena<=ocenaStudenta) {
                                    poloziliOcenaNiz[j] = (s1.getIme() + " " + s1.getPrezime());
                                    j++;
                                    break;
                                }
                            }
                        }
                        i++;
                    }
                }
            }
        });

        spisakPredmeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unosKategorija=0;
                //butSearch.setVisibility(v.GONE);
                butAddStudent.setVisibility(v.GONE);
                butAddPredmet.setVisibility(v.GONE);
                //textAll.setVisibility(v.GONE);
                butStudentList.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                listStudenti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.VISIBLE);
                nazadPredmeti.setVisibility(v.VISIBLE);
            }
        });

        butGodine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butAddStudent.setVisibility(v.GONE);
                //butSearch.setVisibility(v.GONE);
                //textAll.setVisibility(v.GONE);
                novaGodina.setVisibility(v.VISIBLE);
                listDostupneGodine.setVisibility(v.VISIBLE);
                nazadGodina.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.GONE);
                butStudentList.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                unosGodine.setVisibility(v.VISIBLE);
                //readAllEntriesGodine(databaseGodine);
            }
        });

        errorClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorClose.setVisibility(v.GONE);
                errorPopup.setVisibility(v.GONE);
            }
        });

        nazadGodina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setVisibility(v.GONE);
                passText.setVisibility(v.GONE);
                roleText.setVisibility(v.GONE);
                but1.setVisibility(v.GONE);
                listDostupneGodine.setVisibility(v.GONE);
                nazadGodina.setVisibility(v.GONE);
                novaGodina.setVisibility(v.GONE);
                //butSearch.setVisibility(v.VISIBLE);
                butAddStudent.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.VISIBLE);
                //textAll.setVisibility(v.VISIBLE);
                butStudentList.setVisibility(v.VISIBLE);
                butGodine.setVisibility(v.VISIBLE);
                unosGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.VISIBLE);
                butEnter.setVisibility(v.GONE);
                butEnter2.setVisibility(v.GONE);
                butEnter3.setVisibility(v.GONE);
                butEnterPrStud.setVisibility(v.GONE);
                enterStudent.setVisibility(v.GONE);
                txpredmet.setVisibility(v.GONE);
                txgodina.setVisibility(v.GONE);
                txbrojKat.setVisibility(v.GONE);
            }
        });

        novaGodina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String godinaN = String.valueOf(unosGodine.getText());
                String regexGodina = "\\d{4}/\\d{4}";
                Pattern patternGodina = Pattern.compile(regexGodina);
                Matcher matcherGodina = patternGodina.matcher(godinaN);
                if(matcherGodina.matches()) {
                    ContentValues values = new ContentValues();
                    values.put("godina", godinaN);
                    databaseGodine.insert("godine", null, values);
                    readAllEntriesGodine(databaseGodine);
                }
                else{
                    errorPopup.setVisibility(v.VISIBLE);
                    errorPopup.bringToFront();
                    errorPopup.setText("Los unos za godinu");
                    errorClose.setVisibility(v.VISIBLE);
                    errorClose.bringToFront();
                }
            }
        });

        butEnterPrStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String osvBod1 = String.valueOf(osv1.getText());
                String osvBod2 = String.valueOf(osv2.getText());
                String osvBod3 = String.valueOf(osv3.getText());
                String osvBod4 = String.valueOf(osv4.getText());
                String osvBod5 = String.valueOf(osv5.getText());

                ContentValues values = new ContentValues();
                String parentId=findStudent(izabraniStudent,databaseStudenti,0);
                values.put(ChildTableStudenti.COLUMN_PARENT_ID, parentId);
                values.put(ChildTableStudenti.COLUMN_IMEPREDMETA, izabraniPredmet);
                values.put(ChildTableStudenti.COLUMN_GODINA, izabranaGodina);
                if(osvBod1!=null) {
                    values.put(ChildTableStudenti.COLUMN_OSV1, osvBod1);
                }
                if(brojKat>1) {
                    if(osvBod2!=null) {
                        values.put(ChildTableStudenti.COLUMN_OSV2, osvBod2);
                    }
                    if(brojKat>2) {
                        if(osvBod3!=null) {
                            values.put(ChildTableStudenti.COLUMN_OSV3, osvBod3);
                        }
                        if(brojKat>3) {
                            if(osvBod4!=null) {
                                values.put(ChildTableStudenti.COLUMN_OSV4, osvBod4);
                            }
                            if(brojKat>4) {
                                if(osvBod5!=null) {
                                    values.put(ChildTableStudenti.COLUMN_OSV5, osvBod5);
                                }
                            }
                        }
                    }
                }

                int exists=0;
                for(student s1:studenti){
                    if(s1.getJmbg().equals(izabraniStudent)){
                        for(String pr1:s1.getPredmeti()){
                            if(pr1.equals(izabraniPredmet)){
                                exists=1;
                            }
                        }
                    }
                }
                if(exists==0) {
                    System.out.println("Inserting");
                    databaseStudenti.insert(ChildTableStudenti.TABLE_NAME, null, values);
                }
                else{
                    System.out.println("Updating");
                    databaseStudenti.update(ChildTableStudenti.TABLE_NAME, values, "ime_predmeta = ?",new String[]{izabraniPredmet});
                }
                readAllEntriesStudenti(databaseStudenti);

                listGodine.setVisibility(v.GONE);
                osv1.setVisibility(v.GONE);
                osv2.setVisibility(v.GONE);
                osv3.setVisibility(v.GONE);
                osv4.setVisibility(v.GONE);
                osv5.setVisibility(v.GONE);
                butEnterPrStud.setVisibility(v.GONE);
                listStudenti.setVisibility(v.VISIBLE);
                butNazad.setVisibility(v.VISIBLE);
            }
        });

        dodajPredmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.VISIBLE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazadListaPredmeta.setVisibility(v.VISIBLE);
            }
        });

        spisakPolozenih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.fill(polozeniPredmeti,"");
                int i=0;
                int j=0;
                for(student s1:studenti){
                    if(s1.getJmbg().equals(izabraniStudent)){
                        System.out.println("nadjen student " + s1.getJmbg());
                        for(String str1:s1.getPredmeti()){
                            System.out.println("nadjen predmet " + s1.getPredmeti().get(i));
                            if(s1.getPolozeno(i).equals("Polozen")){
                                polozeniPredmeti[j]=s1.getPredmeti().get(i)+" "+s1.getOcena(i);
                                j++;
                            }
                            i++;
                        }
                        break;
                    }
                }

                listStudenti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                listPolozeniPredmeti.setVisibility(v.VISIBLE);
                nazadListaPredmeta.setVisibility(v.VISIBLE);
            }
        });

        spisakNepolozenih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.fill(nepolozeniPredmeti,"");
                int i=0;
                int j=0;
                for(student s1:studenti){
                    if(s1.getJmbg().equals(izabraniStudent)){
                        for(String str1:s1.getPredmeti()){
                            if(!s1.getPolozeno(i).equals("Polozen")){
                                nepolozeniPredmeti[j]=s1.getPredmeti().get(i);
                                j++;
                            }
                            i++;
                        }
                        break;
                    }
                }

                listStudenti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.GONE);
                obrisiStudenta.setVisibility(v.GONE);
                spisakNepolozenih.setVisibility(v.GONE);
                spisakPolozenih.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.GONE);
                listPredmeti.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                listNepolozeniPredmeti.setVisibility(v.VISIBLE);
                nazadListaPredmeta.setVisibility(v.VISIBLE);
            }
        });

        nazadListaPredmeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listStudenti.setVisibility(v.GONE);
                dodajPredmet.setVisibility(v.VISIBLE);
                obrisiStudenta.setVisibility(v.VISIBLE);
                spisakNepolozenih.setVisibility(v.VISIBLE);
                spisakPolozenih.setVisibility(v.VISIBLE);
                listPredmeti.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                nazaduListu.setVisibility(v.VISIBLE);
                nazadListaPredmeta.setVisibility(v.GONE);
                listPolozeniPredmeti.setVisibility(v.GONE);
                listNepolozeniPredmeti.setVisibility(v.GONE);
                //spisakPredmeta.setVisibility(v.VISIBLE);
            }
        });

        butAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                butAddStudent.setVisibility(v.GONE);
                //butSearch.setVisibility(v.GONE);
                //textAll.setVisibility(v.GONE);
                userText.setVisibility(v.VISIBLE);
                passText.setVisibility(v.VISIBLE);
                roleText.setVisibility(v.VISIBLE);
                butEnter.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.GONE);
                butStudentList.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazadGodina.setVisibility(v.VISIBLE);

                userText.setText("");
                passText.setText("");
                roleText.setText("");
            }
        });



        butStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                butAddStudent.setVisibility(v.GONE);
                //butSearch.setVisibility(v.GONE);
                //textAll.setVisibility(v.GONE);
                butAddPredmet.setVisibility(v.GONE);
                butStudentList.setVisibility(v.GONE);
                //studentList.setVisibility(v.VISIBLE);
                butNazad.setVisibility(v.VISIBLE);
                listStudenti.setVisibility(v.VISIBLE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                unosKategorija=1;
            }
        });

        butNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                butAddStudent.setVisibility(v.VISIBLE);
                //butSearch.setVisibility(v.VISIBLE);
                //textAll.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.VISIBLE);
                butStudentList.setVisibility(v.VISIBLE);
                //studentList.setVisibility(v.GONE);
                butNazad.setVisibility(v.GONE);
                listStudenti.setVisibility(v.GONE);
                butGodine.setVisibility(v.VISIBLE);
                spisakPredmeta.setVisibility(v.VISIBLE);

                //studentList.setText();
            }
        });



        butEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                if(String.valueOf(userText.getText()).equals("") || String.valueOf(passText.getText()).equals("")){
                    System.out.println("Uneti username i password");
                }
                else if (String.valueOf(roleText.getText()).equals("Admin") || String.valueOf(roleText.getText()).equals("Student")){
                    String userInput = String.valueOf(userText.getText());
                    System.out.println(userInput);
                    String passInput = String.valueOf(passText.getText());
                    System.out.println(passInput);
                    String roleInput = String.valueOf(roleText.getText());
                    System.out.println(roleInput);

                    //treba samo USERNAME
                    if (findUser(userInput, databaseKorisnici) == true) {
                        System.out.println("USER " + userInput +" EXISTS");
                    } else {
                        ContentValues values = new ContentValues();
                        values.put(columnNameUser, userInput);
                        values.put(columnNamePass, passInput);
                        values.put(columnNameRole, roleInput);
                        databaseKorisnici.insert(tableNameKorisnici, null, values);

                        readAllEntriesKorisnici(databaseKorisnici);
                        for (korisnik k1 : korisnici) {
                            System.out.println(k1.getUsername());
                        }
                        userText.setVisibility(v.GONE);
                        passText.setVisibility(v.GONE);
                        roleText.setVisibility(v.GONE);
                        but1.setVisibility(v.GONE);
                        butEnter.setVisibility(v.GONE);
                        nazadGodina.setVisibility(v.GONE);
                        if(roleInput.equals("Admin")) {
                            butAddPredmet.setVisibility(v.VISIBLE);
                            butStudentList.setVisibility(v.VISIBLE);
                            butAddStudent.setVisibility(v.VISIBLE);
                            butAddPredmet.setVisibility(v.VISIBLE);
                            butGodine.setVisibility(v.VISIBLE);
                            spisakPredmeta.setVisibility(v.VISIBLE);
                        }
                        else{
                            izabraniKorisnik=userInput;
                            studentIme.setText("");
                            studentPrezime.setText("");
                            studentJMBG.setText("");
                            studentIndeks.setText("");
                            studentIme.setVisibility(v.VISIBLE);
                            studentPrezime.setVisibility(v.VISIBLE);
                            studentJMBG.setVisibility(v.VISIBLE);
                            studentIndeks.setVisibility(v.VISIBLE);
                            enterStudent.setVisibility(v.VISIBLE);
                        }
                    }
                }
                else{
                    System.out.println("Admin ili student");
                }
            }
        });

        enterStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                if(String.valueOf(studentIme.getText()).equals("") || String.valueOf(studentPrezime.getText()).equals("")){
                    System.out.println("Uneti ime i prezime");
                }
                else if(String.valueOf(studentJMBG.getText()).equals("") || String.valueOf(studentIndeks.getText()).equals("")){
                    System.out.println("Uneti jmbg i indeks");
                }
                else{
                    String imeStudent = String.valueOf(studentIme.getText());
                    System.out.println(imeStudent);
                    String prezimeStudent = String.valueOf(studentPrezime.getText());
                    System.out.println(prezimeStudent);
                    String jmbgStudent = String.valueOf(studentJMBG.getText());
                    System.out.println(jmbgStudent);
                    String indeksStudent = String.valueOf(studentIndeks.getText());
                    System.out.println(indeksStudent);

                    //treba samo USERNAME

                    ContentValues parentValues = new ContentValues();
                    parentValues.put(ParentTableStudenti.COLUMN_USER, izabraniKorisnik);
                    parentValues.put(ParentTableStudenti.COLUMN_IME, imeStudent);
                    parentValues.put(ParentTableStudenti.COLUMN_PREZIME, prezimeStudent);
                    parentValues.put(ParentTableStudenti.COLUMN_JMBG, jmbgStudent);
                    parentValues.put(ParentTableStudenti.COLUMN_INDEKS, indeksStudent);
                    long parentId = databaseStudenti.insert(ParentTableStudenti.TABLE_NAME, null, parentValues);

                    /*readAllEntriesKorisnici(databaseKorisnici);
                    for (korisnik k1 : korisnici) {
                        System.out.println(k1.getUsername());
                    }*/
                    studentIme.setVisibility(v.GONE);
                    studentPrezime.setVisibility(v.GONE);
                    studentJMBG.setVisibility(v.GONE);
                    studentIndeks.setVisibility(v.GONE);
                    enterStudent.setVisibility(v.GONE);
                    //butSearch.setVisibility(v.VISIBLE);
                    butAddStudent.setVisibility(v.VISIBLE);
                    //textAll.setVisibility(v.VISIBLE);
                    butAddPredmet.setVisibility(v.VISIBLE);
                    butStudentList.setVisibility(v.VISIBLE);
                    butGodine.setVisibility(v.VISIBLE);
                    spisakPredmeta.setVisibility(v.VISIBLE);

                    readAllEntriesStudenti(databaseStudenti);
                    for (student s1 : studenti) {
                        System.out.println(s1.getIme());
                    }
                }
            }
        });

        butSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                String userInput = String.valueOf(userText.getText());
                System.out.println(userInput);
                String passInput = String.valueOf(passText.getText());
                System.out.println(passInput);
                String roleInput = String.valueOf(roleText.getText());
                System.out.println(roleInput);

                /*for(korisnik k1:korisnici){
                    if(userInput.equals(k1.getUsername()) && passInput.equals(k1.getPassword()) && roleInput.equals(k1.getAdmin())){
                        System.out.println("Pass");
                    }
                }*/
                if(findUser(userInput,passInput,roleInput,databaseKorisnici)==true){
                    System.out.println("Logged");
                    if(roleInput.equals("Admin")){
                        adminView=1;
                    }
                    else{
                        studentView=1;
                    }
                    runThread(v);
                }
                else{
                    System.out.println("Wrong");
                }
            }
        });


        butAddPredmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                butAddStudent.setVisibility(v.GONE);
                //butSearch.setVisibility(v.GONE);
                //textAll.setVisibility(v.GONE);
                txpredmet.setVisibility(v.VISIBLE);
                txbrojKat.setVisibility(v.VISIBLE);
                txgodina.setVisibility(v.VISIBLE);
                butEnter2.setVisibility(v.VISIBLE);
                butAddPredmet.setVisibility(v.GONE);
                butStudentList.setVisibility(v.GONE);
                butGodine.setVisibility(v.GONE);
                spisakPredmeta.setVisibility(v.GONE);
                nazadGodina.setVisibility(v.VISIBLE);
            }
        });

        butEnter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String god = String.valueOf(txgodina.getText());
                izabranaGodina=god;
                String brojK = String.valueOf(txbrojKat.getText());
                imePredmeta = String.valueOf(txpredmet.getText());
                if(imePredmeta.equals("") || god.equals("") || brojK.equals("")){
                    System.out.println("Uneti sve");
                }
                else {
                    brojKat = Integer.parseInt(brojK);
                    int godExists = 0;

                    int exists = 0;
                    long parentId = 0;
                    loop1:
                    for (predmet p2 : predmeti) {
                        if (p2.getImePredmeta().equals(imePredmeta)) {
                            System.out.println("Nadjen predmet " + imePredmeta);
                            for (String god1 : p2.getGodina()) {
                                System.out.println("godina " + god1);
                                if (god1.equals(izabranaGodina)) {
                                    exists = 1;
                                    parentId = findPredmetName(p2.getImePredmeta(), databasePredmeti);
                                    break loop1;
                                }
                            }
                        }
                    }
                    System.out.println(god);
                    Cursor cursor = databaseGodine.query("godine", null, null, null, null, null, null);

                    while (cursor.moveToNext()) {
                        @SuppressLint("Range") String dostupnaGodina = cursor.getString(cursor.getColumnIndex("godina"));
                        System.out.println(dostupnaGodina);
                        if (god.equals(dostupnaGodina)) {
                            godExists = 1;
                        }
                    }
                    cursor.close();

                    if (brojKat < 0 || brojKat > 5) {
                        System.out.println("Error kategorija");
                        errorPopup.setVisibility(v.VISIBLE);
                        errorPopup.bringToFront();
                        errorPopup.setText("Los unos za katgorije - od 1 do 5");
                        errorClose.setVisibility(v.VISIBLE);
                        errorClose.bringToFront();
                    } else if (godExists == 0) {
                        System.out.println("Error godina");
                        errorPopup.setVisibility(v.VISIBLE);
                        errorPopup.bringToFront();
                        errorPopup.setText("Los unos za godinu");
                        errorClose.setVisibility(v.VISIBLE);
                        errorClose.bringToFront();
                    } else if (exists == 1) {
                        System.out.println("vec postoji");
                        errorPopup.setVisibility(v.VISIBLE);
                        errorPopup.bringToFront();
                        errorPopup.setText("Predmet sa godinom vec postoji");
                        errorClose.setVisibility(v.VISIBLE);
                        errorClose.bringToFront();
                    } else {

                        txpredmet.setVisibility(v.GONE);
                        txbrojKat.setVisibility(v.GONE);
                        txgodina.setVisibility(v.GONE);
                        butEnter2.setVisibility(v.GONE);
                        butEnter3.setVisibility(v.VISIBLE);
                        nazadGodina.setVisibility(v.GONE);
                        k1.setVisibility(v.VISIBLE);
                        k1min.setVisibility(v.VISIBLE);
                        k1max.setVisibility(v.VISIBLE);
                        if (brojKat > 1) {
                            k2.setVisibility(v.VISIBLE);
                            k2min.setVisibility(v.VISIBLE);
                            k2max.setVisibility(v.VISIBLE);
                        }
                        if (brojKat > 2) {
                            k3.setVisibility(v.VISIBLE);
                            k3min.setVisibility(v.VISIBLE);
                            k3max.setVisibility(v.VISIBLE);
                        }
                        if (brojKat > 3) {
                            k4.setVisibility(v.VISIBLE);
                            k4min.setVisibility(v.VISIBLE);
                            k4max.setVisibility(v.VISIBLE);
                        }
                        if (brojKat > 4) {
                            k5.setVisibility(v.VISIBLE);
                            k5min.setVisibility(v.VISIBLE);
                            k5max.setVisibility(v.VISIBLE);
                        }
                    }
                }
            }
        });

        butEnter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long parentId=0;
                int sum[]=new int[] {0,0,0,0,0};
                int min[]=new int[] {0,0,0,0,0};
                int error=0;
                int exists=0;

                System.out.println(izabranaGodina);


                for (predmet p2 : predmeti) {
                    if (p2.getImePredmeta().equals(imePredmeta)) {
                        System.out.println("Nadjen predmet " + imePredmeta);
                        exists = 1;
                        parentId = findPredmetName(p2.getImePredmeta(), databasePredmeti);
                        System.out.println("ID parent je "+parentId);
                        break;
                    }
                }


                if(exists==0) {
                    System.out.println("Inserting");
                    ContentValues parentValues = new ContentValues();
                    parentValues.put(ParentTablePredmeti.COLUMN_IMEPREDMETA, imePredmeta);
                    parentId = databasePredmeti.insert(ParentTablePredmeti.TABLE_NAME, null, parentValues);
                    System.out.println("ID parent je "+parentId);
                }

                ContentValues childValues = new ContentValues();
                childValues.put(ChildTablePredmeti.COLUMN_PARENT_ID, parentId);
                childValues.put(ChildTablePredmeti.COLUMN_GODINA, String.valueOf(izabranaGodina));
                System.out.println("unos godine "+String.valueOf(izabranaGodina));
                childValues.put(ChildTablePredmeti.COLUMN_K1, String.valueOf(k1.getText()));
                System.out.println("unos bodova "+String.valueOf(k1.getText()));
                childValues.put(ChildTablePredmeti.COLUMN_MIN1, String.valueOf(k1min.getText()));
                childValues.put(ChildTablePredmeti.COLUMN_MAX1, String.valueOf(k1max.getText()));
                try{
                    min[0]= Integer.parseInt(String.valueOf(k1min.getText()));
                    sum[0]= Integer.parseInt(String.valueOf(k1max.getText()));
                }
                catch (Exception e){
                    System.out.println("Uneti INT");
                    error=1;
                }

                if (brojKat > 1) {
                    childValues.put(ChildTablePredmeti.COLUMN_K2, String.valueOf(k2.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MIN2, String.valueOf(k2min.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MAX2, String.valueOf(k2max.getText()));
                    try{
                        min[1]= Integer.parseInt(String.valueOf(k2min.getText()));
                        sum[1]= Integer.parseInt(String.valueOf(k2max.getText()));
                    }
                    catch (Exception e){
                        System.out.println("Uneti INT");
                    }
                }
                if (brojKat > 2) {
                    childValues.put(ChildTablePredmeti.COLUMN_K3, String.valueOf(k3.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MIN3, String.valueOf(k3min.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MAX3, String.valueOf(k3max.getText()));
                    try{
                        min[2]= Integer.parseInt(String.valueOf(k3min.getText()));
                        sum[2]= Integer.parseInt(String.valueOf(k3max.getText()));
                    }
                    catch (Exception e){
                        System.out.println("Uneti INT");
                        error=1;
                    }
                }
                if (brojKat > 3) {
                    childValues.put(ChildTablePredmeti.COLUMN_K4, String.valueOf(k4.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MIN4, String.valueOf(k4min.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MAX4, String.valueOf(k4max.getText()));
                    try{
                        min[3]= Integer.parseInt(String.valueOf(k4min.getText()));
                        sum[3]= Integer.parseInt(String.valueOf(k4max.getText()));
                    }
                    catch (Exception e){
                        System.out.println("Uneti INT");
                        error=1;
                    }
                }
                if (brojKat > 4) {
                    childValues.put(ChildTablePredmeti.COLUMN_K5, String.valueOf(k5.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MIN5, String.valueOf(k5min.getText()));
                    childValues.put(ChildTablePredmeti.COLUMN_MAX5, String.valueOf(k5max.getText()));
                    try{
                        min[4]= Integer.parseInt(String.valueOf(k5min.getText()));
                        sum[4]= Integer.parseInt(String.valueOf(k5max.getText()));
                    }
                    catch (Exception e){
                        System.out.println("Uneti INT");
                        error=1;
                    }
                }
                if(min[0]>sum[0] ||min[1]>sum[1] ||min[2]>sum[2] ||min[3]>sum[3] ||min[4]>sum[4]){
                    error=1;
                }
                if((sum[0]+sum[1]+sum[2]+sum[3]+sum[3])!=100){
                    error=1;
                }

                if(error==0) {
                    databasePredmeti.insert(ChildTablePredmeti.TABLE_NAME, null, childValues);
                    writeDatabaseContent(databasePredmeti);

                    // Code to be executed when the button is clicked
                    k1.setVisibility(v.GONE);
                    k1min.setVisibility(v.GONE);
                    k1max.setVisibility(v.GONE);
                    k2.setVisibility(v.GONE);
                    k2min.setVisibility(v.GONE);
                    k2max.setVisibility(v.GONE);
                    k3.setVisibility(v.GONE);
                    k3min.setVisibility(v.GONE);
                    k3max.setVisibility(v.GONE);
                    k4.setVisibility(v.GONE);
                    k4min.setVisibility(v.GONE);
                    k4max.setVisibility(v.GONE);
                    k5.setVisibility(v.GONE);
                    k5min.setVisibility(v.GONE);
                    k5max.setVisibility(v.GONE);


                    //butSearch.setVisibility(v.VISIBLE);
                    butAddStudent.setVisibility(v.VISIBLE);
                    //textAll.setVisibility(v.VISIBLE);
                    butAddPredmet.setVisibility(v.VISIBLE);
                    butStudentList.setVisibility(v.VISIBLE);
                    butGodine.setVisibility(v.VISIBLE);
                    spisakPredmeta.setVisibility(v.VISIBLE);
                    butEnter3.setVisibility(v.GONE);
                }

            }
        });

    }



    private boolean findUser(String username, String password, String role, SQLiteDatabase database){

        // Define the selection criteria
        String selection = columnNameUser + " = ? AND " + columnNamePass + " = ? AND " + columnNameRole +  " = ?";
        String[] selectionArgs = { username, password, role };

        // Perform the query
        Cursor cursor = database.query(
                tableNameKorisnici,         // The table to query
                null,              // Retrieve all columns
                selection,         // The columns for the WHERE clause
                selectionArgs,     // The values for the WHERE clause
                null,              // Don't group the rows
                null,              // Don't filter by row groups
                null               // No sort order needed
        );

        // Check if the cursor has data
        boolean userFound = cursor != null && cursor.moveToFirst();

        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }

        return userFound;

    }

    private boolean findUser(String username, SQLiteDatabase database){

        // Define the selection criteria
        String selection = columnNameUser + " = ?";
        String[] selectionArgs = { username};

        // Perform the query
        Cursor cursor = database.query(
                tableNameKorisnici,         // The table to query
                null,              // Retrieve all columns
                selection,         // The columns for the WHERE clause
                selectionArgs,     // The values for the WHERE clause
                null,              // Don't group the rows
                null,              // Don't filter by row groups
                null               // No sort order needed
        );

        // Check if the cursor has data
        boolean userFound = cursor != null && cursor.moveToFirst();

        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }

        return userFound;

    }

    public void readAllEntriesKorisnici(SQLiteDatabase database) {

        // Define the columns you want to retrieve (null to retrieve all columns)
        String[] projection = {
                columnNameUser,
                columnNamePass,
                columnNameRole
        };

        Cursor cursor = database.query(
                tableNameKorisnici,     // The table to query
                projection,    // The columns to return
                null,          // No columns for the WHERE clause
                null,          // No values for the WHERE clause
                null,          // Don't group the rows
                null,          // Don't filter by row groups
                null           // No sort order needed
        );

        // Check if the cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve data from the cursor
                String username = cursor.getString(cursor.getColumnIndexOrThrow(columnNameUser));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(columnNamePass));
                String role = cursor.getString(cursor.getColumnIndexOrThrow(columnNameRole));
                int exists=0;
                korisnik k1 = new korisnik(username,password,role);
                for(korisnik k2:korisnici){
                    if(k2.getUsername().equals(k1.getUsername())){
                        exists=1;
                    }
                }
                if(exists==0) {
                    korisnici.add(k1);
                }
            } while (cursor.moveToNext());
        }

        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }


    }


    public void readAllEntriesGodine(SQLiteDatabase database) {

        // Define the columns you want to retrieve (null to retrieve all columns)
        String[] projection = {
                "godina"
        };

        Cursor cursor = database.query(
                "godine",     // The table to query
                projection,    // The columns to return
                null,          // No columns for the WHERE clause
                null,          // No values for the WHERE clause
                null,          // Don't group the rows
                null,          // Don't filter by row groups
                null           // No sort order needed
        );

        // Check if the cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve data from the cursor
                String godina = cursor.getString(cursor.getColumnIndexOrThrow("godina"));
                int exists=0;
                int j;
                for(j=0;j<50;j++){
                    if(godineDBNiz[j].equals("")){
                        break;
                    }
                    if(godina.equals(godineDBNiz[j])){
                        exists=1;
                    }
                }
                if(exists==0) {
                    godineDBNiz[j]=godina;
                    System.out.println("Clan "+j);
                    System.out.println(godineDBNiz[j]);
                }
            } while (cursor.moveToNext());
        }

        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }


    }

    public void readAllEntriesStudenti(SQLiteDatabase database) {

        // Define the columns you want to retrieve (null to retrieve all columns)
        String[] parentProjection = {
                ParentTableStudenti.COLUMN_USER,
                ParentTableStudenti.COLUMN_IME,
                ParentTableStudenti.COLUMN_PREZIME,
                ParentTableStudenti.COLUMN_JMBG,
                ParentTableStudenti.COLUMN_INDEKS,
                ParentTableStudenti.COLUMN_ID
        };

        Cursor cursor = database.query(
                ParentTableStudenti.TABLE_NAME,
                parentProjection,
                null,
                null,
                null,
                null,
                null
        );

        // Check if the cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve data from the cursor
                String ime = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_IME));
                String user =cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_USER));
                String prezime = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_PREZIME));
                String jmbg = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_JMBG));
                String indeks = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_INDEKS));
                String parentId = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_ID));
                System.out.println("parent ID "+parentId);

                student s1 = new student(ime, prezime, jmbg, indeks, user);

                int exists=0;
                int ind=0;
                for(student s2:studenti){
                    if(s2.getJmbg().equals(s1.getJmbg())){
                        System.out.println(s1.getIme()+ " vec postoji");
                        exists=1;
                        break;
                    }
                    ind++;
                }
                if(exists==0) {
                    System.out.println("dodao studenta " + s1.getIme());
                    studenti.add(s1);
                }

                String[] childProjection = {
                        ChildTableStudenti.COLUMN_PARENT_ID,ChildTableStudenti.COLUMN_IMEPREDMETA, ChildTableStudenti.COLUMN_GODINA, ChildTableStudenti.COLUMN_OSV1
                        , ChildTableStudenti.COLUMN_OSV2, ChildTableStudenti.COLUMN_OSV3, ChildTableStudenti.COLUMN_OSV4
                        , ChildTableStudenti.COLUMN_OSV5
                };

                String childSelection = ChildTableStudenti.COLUMN_PARENT_ID + " = ?";
                String[] childSelectionArgs = {parentId};
                System.out.println(parentId);

                Cursor childCursor = database.query(
                        ChildTableStudenti.TABLE_NAME,
                        childProjection,
                        childSelection,
                        childSelectionArgs,
                        null,
                        null,
                        null
                );
                int predmetCnt=0;
                if (childCursor != null && childCursor.moveToFirst()) {
                    do {
                        String imePredmeta = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_IMEPREDMETA));
                        if(imePredmeta!=null) {
                            String godina = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_GODINA));
                            String osv1 = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_OSV1));
                            String osv2 = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_OSV2));
                            String osv3 = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_OSV3));
                            String osv4 = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_OSV4));
                            String osv5 = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTableStudenti.COLUMN_OSV5));
                            System.out.println(ime + " " + imePredmeta + " " + godina + " " + osv1);




                            int osvBodovi[]=new int[6];
                            int brojKategorija=1;
                            if(osv1!=null && !osv1.equals("")){
                                int osvBod1= Integer.parseInt(osv1);
                                osvBodovi[0]=osvBod1;
                            }

                            if(osv2!=null && !osv2.equals("")){
                                int osvBod2= Integer.parseInt(osv2);
                                osvBodovi[1]=osvBod2;
                                brojKategorija++;
                            }
                            if(osv3!=null && !osv3.equals("")){
                                int osvBod3= Integer.parseInt(osv3);
                                osvBodovi[2]=osvBod3;
                                brojKategorija++;
                            }
                            if(osv4!=null && !osv4.equals("")){
                                int osvBod4= Integer.parseInt(osv4);
                                osvBodovi[3]=osvBod4;
                                brojKategorija++;
                            }
                            if(osv5!=null && !osv5.equals("")){
                                int osvBod5= Integer.parseInt(osv5);
                                osvBodovi[4]=osvBod5;
                                brojKategorija++;
                            }

                            //osvBodovi = "k1" + osv1 + "k2" + osv2 + "k3" + osv3 + "k4" + osv4 + "k5" + osv5;
                            System.out.println("Osvojeni bodovi " + osvBodovi[0]);
                            int predmetExists=0;
                            if (exists == 0) {

                                for(String pr1:s1.getPredmeti()){
                                    if(pr1.equals(imePredmeta)){
                                        if(s1.getGodina(predmetCnt).equals(godina)) {
                                            s1.removeBodovi(predmetCnt);
                                            s1.removePolozeno(predmetCnt);
                                            s1.addBodovi(predmetCnt, osvBodovi);
                                            s1.addPolozeno(predmetCnt);
                                            predmetExists = 1;
                                            break;
                                        }
                                    }
                                    predmetCnt++;
                                }
                                if(predmetExists==0) {
                                    System.out.println("novi predmet novog studenta");
                                    s1.addPredmet(imePredmeta);
                                    s1.addGodina(godina);
                                    s1.addBodovi(osvBodovi);
                                    s1.addPolozeno();
                                }
                            } else {
                                for(String pr1:studenti.get(ind).getPredmeti()){
                                    if(pr1.equals(imePredmeta)){
                                        if(studenti.get(ind).getGodina(predmetCnt).equals(godina)) {
                                            studenti.get(ind).removeBodovi(predmetCnt);
                                            studenti.get(ind).removePolozeno(predmetCnt);
                                            studenti.get(ind).addBodovi(predmetCnt, osvBodovi);
                                            studenti.get(ind).addPolozeno(predmetCnt);
                                            predmetExists = 1;
                                            break;
                                        }
                                    }
                                    predmetCnt++;
                                }
                                if(predmetExists==0) {
                                    studenti.get(ind).addPredmet(imePredmeta);
                                    studenti.get(ind).addGodina(godina);
                                    studenti.get(ind).addBodovi(osvBodovi);
                                    studenti.get(ind).addPolozeno();
                                }
                            }
                        }
                    } while (childCursor.moveToNext());
                }

                // Close the child cursor
                if (childCursor != null) {
                    childCursor.close();
                }


            } while (cursor.moveToNext());
        }
        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }
        Arrays.fill(studentiNiz,"");
        for(int i=0;i<studenti.size();i++){
            studentiNiz[i]="Ime: "+studenti.get(i).getIme()+", prezime: "+studenti.get(i).getPrezime()+", jmbg: "+studenti.get(i).getJmbg()+", indeks: "+studenti.get(i).getIndeks();
        }
    }

    private void runThread(View v) {

        new Thread() {
            public void run() {
                while (true) {
                    if(adminView==1){

                        adminView=0;
                    }
                }
            }
        }.start();
    }


    private void threadError(View v) {

        new Thread() {
            public void run() {
                try {
                    v.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
    public void writeDatabaseContent(SQLiteDatabase db) {

        // Query the parent table
        String[] parentProjection = {
                ParentTablePredmeti.COLUMN_ID,
                ParentTablePredmeti.COLUMN_IMEPREDMETA
        };

        Cursor parentCursor = db.query(
                ParentTablePredmeti.TABLE_NAME,
                parentProjection,
                null,
                null,
                null,
                null,
                null
        );

        // Loop through parent table cursor
        if (parentCursor != null && parentCursor.moveToFirst()) {
            do {
                int parentId = parentCursor.getInt(parentCursor.getColumnIndexOrThrow(ParentTablePredmeti.COLUMN_ID));
                String parentName = parentCursor.getString(parentCursor.getColumnIndexOrThrow(ParentTablePredmeti.COLUMN_IMEPREDMETA));

                // Print parent table values
                System.out.println("Parent "+ "ID: " + parentId + ", Name: " + parentName);

                predmet p1 = new predmet(parentName);

                int exists=0;
                int ind=0;
                for(predmet p2:predmeti){
                    if(p2.getImePredmeta().equals(p1.getImePredmeta())){
                        System.out.println("Predmet "+parentName+" postoji");
                        exists=1;
                        break;
                    }
                    ind++;
                }
                if(exists==0){
                    System.out.println("Predmet+parentName+ne postoji");
                }

                // Query the child table based on parent ID
                String[] childProjection = {
                        ChildTablePredmeti.COLUMN_PARENT_ID,ChildTablePredmeti.COLUMN_GODINA, ChildTablePredmeti.COLUMN_K1, ChildTablePredmeti.COLUMN_MIN1
                        , ChildTablePredmeti.COLUMN_MAX1, ChildTablePredmeti.COLUMN_K2, ChildTablePredmeti.COLUMN_MIN2
                        , ChildTablePredmeti.COLUMN_MAX2, ChildTablePredmeti.COLUMN_K3, ChildTablePredmeti.COLUMN_MIN3
                        , ChildTablePredmeti.COLUMN_MAX3, ChildTablePredmeti.COLUMN_K4, ChildTablePredmeti.COLUMN_MIN4
                        , ChildTablePredmeti.COLUMN_MAX4, ChildTablePredmeti.COLUMN_K5, ChildTablePredmeti.COLUMN_MIN5
                        , ChildTablePredmeti.COLUMN_MAX5
                };

                String childSelection = ChildTablePredmeti.COLUMN_PARENT_ID + " = ?";
                String[] childSelectionArgs = {String.valueOf(parentId)};

                Cursor childCursor = db.query(
                        ChildTablePredmeti.TABLE_NAME,
                        childProjection,
                        childSelection,
                        childSelectionArgs,
                        null,
                        null,
                        null
                );

                // Loop through child table cursor
                if (childCursor != null && childCursor.moveToFirst()) {
                    do {
                        String childValue = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_GODINA));
                        String[] kategorije = new String[5];
                        String[] minBod = new String[5];
                        String[] maxBod = new String[5];

                        int existsGodina=0;

                        if(exists==1){
                            for(String godina:predmeti.get(ind).getGodina()){
                                if(godina.equals(childValue)){
                                    existsGodina=1;
                                }
                            }
                        }

                        if(existsGodina==0) {

                            kategorije[0] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K1));
                            System.out.println("prva kat" + childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K1)));
                            kategorije[1] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K2));
                            kategorije[2] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K3));
                            kategorije[3] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K4));
                            kategorije[4] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_K5));

                            minBod[0] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MIN1));
                            minBod[1] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MIN2));
                            minBod[2] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MIN3));
                            minBod[3] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MIN4));
                            minBod[4] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MIN5));

                            maxBod[0] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MAX1));
                            maxBod[1] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MAX2));
                            maxBod[2] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MAX3));
                            maxBod[3] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MAX4));
                            maxBod[4] = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_MAX5));
                            // Print child table values
                            System.out.println("Child " + "Parent ID: " + parentId + ", Value: " + childValue);
                            if (exists == 0) {
                                p1.addGodina(childValue);
                                p1.addKat(kategorije);
                                p1.addMax(maxBod);
                                p1.addMin(minBod);
                                predmeti.add(p1);
                                System.out.println("Nov dodat u klasu");
                                for (String pr1 : p1.getGodina()) {
                                    System.out.println(pr1);
                                }
                                exists=1;
                            } else {
                                predmeti.get(ind).addGodina(childValue);
                                predmeti.get(ind).addKat(kategorije);
                                predmeti.get(ind).addMax(maxBod);
                                predmeti.get(ind).addMin(minBod);

                                System.out.println("Stari dodat u klasu");
                                for (String pr1 : predmeti.get(ind).getGodina()) {
                                    System.out.println("godina "+pr1);
                                }
                            }
                        }

                    } while (childCursor.moveToNext());
                }

                // Close the child cursor
                if (childCursor != null) {
                    childCursor.close();
                }

            } while (parentCursor.moveToNext());
        }

        // Close the parent cursor and the database connection
        if (parentCursor != null) {
            parentCursor.close();
        }

        for(int i=0;i<predmeti.size();i++){
            predmetiNiz[i]=predmeti.get(i).getImePredmeta();
        }
        //db.close();
    }

    public int findPredmetName(String imePredmeta,SQLiteDatabase database){
        String selection = ParentTablePredmeti.COLUMN_IMEPREDMETA + " = ?";
        String[] selectionArgs = {imePredmeta};
        int key=0;
        Cursor cursor = database.query(
                "predmeti",
                new String[]{ParentTablePredmeti.COLUMN_ID},
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int primaryKey = cursor.getInt(cursor.getColumnIndex(ParentTablePredmeti.COLUMN_ID));
            key = primaryKey;
            // Use the primary key value as needed
        } else {
            // No matching record found
        }

        cursor.close();
        return key;
    }

    public void findPredmetKategorije(String imePredmeta,SQLiteDatabase db) {

        // Query the parent table

        String selection = ParentTablePredmeti.COLUMN_IMEPREDMETA + " = ?";
        String[] selectionArgs = {imePredmeta};

        String[] parentProjection = {
                ParentTablePredmeti.COLUMN_ID,
                ParentTablePredmeti.COLUMN_IMEPREDMETA
        };

        Cursor parentCursor = db.query(
                ParentTablePredmeti.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        Arrays.fill(godineNiz,"");
        // Loop through parent table cursor
        if (parentCursor != null && parentCursor.moveToFirst()) {
            do {
                int parentId = parentCursor.getInt(parentCursor.getColumnIndexOrThrow(ParentTablePredmeti.COLUMN_ID));
                String parentName = parentCursor.getString(parentCursor.getColumnIndexOrThrow(ParentTablePredmeti.COLUMN_IMEPREDMETA));

                // Print parent table values
                System.out.println("Parent "+ "ID: " + parentId + ", Name: " + parentName);

                // Query the child table based on parent ID
                String[] childProjection = {
                        ChildTablePredmeti.COLUMN_PARENT_ID, ChildTablePredmeti.COLUMN_GODINA
                };

                String childSelection = ChildTablePredmeti.COLUMN_PARENT_ID + " = ?";
                String[] childSelectionArgs = {String.valueOf(parentId)};

                Cursor childCursor = db.query(
                        ChildTablePredmeti.TABLE_NAME,
                        childProjection,
                        childSelection,
                        childSelectionArgs,
                        null,
                        null,
                        null
                );
                int i=0;
                // Loop through child table cursor
                if (childCursor != null && childCursor.moveToFirst()) {
                    do {
                        String childValue = childCursor.getString(childCursor.getColumnIndexOrThrow(ChildTablePredmeti.COLUMN_GODINA));
                        godineNiz[i]=childValue;
                        i++;
                        System.out.println("Child " + "Parent ID: " + parentId + ", Value: " + childValue);
                    } while (childCursor.moveToNext());
                }

                // Close the child cursor
                if (childCursor != null) {
                    childCursor.close();
                }

            } while (parentCursor.moveToNext());
        }

        // Close the parent cursor and the database connection
        if (parentCursor != null) {
            parentCursor.close();
        }
        //db.close();
    }

    public String findStudent(String jmbg,SQLiteDatabase db, int user) {

        // Query the parent table

        String selection = ParentTableStudenti.COLUMN_JMBG + " = ?";
        String[] selectionArgs = {jmbg};
        String parentId=new String();
        String username=new String();

        Cursor cursor = db.query(
                ParentTableStudenti.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                // Retrieve the value from the desired column
                @SuppressLint("Range") String foundValue = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_ID));
                @SuppressLint("Range") String userValue = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_USER));
                parentId=foundValue;
                username = userValue;
            } while (cursor.moveToNext());
        }
        if(user==1){
            return username;
        }
        else {
            return parentId;
        }
    }

    public String[] findStudentByUsername(String username,SQLiteDatabase db) {

        // Query the parent table

        String selection = ParentTableStudenti.COLUMN_USER + " = ?";
        String[] selectionArgs = {username};

        String podaci[]=new String[6];
        Cursor cursor = db.query(
                ParentTableStudenti.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                // Retrieve the value from the desired column
                @SuppressLint("Range") String ime = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_IME));
                @SuppressLint("Range") String pre = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_PREZIME));
                @SuppressLint("Range") String jmbg = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_JMBG));
                @SuppressLint("Range") String ind = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_INDEKS));
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(ParentTableStudenti.COLUMN_ID));
                podaci[0]=ime;
                podaci[1]=pre;
                podaci[2]=jmbg;
                podaci[3]=ind;
                podaci[4]=id;
            } while (cursor.moveToNext());
        }
        return podaci;
    }

    /*public void predmetiStudenta(String jmbg, SQLiteDatabase database) {

        // Define the columns you want to retrieve (null to retrieve all columns)
        String[] parentProjection = {
                ParentTableStudenti.COLUMN_IME,
                ParentTableStudenti.COLUMN_PREZIME,
                ParentTableStudenti.COLUMN_JMBG,
                ParentTableStudenti.COLUMN_INDEKS
        };

        Cursor cursor = database.query(
                ParentTableStudenti.TABLE_NAME,
                parentProjection,
                null,
                null,
                null,
                null,
                null
        );

        // Check if the cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve data from the cursor
                String ime = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_IME));
                String prezime = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_PREZIME));
                //String jmbg = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_JMBG));
                String indeks = cursor.getString(cursor.getColumnIndexOrThrow(ParentTableStudenti.COLUMN_INDEKS));

                student s1 = new student(ime, prezime, jmbg, indeks);

                int exists=0;
                for(student s2:studenti){
                    if(s2.getJmbg().equals(s1.getJmbg())){
                        exists=1;
                    }
                }
                if(exists==0) {
                    studenti.add(s1);
                }

            } while (cursor.moveToNext());
        }
        // Close the cursor after you're done with it
        if (cursor != null) {
            cursor.close();
        }
        for(int i=0;i<studenti.size();i++){
            studentiNiz[i]="Ime: "+studenti.get(i).getIme()+", prezime: "+studenti.get(i).getPrezime()+", jmbg: "+studenti.get(i).getJmbg()+", indeks: "+studenti.get(i).getIndeks();
        }
    }*/


}

