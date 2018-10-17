package hu.miskolc.uni.iit.atvalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Az alkalmazas fo activityje,
 * indulaskor letrehozza es beallitja a felhasznaloi feluletet és navigal koztuk,
 * valamint megvalositja a valutahoz es szamologephez szukseges metodusokat.
 * Created by TP on 2017. 03. 19..
 */
public class MainActivity extends AppCompatActivity {

    public static final String OSSZEADAS = "\u002B";
    public static final String KIVONAS = "\u2212";
    public static final String OSZTAS = "\u00F7";
    public static final String SZORZAS = "\u2715";
    public LinkedList<String> operatorok = new LinkedList<String>();
    public String kifejezes = "";
    private static final String API_URL = "http://openexchangerates.org/api/latest.json?app_id=936dbc4655bc482cb326830172d84b43";
    TabHost tabHost;

    /**
     * Az activity indulasakor lefuto metodus,
     * letrehozza a felhasznaloi feluletet.
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fomenu);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        Button atvalt = (Button)findViewById(R.id.buttonAtvalt);
        final EditText usdValue = (EditText) findViewById(R.id.editTextUSD);
        final TextView gbpValue = (TextView) findViewById(R.id.textViewGBP);
        final TextView eurValue = (TextView) findViewById(R.id.textViewEURO);
        final TextView hufValue = (TextView) findViewById(R.id.textViewHUF);
        final TextView audValue = (TextView) findViewById(R.id.textViewAUD);
        final TextView aedValue = (TextView) findViewById(R.id.textViewAED);
        final TextView afnValue = (TextView) findViewById(R.id.textViewAFN);
        final TextView bgnValue = (TextView) findViewById(R.id.textViewBGN);
        final TextView cadValue = (TextView) findViewById(R.id.textViewCAD);
        final TextView gmdValue = (TextView) findViewById(R.id.textViewGMD);
        final TextView rsdValue = (TextView) findViewById(R.id.textViewRSD);
        final TextView penValue = (TextView) findViewById(R.id.textViewPEN);
        final TextView pgkValue = (TextView) findViewById(R.id.textViewPGK);
        final TextView ronValue = (TextView) findViewById(R.id.textViewRON);
        final TextView rubValue = (TextView) findViewById(R.id.textViewRUB);
        final TextView sarValue = (TextView) findViewById(R.id.textViewSAR);
        final TextView uahValue = (TextView) findViewById(R.id.textViewUAH);
        final TextView uyuValue = (TextView) findViewById(R.id.textViewUYU);
        final TextView zarValue = (TextView) findViewById(R.id.textViewZAR);
        final DecimalFormat sajatForma = new DecimalFormat("###,###.###");
        atvalt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (!usdValue.getText().toString().equals("")) {
                    AsyncHttpClient client = new AsyncHttpClient();
                    client.get(API_URL, new AsyncHttpResponseHandler() {

                        @Override
                        public void onFailure(Throwable arg0, String arg1) {
                            // TODO Auto-generated method stub
                            super.onFailure(arg0, arg1);
                        }

                        @Override
                        public void onFinish() {
                            // TODO Auto-generated method stub
                            super.onFinish();
                        }

                        @Override
                        public void onStart() {
                            // TODO Auto-generated method stub
                            super.onStart();
                        }

                        @Override
                        public void onSuccess(String response) {
                            Log.i("CHACHING", "HTTP Sucess");

                            try {
                                JSONObject jsonObj = new JSONObject(response);
                                JSONObject ratesObject = jsonObj
                                        .getJSONObject("rates");

                                Double gbpRate = ratesObject.getDouble("GBP");
                                Double eurRate = ratesObject.getDouble("EUR");
                                Double hufRate = ratesObject.getDouble("HUF");
                                Double audRate = ratesObject.getDouble("AUD");
                                Double aedRate = ratesObject.getDouble("AED");
                                Double afnRate = ratesObject.getDouble("AFN");
                                Double bgnRate = ratesObject.getDouble("BGN");
                                Double cadRate = ratesObject.getDouble("CAD");
                                Double gmdRate = ratesObject.getDouble("GMD");
                                Double rsdRate = ratesObject.getDouble("RSD");
                                Double penRate = ratesObject.getDouble("PEN");
                                Double pgkRate = ratesObject.getDouble("PGK");
                                Double ronRate = ratesObject.getDouble("RON");
                                Double rubRate = ratesObject.getDouble("RUB");
                                Double sarRate = ratesObject.getDouble("SAR");
                                Double uahRate = ratesObject.getDouble("UAH");
                                Double uyuRate = ratesObject.getDouble("UYU");
                                Double zarRate = ratesObject.getDouble("ZAR");
                                Log.i("CHACHING", "GBP: " + gbpRate);
                                Log.i("CHACHING", "EUR: " + eurRate);
                                Log.i("CHACHING", "HUF: " + hufRate);
                                Log.i("CHACHING", "AUD: " + audRate);
                                Log.i("CHACHING", "AED: " + aedRate);
                                Log.i("CHACHING", "AFN: " + afnRate);
                                Log.i("CHACHING", "BGN: " + bgnRate);
                                Log.i("CHACHING", "CAD: " + cadRate);
                                Log.i("CHACHING", "GMD: " + gmdRate);
                                Log.i("CHACHING", "RSD: " + rsdRate);
                                Log.i("CHACHING", "PEN: " + penRate);
                                Log.i("CHACHING", "PGK: " + pgkRate);
                                Log.i("CHACHING", "RON: " + ronRate);
                                Log.i("CHACHING", "RUB: " + rubRate);
                                Log.i("CHACHING", "SAR: " + sarRate);
                                Log.i("CHACHING", "UAH: " + uahRate);
                                Log.i("CHACHING", "UYU: " + uyuRate);
                                Log.i("CHACHING", "ZAR: " + zarRate);

                                Double usds = Double.valueOf(usdValue
                                        .getText().toString());
                                Double gbps = usds * gbpRate;
                                Double euros = usds * eurRate;
                                Double hufs = usds * hufRate;
                                Double auds = usds * audRate;
                                Double aeds = usds * aedRate;
                                Double afns = usds * afnRate;
                                Double bgns = usds * bgnRate;
                                Double cads = usds * cadRate;
                                Double gmds = usds * gmdRate;
                                Double rsds = usds * rsdRate;
                                Double pens = usds * penRate;
                                Double pgks = usds * pgkRate;
                                Double rons = usds * ronRate;
                                Double rubs = usds * rubRate;
                                Double sars = usds * sarRate;
                                Double uahs = usds * uahRate;
                                Double uyus = usds * uyuRate;
                                Double zars = usds * zarRate;
                                gbpValue.setText("GBP: "
                                        + String.valueOf(sajatForma.format(gbps)));
                                eurValue.setText("EURO: "
                                        + String.valueOf(sajatForma.format(euros)));
                                hufValue.setText("HUF: "
                                        + String.valueOf(sajatForma.format(hufs)));
                                audValue.setText("AUD: "
                                        + String.valueOf(sajatForma.format(auds)));
                                aedValue.setText("AED: "
                                        + String.valueOf(sajatForma.format(aeds)));
                                afnValue.setText("AFN: "
                                        + String.valueOf(sajatForma.format(afns)));
                                bgnValue.setText("BGN: "
                                        + String.valueOf(sajatForma.format(bgns)));
                                cadValue.setText("CAD: "
                                        + String.valueOf(sajatForma.format(cads)));
                                gmdValue.setText("GMD: "
                                        + String.valueOf(sajatForma.format(gmds)));
                                rsdValue.setText("RSD: "
                                        + String.valueOf(sajatForma.format(rsds)));
                                penValue.setText("PEN: "
                                        + String.valueOf(sajatForma.format(pens)));
                                pgkValue.setText("PGK: "
                                        + String.valueOf(sajatForma.format(pgks)));
                                ronValue.setText("RON: "
                                        + String.valueOf(sajatForma.format(rons)));
                                rubValue.setText("RUB: "
                                        + String.valueOf(sajatForma.format(rubs)));
                                sarValue.setText("SAR: "
                                        + String.valueOf(sajatForma.format(sars)));
                                uahValue.setText("UAH: "
                                        + String.valueOf(sajatForma.format(uahs)));
                                uyuValue.setText("UYU: "
                                        + String.valueOf(sajatForma.format(uyus)));
                                zarValue.setText("ZAR: "
                                        + String.valueOf(sajatForma.format(zars)));


                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Kérem írjon be egy értéket!",
                            Toast.LENGTH_LONG).show();

                }

            }
        });


        // android:layout_centerHorizontal="true"

        // Tab1 - Valuta
        TabHost.TabSpec spec = host.newTabSpec("Mértékegység");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Mértékegység");
        host.addTab(spec);

        // Tab2 - Mertekegyseg
        spec = host.newTabSpec("Valuta");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Valuta");
        host.addTab(spec);

        // Tab3 - Szamologep
        spec = host.newTabSpec("Számológép");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Számológép");
        host.addTab(spec);
    }

    /**
     * Letrehozza a beallitasok menujet az activity fejleceben.
     * @param menu Menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * A beallitasok kivalasztasakkor lefuto metodus.
     * @param item MenuItem
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Az activityk kozotti navigalast megvalosito metodus.
     * @param v View
     */
    public void onClick(View v)
    {
        int id = v.getId ();
        switch (id) {
            case R.id.button1 :
                Intent i1 = new Intent(getApplicationContext(), Tomeg.class);
                startActivity(i1);
                break;
            case R.id.button2 :
                Intent i2 = new Intent(getApplicationContext(), Hossz.class);
                startActivity(i2);
                break;
            case R.id.button3 :
                Intent i3 = new Intent(getApplicationContext(), Terulet.class);
                startActivity(i3);
                break;
            case R.id.button4 :
                Intent i4 = new Intent(getApplicationContext(), Szog.class);
                startActivity(i4);
                break;
            case R.id.button5 :
                Intent i5 = new Intent(getApplicationContext(), Homerseklet.class);
                startActivity(i5);
                break;
            case R.id.button6 :
                Intent i6 = new Intent(getApplicationContext(), Nyomas.class);
                startActivity(i6);
                break;
            case R.id.button7 :
                Intent i7 = new Intent(getApplicationContext(), Ero.class);
                startActivity(i7);
                break;
            case R.id.button8 :
                Intent i8 = new Intent(getApplicationContext(), FNyomatek.class);
                startActivity(i8);
                break;
            case R.id.button9 :
                Intent i9 = new Intent(getApplicationContext(), Tehetetlenseg.class);
                startActivity(i9);
                break;
            case R.id.button10 :
                Intent i10 = new Intent(getApplicationContext(), Suruseg.class);
                startActivity(i10);
                break;
            case R.id.button11 :
                Intent i11 = new Intent(getApplicationContext(), Hang.class);
                startActivity(i11);
                break;
            case R.id.button12 :
                Intent i12 = new Intent(getApplicationContext(), Terfogat.class);
                startActivity(i12);
                break;
            case R.id.button13 :
                Intent i13 = new Intent(getApplicationContext(), Sebesseg.class);
                startActivity(i13);
                break;
            case R.id.button14 :
                Intent i14 = new Intent(getApplicationContext(), Kijelzo.class);
                startActivity(i14);
                break;
            case R.id.button15 :
                Intent i15 = new Intent(getApplicationContext(), Kep.class);
                startActivity(i15);
                break;
            case R.id.button16 :
                Intent i16 = new Intent(getApplicationContext(), Adat.class);
                startActivity(i16);
                break;
            case R.id.button17 :
                Intent i17 = new Intent(getApplicationContext(), Toltes.class);
                startActivity(i17);
                break;
            case R.id.button18 :
                Intent i18 = new Intent(getApplicationContext(), Teljesitmeny.class);
                startActivity(i18);
                break;
            case R.id.button19 :
                Intent i19 = new Intent(getApplicationContext(), Aramerosseg.class);
                startActivity(i19);
                break;
            case R.id.button20 :
                Intent i20 = new Intent(getApplicationContext(), Energia.class);
                startActivity(i20);
                break;
            case R.id.button21 :
                Intent i21 = new Intent(getApplicationContext(), Ellenallas.class);
                startActivity(i21);
                break;
            case R.id.button22 :
                Intent i22 = new Intent(getApplicationContext(), Vezetokepesseg.class);
                startActivity(i22);
                break;
            case R.id.button23 :
                Intent i23 = new Intent(getApplicationContext(), Induktor.class);
                startActivity(i23);
                break;
            case R.id.button24 :
                Intent i24 = new Intent(getApplicationContext(), Sugarzas.class);
                startActivity(i24);
                break;
            default:
                break;
        }
    }

