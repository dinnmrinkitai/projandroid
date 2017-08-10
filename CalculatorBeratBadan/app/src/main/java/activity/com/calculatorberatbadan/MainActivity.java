package activity.com.calculatorberatbadan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float height;
    private float weight;
    private float hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Hitung = (Button)findViewById(R.id.hitung);
        final EditText height_value = (EditText)findViewById(R.id.height);
        final EditText weight_value = (EditText)findViewById(R.id.weight);
        final TextView Result = (TextView) findViewById(R.id.Result);

        Hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height_value.getText().length()>0 == weight_value.getText().length()>0){
                    height = Float.parseFloat(height_value.getText().toString());
                    weight = Float.parseFloat(weight_value.getText().toString());
                    hasil = KalkulasiPerhitungan(height,weight);

                    if (hasil <16) {
                        Result.setText("Your hasil"+hasil+"Cungkring");
                    }else if (hasil<18.5){
                        Result.setText("Your hasil"+hasil+"Peot");
                    }else if (hasil<30){
                        Result.setText("Your hasil"+hasil+"Normal");
                    }else {
                        Result.setText("Your hasil"+hasil+"Obesitas");
                    }
                }
            }
        });
    }

    private float KalkulasiPerhitungan(float height, float weight) {
        height=(height/100);
        return (float) (weight/(height*height));
    }
}
