package hu.miskolc.uni.iit.atvalto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Az ellenallas mertekegysegei kozotti atvaltast megvalosito osztaly.
 * Created by TP on 2017. 03. 19..
 */
public class Ellenallas extends AppCompatActivity implements Konvertal, AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner SpinnerMit;
    private Spinner SpinnerMibe;
    private Button button;
    private String mit;
    private String mibe;
    private TextView kimenet;
    private TextView bemenet;
    public String kifejezes = "";

    /**
     * Az activity indulasakor lefuto metodus,
     * letrehozza a felhasznaloi feluletet.
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity21);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SpinnerMit = (Spinner)findViewById(R.id.spinner);
        SpinnerMit.setOnItemSelectedListener(this);
        SpinnerMibe = (Spinner)findViewById(R.id.spinner2);
        SpinnerMibe.setOnItemSelectedListener(this);

        button = (Button)findViewById(R.id.button_atvalt_ellenallas);
        button.setOnClickListener(this);

        bemenet = (TextView) findViewById(R.id.adat_be_ellenallas);
        kimenet = (TextView) findViewById(R.id.adat_ki_ellenallas);
    }

    /**
     * A ket mertekegyseg kozotti atalakitast vegzo metodus.
     * @param mit String
     * @param mibe String
     * @param bemenet double
     * @return double
     */
    public double Atalakit(String mit, String mibe, double bemenet) {

        if(mit.equals("terabyte") && mibe.equals("gigabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("terabyte") && mibe.equals("megabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("terabyte") && mibe.equals("kilobyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("terabyte") && mibe.equals("byte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("terabyte") && mibe.equals("bit")){
            double eredmeny = bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("gigabyte") && mibe.equals("terabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("gigabyte") && mibe.equals("megabyte")){
            double eredmeny = bemenet*100;
            return eredmeny;
        }
        if(mit.equals("gigabyte") && mibe.equals("kilobyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("gigabyte") && mibe.equals("byte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("gigabyte") && mibe.equals("bit")){
            double eredmeny = bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("megabyte") && mibe.equals("terabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("megabyte") && mibe.equals("gigabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("megabyte") && mibe.equals("kilobyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("megabyte") && mibe.equals("byte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("megabyte") && mibe.equals("bit")){
            double eredmeny = bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("kilobyte") && mibe.equals("terabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("kilobyte") && mibe.equals("gigabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("kilobyte") && mibe.equals("megabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("kilobyte") && mibe.equals("byte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("kilobyte") && mibe.equals("bit")){
            double eredmeny = bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("byte") && mibe.equals("terabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("byte") && mibe.equals("gigabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("byte") && mibe.equals("megabyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("byte") && mibe.equals("kilobyte")){
            double eredmeny = bemenet;
            return eredmeny;
        }
        if(mit.equals("byte") && mibe.equals("bit")){
            double eredmeny = bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("bit") && mibe.equals("terabyte")){
            double eredmeny = bemenet*0.000000001;
            return eredmeny;
        }
        if(mit.equals("bit") && mibe.equals("gigabyte")){
            double eredmeny = bemenet*0.000001;
            return eredmeny;
        }
        if(mit.equals("bit") && mibe.equals("megabyte")){
            double eredmeny = bemenet*0.0001;
            return eredmeny;
        }
        if(mit.equals("bit") && mibe.equals("kilobyte")){
            double eredmeny = bemenet*0.001;
            return eredmeny;
        }
        if(mit.equals("bit") && mibe.equals("byte")){
            double eredmeny = bemenet*1000000000;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals(mibe)){
            return bemenet;
        }
        return 0.0;
    }

    /**
     * A kivalasztott mertekegyseg eltarolasa a felkinalt listabol.
     * @param parent AdapterView
     * @param view View
     * @param position int
     * @param id long
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view.getParent() == SpinnerMit){
            mit = (String)(SpinnerMit.getSelectedItem().toString());
        }
        if(view.getParent() == SpinnerMibe){
            mibe = (String)(SpinnerMibe.getSelectedItem().toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Az eredmeny gomb megnyomasakor meghivodo metodus. Meghatarozza az eredmenyt és
     * kiiratja a kijelzore.
     * @param v View
     */
    @Override
    public void onClick(View v) {
        if(v == button){
            if(!bemenet.getText().toString().equals("")){
                double in = Double.parseDouble(bemenet.getText().toString());
                double eredmeny = Atalakit(mit, mibe, in);
                kimenet.setText(Double.toString(eredmeny));
            }
            else {
                kimenet.setText("");
            }
        }
    }

    /**
     * Az operandusok beolvasasa es eltarolasa.
     * @param view View
     */
    public void beolvas(View view)
    {
        switch(view.getId())
        {
            case R.id.ellenallas_button_0:
                operandustHozzaad("0");
                break;
            case R.id.ellenallas_button_1:
                operandustHozzaad("1");
                break;
            case R.id.ellenallas_button_2:
                operandustHozzaad("2");
                break;
            case R.id.ellenallas_button_3:
                operandustHozzaad("3");
                break;
            case R.id.ellenallas_button_4:
                operandustHozzaad("4");
                break;
            case R.id.ellenallas_button_5:
                operandustHozzaad("5");
                break;
            case R.id.ellenallas_button_6:
                operandustHozzaad("6");
                break;
            case R.id.ellenallas_button_7:
                operandustHozzaad("7");
                break;
            case R.id.ellenallas_button_8:
                operandustHozzaad("8");
                break;
            case R.id.ellenallas_button_9:
                operandustHozzaad("9");
                break;
            case R.id.ellenallas_buttonTorol:
                torol();
                break;
        }
        megjelenit();
    }

    /**
     * Operandusok kiiratasa a kimenetere.
     */
    private void megjelenit()
    {
        TextView textview = (TextView) findViewById(R.id.adat_be_ellenallas);
        textview.setText(kifejezes);
    }

    /**
     * Operandus eltarolasa.
     * @param operandus String
     */
    private void operandustHozzaad(String operandus)
    {
        kifejezes += operandus;
    }

    /**
     * A kifejezes utolso karakterenek torlese.
     */
    private void torol()
    {
        if (kifejezes.length() > 0) {
            kifejezes = kifejezes.substring(0, kifejezes.length() - 1);
        }
    }
}