    /**
     * Az egyes operandusok, operatorok beolvasasa es eltarolasa.
     * @param view View
     */
    public void beolvas(View view)
    {
        switch(view.getId())
        {
            case R.id.button_0:
                operandustHozzaad("0");
                break;
            case R.id.button_1:
                operandustHozzaad("1");
                break;
            case R.id.button_2:
                operandustHozzaad("2");
                break;
            case R.id.button_3:
                operandustHozzaad("3");
                break;
            case R.id.button_4:
                operandustHozzaad("4");
                break;
            case R.id.button_5:
                operandustHozzaad("5");
                break;
            case R.id.button_6:
                operandustHozzaad("6");
                break;
            case R.id.button_7:
                operandustHozzaad("7");
                break;
            case R.id.button_8:
                operandustHozzaad("8");
                break;
            case R.id.button_9:
                operandustHozzaad("9");
                break;
            case R.id.buttonOsszead:
                operatortHozzaad(OSSZEADAS);
                break;
            case R.id.buttonKivon:
                operatortHozzaad(KIVONAS);
                break;
            case R.id.buttonOszt:
                operatortHozzaad(OSZTAS);
                break;
            case R.id.buttonSzoroz:
                operatortHozzaad(SZORZAS);
                break;
            case R.id.buttonTorol:
                torol();
                break;
        }
        megjelenit();
    }

