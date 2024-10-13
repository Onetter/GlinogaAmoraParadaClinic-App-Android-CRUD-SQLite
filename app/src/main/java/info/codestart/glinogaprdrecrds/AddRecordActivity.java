package info.codestart.glinogaprdrecrds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mAddressEditText;
    private EditText mDateEditText;
    private EditText mContactNumberText;
    private EditText mLeftEyeGradeEditText;
    private EditText mRightEyeGradeEditText;
    private EditText mPaymentEditText;
    private EditText mAODEditText;
    private EditText moldRXEditText;
    private EditText mspecialfindingsEditText;
    private EditText madditionaltestEditText;
    private EditText mmanagemnetEditText;
    private EditText mcasehistoryEditText;
    private EditText mchiefcomplaintEditText;
    private EditText mdiagnosisEditText;
    private Button mAddBtn;

    private PersonDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        mNameEditText = findViewById(R.id.userName);
        mAgeEditText = findViewById(R.id.userAge);
        mAddressEditText = findViewById(R.id.userAddress);
        mDateEditText = findViewById(R.id.userDate);
        mContactNumberText = findViewById(R.id.userContactNumber);
        mLeftEyeGradeEditText = findViewById(R.id.userLeftEyeGrade);
        mRightEyeGradeEditText = findViewById(R.id.userRightEyeGrade);
        mAODEditText = findViewById(R.id.userAOD);
        moldRXEditText = findViewById(R.id.userOldRX);
        mspecialfindingsEditText = findViewById(R.id.userSpecialFindings);
        madditionaltestEditText = findViewById(R.id.userAdditionalTest);
        mmanagemnetEditText = findViewById(R.id.userManagement);
        mcasehistoryEditText = findViewById(R.id.userCaseHistory);
        mchiefcomplaintEditText = findViewById(R.id.userChiefComplaint);
        mdiagnosisEditText = findViewById(R.id.userDiagnosis);
        mPaymentEditText = findViewById(R.id.userPayment);
        mAddBtn = findViewById(R.id.addNewUserButton);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
            }
        });

    }

    private void savePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String address = mAddressEditText.getText().toString().trim();
        String date = mDateEditText.getText().toString().trim();
        String contactnumber = mContactNumberText.getText().toString().trim();
        String lefteyegrade = mLeftEyeGradeEditText.getText().toString().trim();
        String righteyegrade = mRightEyeGradeEditText.getText().toString().trim();
        String aod = mAODEditText.getText().toString().trim();
        String oldrx = moldRXEditText.getText().toString().trim();
        String specialfindings = mspecialfindingsEditText.getText().toString().trim();
        String additionaltest = madditionaltestEditText.getText().toString().trim();
        String management = mmanagemnetEditText.getText().toString().trim();
        String casehistory = mcasehistoryEditText.getText().toString().trim();
        String chiefcomplaint = mchiefcomplaintEditText.getText().toString().trim();
        String diagnosis = mdiagnosisEditText.getText().toString().trim();
        String payment = mPaymentEditText.getText().toString().trim();

        dbHelper = new PersonDBHelper(this);

        if(name.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(age.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an age", Toast.LENGTH_SHORT).show();
        }

        if(address.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an address", Toast.LENGTH_SHORT).show();
        }

        if(date.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a date", Toast.LENGTH_SHORT).show();
        }

        if(contactnumber.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Contact number is empty", Toast.LENGTH_SHORT).show();
        }

        if(lefteyegrade.isEmpty()){
            //error name is empty
            Toast.makeText(this, "OS field is empty", Toast.LENGTH_SHORT).show();
        }

        if(righteyegrade.isEmpty()){
            //error name is empty
            Toast.makeText(this, "OD field is empty", Toast.LENGTH_SHORT).show();
        }

        if(payment.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Payment field is empty", Toast.LENGTH_SHORT).show();
        }
        if(aod.isEmpty()){
            //error name is empty
            Toast.makeText(this, "AOD field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(oldrx.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Old RX field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(specialfindings.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Special findings field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(additionaltest.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Additional test field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(management.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Management field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(casehistory.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Case History field is Empty", Toast.LENGTH_SHORT).show();
        }

        if(chiefcomplaint.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Chief Complaint field is Empty", Toast.LENGTH_SHORT).show();
        }

        //create new person
        Person person = new Person(name , age , address , date , contactnumber , lefteyegrade , righteyegrade , aod , oldrx , specialfindings , additionaltest , management , casehistory , chiefcomplaint , diagnosis , payment);
        dbHelper.saveNewPerson(person);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(AddRecordActivity.this, viewList.class));
    }
}
