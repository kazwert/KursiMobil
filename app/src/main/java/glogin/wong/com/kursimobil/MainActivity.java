package glogin.wong.com.kursimobil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivA1,ivB1,ivB2,ivB3,ivC1,ivC2,ivC3,ivDriver;
    private Button btnOrder;

    private ArrayList<String> choosenSeats;

    private boolean a1,b1,b2,b3,c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivA1 = findViewById(R.id.iv_a1);
        ivB1 = findViewById(R.id.iv_b1);
        ivB2 = findViewById(R.id.iv_b2);
        ivB3 = findViewById(R.id.iv_b3);
        ivC1 = findViewById(R.id.iv_c1);
        ivC2 = findViewById(R.id.iv_c2);
        ivC3 = findViewById(R.id.iv_c3);
        ivDriver = findViewById(R.id.iv_driver);


        btnOrder = findViewById(R.id.btn_order);

        ivA1.setOnClickListener(this);
        ivB1.setOnClickListener(this);
        ivB2.setOnClickListener(this);
        ivB3.setOnClickListener(this);
        ivC1.setOnClickListener(this);
        ivC2.setOnClickListener(this);
        ivC3.setOnClickListener(this);
        btnOrder.setOnClickListener(this);

        choosenSeats = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_a1:
                isChoosed(ivA1,"a1",a1);
                a1 = !a1;
                break;
            case R.id.iv_b1:
                isChoosed(ivB1,"b1",b1);
                b1 = !b1;
                break;
            case R.id.iv_b2:
                isChoosed(ivB2,"b2",b2);
                b2 =!b2;
                break;
            case R.id.iv_b3:
                isChoosed(ivB3,"b3",b3);
                b3 = !b3;
                break;
            case R.id.iv_c1:
                isChoosed(ivC1,"c1",c1);
                c1 = !c1;
                break;
            case R.id.iv_c2:
                isChoosed(ivC2,"c2",c2);
                c2 = !c2;
                break;
            case R.id.iv_c3:
                isChoosed(ivC3,"c3",c3);
                c3 =!c3;
                break;
            case R.id.iv_driver:
                reset();
                break;
            case R.id.btn_order:
                countPrize();
                break;
        }

    }

    private void reset() {

    }

    private void countPrize() {
        int prize = 0;
        for (String seat : choosenSeats){
            String s = seat.substring(0, 1);
            if (s.equalsIgnoreCase("a")){
                prize += 50000;
            } else if (s.equalsIgnoreCase("b")){
                prize += 45000;
            } else {
                prize += 31000;
            }
        }
        if (choosenSeats.size() >0){
            showToast("Total Harga "+prize);
        } else {
            showToast("Anda belum memilih kursi");
        }

    }

    private void isChoosed(ImageView iv, String choosenCode,boolean isChecked) {
        if (isChecked){
            choosenSeats.remove(choosenCode);
            iv.setImageResource(R.drawable.ic_accessible_black_24dp);
        } else {
            choosenSeats.add(choosenCode);
            iv.setImageResource(R.drawable.ic_accessible_orange_500_24dp);
        }
    }

    public void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
