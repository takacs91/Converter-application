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
 * A hosszusag mertekegysegei kozotti atvaltast megvalosito osztaly.
 * Created by TP on 2017. 03. 19..
 */
public class Hossz extends AppCompatActivity implements Konvertal, AdapterView.OnItemSelectedListener, View.OnClickListener {

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
        setContentView(R.layout.activity2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SpinnerMit = (Spinner)findViewById(R.id.spinner);
        SpinnerMit.setOnItemSelectedListener(this);
        SpinnerMibe = (Spinner)findViewById(R.id.spinner2);
        SpinnerMibe.setOnItemSelectedListener(this);

        button = (Button)findViewById(R.id.button_atvalt);
        button.setOnClickListener(this);

        bemenet = (TextView) findViewById(R.id.hossz_adat_be);
        kimenet = (TextView) findViewById(R.id.hossz_adat_ki);
    }

    /**
     * A ket mertekegyseg kozotti atalakitast vegzo metodus.
     * @param mit String
     * @param mibe String
     * @param bemenet double
     * @return double
     */
    public double Atalakit(String mit, String mibe, double bemenet) {
        if(mit.equals("kilométer(km)") && mibe.equals("méter(m)")){
            double eredmeny = bemenet*1000;
            return eredmeny;
        }
        if(mit.equals("kilométer(km)") && mibe.equals("deciméter(dm)")){
            double eredmeny = 10000*bemenet;
            return eredmeny;
        }
        if(mit.equals("kilométer(km)") && mibe.equals("centiméter(cm)")){
            double eredmeny = 100000*bemenet;
            return eredmeny;
        }
        if(mit.equals("kilométer(km)") && mibe.equals("milliméter(mm)")){
            double eredmeny = 1000000*bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("méter(m)") && mibe.equals("kilométer(km)")){
            double eredmeny = 0.001*bemenet;
            return eredmeny;
        }
        if(mit.equals("méter(m)") && mibe.equals("deciméter(dm)")){
            double eredmeny = 10*bemenet;
            return eredmeny;
        }
        if(mit.equals("méter(m)") && mibe.equals("centiméter(cm)")){
            double eredmeny = 100*bemenet;
            return eredmeny;
        }
        if(mit.equals("méter(m)") && mibe.equals("milliméter(mm)")){
            double eredmeny = 10000*bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("deciméter(dm)") && mibe.equals("kilométer(km)")){
            double eredmeny = 0.0001*bemenet;
            return eredmeny;
        }
        if(mit.equals("deciméter(dm)") && mibe.equals("méter(m)")){
            double eredmeny = 0.1*bemenet;
            return eredmeny;
        }
        if(mit.equals("deciméter(dm)") && mibe.equals("centiméter(cm)")){
            double eredmeny = 10*bemenet;
            return eredmeny;
        }
        if(mit.equals("deciméter(dm)") && mibe.equals("milliméter(mm)")){
            double eredmeny = 100*bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("centiméter(cm)") && mibe.equals("kilométer(km)")){
            double eredmeny = 0.00001*bemenet;
            return eredmeny;
        }
        if(mit.equals("centiméter(cm)") && mibe.equals("méter(m)")){
            double eredmeny = 0.01*bemenet;
            return eredmeny;
        }
        if(mit.equals("centiméter(cm)") && mibe.equals("deciméter(dm)")){
            double eredmeny = 0.1*bemenet;
            return eredmeny;
        }
        if(mit.equals("centiméter(cm)") && mibe.equals("milliméter(mm)")){
            double eredmeny = 10*bemenet;
            return eredmeny;
        }

        //----------------------------------------------------------

        if(mit.equals("milliméter(mm)") && mibe.equals("kilométer(km)")){
            double eredmeny = 0.000001*bemenet;
            return eredmeny;
        }
        if(mit.equals("milliméter(mm)") && mibe.equals("méter(m)")){
            double eredmeny = 0.001*bemenet;
            return eredmeny;
        }
        if(mit.equals("milliméter(mm)") && mibe.equals("deciméter(dm)")){
            double eredmeny = 0.01*bemenet;
            return eredmeny;
        }
        if(mit.equals("milliméter(mm)") && mibe.equals("centiméter(cm)")){
            double eredmeny = 0.1*bemenet;
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
            case R.id.Hossz_button_0:
                operandustHozzaad("0");
                break;
            case R.id.Hossz_button_1:
                operandustHozzaad("1");
                break;
            case R.id.Hossz_button_2:
                operandustHozzaad("2");
                break;
            case R.id.Hossz_button_3:
                operandustHozzaad("3");
                break;
            case R.id.Hossz_button_4:
                operandustHozzaad("4");
                break;
            case R.id.Hossz_button_5:
                operandustHozzaad("5");
                break;
            case R.id.Hossz_button_6:
                operandustHozzaad("6");
                break;
            case R.id.Hossz_button_7:
                operandustHozzaad("7");
                break;
            case R.id.Hossz_button_8:
                operandustHozzaad("8");
                break;
            case R.id.Hossz_button_9:
                operandustHozzaad("9");
                break;
            case R.id.Hossz_buttonTorol:
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
        TextView textview = (TextView) findViewById(R.id.hossz_adat_be);
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