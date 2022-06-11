package group7.com.quanlytiensan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStadiumActivity extends AppCompatActivity {
    private EditText edtIdSan, edtIdChuSan,edtTenChuSan,edtGia,edtDiaChi,edtTenSan;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stadium);
        edtIdSan = findViewById(R.id.idSan);
        edtTenSan=findViewById(R.id.idTenSan);
        edtIdChuSan = findViewById(R.id.id_ChuSan);
        edtTenChuSan = findViewById(R.id.idTenChuSan);
        edtGia = findViewById(R.id.idGia);
        edtDiaChi = findViewById(R.id.idDiaChi);
        btnAdd=findViewById(R.id.idBtnAddStadium);

       // Intent intent1=getIntent();


            String idSan=edtIdSan.getText().toString();
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef= database.getReference("listSan/"+edtIdSan.getText().toString());

                    San s=new San();
                    s.setId_San(edtIdSan.getText().toString());
                    s.setId_ChuSan(edtIdChuSan.getText().toString());
                    s.setTenSan(edtTenSan.getText().toString());
                    s.setGia(edtGia.getText().toString());
                    s.setDiaChi(edtDiaChi.getText().toString());

                    myRef.setValue(s, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            Toast.makeText(AddStadiumActivity.this,"Push Data Succes",Toast.LENGTH_LONG).show();
                        }
                    });

                }
            });

        }

    }


