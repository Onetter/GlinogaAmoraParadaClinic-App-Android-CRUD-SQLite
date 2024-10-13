package info.codestart.glinogaprdrecrds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mAddressEditText;
    private EditText mDateEditText;
    private EditText mContactNumberText;
    private EditText mLeftEyeGradeEditText;
    private EditText mRightEyeGradeEditText;
    private EditText mAODEditText;
    private EditText moldRXEditText;
    private EditText mspecialfindingsEditText;
    private EditText madditionaltestEditText;
    private EditText mmanagemnetEditText;
    private EditText mcasehistoryEditText;
    private EditText mchiefcomplaintEditText;
    private EditText mdiagnosisEditText;
    private EditText mPaymentEditText;
    private Button UpdateUser;

    private PersonDBHelper dbHelper;
    private long receivedPersonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        mNameEditText = findViewById(R.id.userNameUpdate);
        mAgeEditText = findViewById(R.id.userAgeUpdate);
        mAddressEditText = findViewById(R.id.userAddressUpdate);
        mDateEditText = findViewById(R.id.userDateUpdate);
        mContactNumberText = findViewById(R.id.userContactNumberUpdate);
        mLeftEyeGradeEditText = findViewById(R.id.userLeftEyeGradeUpdate);
        mRightEyeGradeEditText = findViewById(R.id.userRightEyeGradeUpdate);
        mAODEditText = findViewById(R.id.userAODUpdate);
        moldRXEditText = findViewById(R.id.userOldRXUpdate);
        mspecialfindingsEditText = findViewById(R.id.userSpecialFindingsUpdate);
        madditionaltestEditText = findViewById(R.id.userAdditionalTestUpdate);
        mmanagemnetEditText = findViewById(R.id.userManagementUpdate);
        mcasehistoryEditText = findViewById(R.id.userCaseHistoryUpdate);
        mchiefcomplaintEditText = findViewById(R.id.userChiefComplaintUpdate);
        mdiagnosisEditText = findViewById(R.id.userDiagnosisUpdate);
        mPaymentEditText = findViewById(R.id.userPaymentUpdate);
        UpdateUser = findViewById(R.id.UpdateUser);

        dbHelper = new PersonDBHelper(this);



        try {
            //get intent to get person id
            receivedPersonId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Person queriedPerson = dbHelper.getPerson(receivedPersonId);
        //set field to this user data
        mNameEditText.setText(queriedPerson.getName());
        mAgeEditText.setText(queriedPerson.getAge());
        mAddressEditText.setText(queriedPerson.getAddress());
        mDateEditText.setText(queriedPerson.getDate());
        mContactNumberText.setText(queriedPerson.getContactnumber());
        mLeftEyeGradeEditText.setText(queriedPerson.getLefteyegrade());
        mRightEyeGradeEditText.setText(queriedPerson.getRighteyegrade());
        mAODEditText.setText(queriedPerson.getAOD());
        moldRXEditText.setText(queriedPerson.getOldRX());
        mspecialfindingsEditText.setText(queriedPerson.getSpecialfindings());
        madditionaltestEditText.setText(queriedPerson.getAdditionaltest());
        mmanagemnetEditText.setText(queriedPerson.getManagement());
        mcasehistoryEditText.setText(queriedPerson.getCasehistory());
        mchiefcomplaintEditText.setText(queriedPerson.getChiefcomplaint());
        mdiagnosisEditText.setText(queriedPerson.getDiagnosis());
        mPaymentEditText.setText(queriedPerson.getPayment());



        //listen to add button click to update
        UpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updateUser();
            }
        });

    }

    private void updateUser(){

        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String address = mAddressEditText.getText().toString().trim();
        String date = mDateEditText.getText().toString().trim();
        String contactnumber = mContactNumberText.getText().toString().trim();
        String lefteyegrade =  mLeftEyeGradeEditText.getText().toString().trim();
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

        if(name.isEmpty() && age.isEmpty() && address.isEmpty() && date.isEmpty() && contactnumber.isEmpty() && lefteyegrade.isEmpty() && righteyegrade.isEmpty() && payment.isEmpty() && aod.isEmpty() && oldrx.isEmpty() && specialfindings.isEmpty() && additionaltest.isEmpty() && management.isEmpty() && casehistory.isEmpty() && chiefcomplaint.isEmpty() && diagnosis.isEmpty() ){
            Toast.makeText(this,"You must fill up all fields", Toast.LENGTH_SHORT).show();
        }

        Person updatedPersonRecord = new Person(name , age , address , date , contactnumber , lefteyegrade , righteyegrade , aod , oldrx , specialfindings , additionaltest , management , casehistory , chiefcomplaint , diagnosis , payment);
        dbHelper.updatePersonRecord(receivedPersonId, this, updatedPersonRecord);
        gotolist();
    }

    private void gotolist(){
        startActivity(new Intent(this, info.codestart.glinogaprdrecrds.MainActivity.class));
    }

}