    /**
     * Operatorok, operandusok es az eredmeny kiiratasa a szamologep kimenetere.
     */
    private void megjelenit()
    {
        TextView textview = (TextView) findViewById(R.id.kijelzo);
        textview.setText(kifejezes);
    }

    /**
     * Hiba kiiratasa a szamologep kimenetere.
     * @param str String
     */
    private void megjelenit(String str)
    {
        TextView textview = (TextView) findViewById(R.id.kijelzo);
        textview.setText(str);
    }

    /**
     * Operandus vizsgalata az esetleges hibak kiszuresevel, majd eltarolasa.
     * @param operandus String
     */
    private void operandustHozzaad(String operandus)
    {
        int operatorID = utolsoOperator();

        // Vizsgalat a felesleges nulla elkerulesere
        // Peldaul: 00 -> 0, 01 -> 1, 1+01 -> 1+1
        if (operatorID != kifejezes.length()-1 && kifejezes.charAt(operatorID+1) == '0') {
            if (kifejezes.endsWith("0")) {
                torol();
            }
        }
        kifejezes += operandus;
    }

    /**
     * Operator vizsgalata az esetleges hibak kiszuresevel, majd eltarolasa.
     * @param operator String
     */
    private void operatortHozzaad(String operator)
    {
        if (operatorralVegzodes()) {
            torol();
            kifejezes += operator;
            operatorok.add(operator);
        }
        else if (szammalVegzodes()) {
            kifejezes += operator;
            operatorok.add(operator);
        }
    }

