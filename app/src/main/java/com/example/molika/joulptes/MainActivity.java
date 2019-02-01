package com.example.molika.joulptes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String PTESNAME_KEY = "ptesname";
    public static final String PTESLOCATION_KEY = "pteslocation";
    public static final String TAG = "Ptes";

    TextView mPtesTextView;
    Button mAddBtn;
    Button mDisplaybtn;

    private DocumentReference mDocref = FirebaseFirestore.getInstance().document("Ptes/Ptes detail");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPtesTextView = (TextView) findViewById(R.id.etxt_display);
        mAddBtn = (Button) findViewById(R.id.btn_add);
        mDisplaybtn = (Button) findViewById(R.id.btn_display);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ptnameview = (EditText) findViewById(R.id.etext_ptesname);
                EditText ptlocationview = (EditText) findViewById(R.id.etext_pteslocation);
                String ptnametext = ptnameview.getText().toString();
                String ptlocationtext = ptlocationview.getText().toString();

                if (ptnametext.isEmpty() || ptlocationtext.isEmpty()){
                    Map<String, Object> dataTosave = new HashMap<String, Object>();
                    dataTosave.put(PTESNAME_KEY, ptnametext);
                    dataTosave.put(PTESLOCATION_KEY,ptlocationtext);
                    mDocref.set(dataTosave).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "Document has been saved!");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Document was not saved!",e);
                        }
                    });
                }
            }
        });

        mDisplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDocref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String ptnametext = documentSnapshot.getString(PTESNAME_KEY);
                            String ptlocationtext = documentSnapshot.getString(PTESLOCATION_KEY);

                            mPtesTextView.setText("Ptas Name:"+ptnametext+"Ptes Location"+ptlocationtext);
                        }
                    }
                });
            }
        });
    }



//    public  void savePtes(View view){
//        EditText ptnameview = (EditText) findViewById(R.id.etext_ptesname);
//        EditText ptlocationview = (EditText) findViewById(R.id.etext_pteslocation);
//        String ptnametext = ptnameview.getText().toString();
//        String ptlocationtext = ptlocationview.getText().toString();
//
//        if (ptnametext.isEmpty() || ptlocationtext.isEmpty()){
//            Map<String, Object> dataTosave = new HashMap<String, Object>();
//            dataTosave.put(PTESNAME_KEY, ptnametext);
//            dataTosave.put(PTESLOCATION_KEY,ptlocationtext);
//            mDocref.set(dataTosave).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    Log.d(TAG, "Document has been saved!");
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.w(TAG, "Document was not saved!",e);
//                }
//            });
//        }
//    }

//    public void fecthPtes(View view){
//        mDocref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (documentSnapshot.exists()){
//                    String ptnametext = documentSnapshot.getString(PTESNAME_KEY);
//                    String ptlocationtext = documentSnapshot.getString(PTESLOCATION_KEY);
//
//                    mPtesTextView.setText("Ptas Name:"+ptnametext+"Ptes Location"+ptlocationtext);
//                }
//            }
//        });
//    }

}
