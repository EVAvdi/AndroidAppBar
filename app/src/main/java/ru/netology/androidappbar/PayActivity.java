package ru.netology.androidappbar;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import ru.netodology.androidappbar.R;

public class PayActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initViews();
    }
    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }
    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        mBtnOk.setOnClickListener(clickOkBankCardListener);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        mBtnOk.setOnClickListener(clickOkMobilePhoneListener);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                        mBtnOk.setOnClickListener(clickOkCashAddressListener);
                        break;
                    default:
                }
            }
        }
    };
    View.OnClickListener clickOkBankCardListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(PayActivity.this,
                    "Оплата будет совершена банковской картой", Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener clickOkMobilePhoneListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(PayActivity.this,
                    "Оплата будет совершена с мобильного устройства", Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener clickOkCashAddressListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(PayActivity.this,
                    "Оплата будет совершена наличными денежными средствами", Toast.LENGTH_LONG).show();
        }
    };

}