    /**
     * A szamolando kifejezes vizsgalata annak szempontjabol, hogy szammal er-e a veget.
     * Matematikailag helyes kifejezes eseteben igaz ertekkel ter vissza.
     * @return boolean
     */
    private boolean szammalVegzodes()
    {
        boolean seged = kifejezes.length() > 0 && Character.isDigit(kifejezes.charAt(kifejezes.length()-1));
        return seged;
    }

    /**
     * A szamolando kifejezes vizsgalata annak szempontjabol, hogy muveleti jellel er-e a veget.
     * Matematikailag helyes kifejezes eseteben hamis ertekkel ter vissza.
     * @return boolean
     */
    private boolean operatorralVegzodes()
    {
        if (kifejezes.endsWith(OSSZEADAS) || kifejezes.endsWith(KIVONAS) || kifejezes.endsWith(SZORZAS) || kifejezes.endsWith(OSZTAS)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Az utolso operator indexenek meghatarozasa a kifejezesbol.
     * @return int
     */
    private int utolsoOperator()
    {
        int osszeadasID = kifejezes.lastIndexOf(OSSZEADAS);
        int kivonasID = kifejezes.lastIndexOf(KIVONAS);
        int szorzasID = kifejezes.lastIndexOf(SZORZAS);
        int osztasID = kifejezes.lastIndexOf(OSZTAS);
        int max = Math.max(osszeadasID, Math.max(kivonasID, Math.max(szorzasID, osztasID)));
        return max;
    }

    /**
     * A matematikai kifejezes ertelmezese es a kiszamolando kifejezesek
     * tovabbadasa a megfelelo metodusnak.
     * Vegul az eredmeny kiiratasa a kijelzore.
     * Egyszer hivodik meg, az egyenloseg jel hasznalatakor.
     * @param view View
     */
    public void szamol(View view)
    {
        if (operatorok.isEmpty()){
            return;
        }
        if (operatorralVegzodes())
        {
            megjelenit("Hiba!");
            alaphelyzet();
            return;
        }

        String[] operands = kifejezes.split("\\u002B|\\u2212|\\u00F7|\\u2715");

        int i = 0;
        double d = Double.parseDouble(operands[i]);
        for (String operator : operatorok)
            d = eredmeny(operator, d, Double.parseDouble(operands[++i]));

        DecimalFormat decimalformat = new DecimalFormat("0.###");
        megjelenit(decimalformat.format(d));
        alaphelyzet();
    }

    /**
     * Az egyes reszeredmenyek kiszamitasa.
     * @param operator String
     * @param operand1 double
     * @param operand2 double
     * @return double
     */
    private double eredmeny(String operator, double operand1, double operand2)
    {
        if (operator.equals(OSSZEADAS)) {
            return operand1 + operand2;
        }
        if (operator.equals(KIVONAS)) {
            return operand1 - operand2;
        }
        if (operator.equals(SZORZAS)) {
            return operand1 * operand2;
        }
        if (operator.equals(OSZTAS)) {
            return operand1 / operand2;
        }
        return 0.0;
    }

    /**
     * A kifejezes utolso karakterenek torlese.
     */
    private void torol()
    {
        if (kifejezes.length() > 0) {
            if (operatorralVegzodes()) {
                operatorok.removeLast();
            }
            kifejezes = kifejezes.substring(0, kifejezes.length()-1);
        }
    }

    /**
     * A szamologep alaphelyzetbe allitasa,
     * a kifejezes es az operatorok listajanak kiuritese.
     */
    private void alaphelyzet()
    {
        kifejezes = "";
        operatorok.clear();
    }
}