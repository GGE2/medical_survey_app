package com.cbu.medical_survey_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cbu.medical_survey_app.ButtonListener;
import com.cbu.medical_survey_app.R;
import com.cbu.medical_survey_app.activities.StartActivity;

public class NormalFragment_3 extends Fragment {

    private Context nowContext;
    private cancer_position[] cancer;
    private operation_position[] operation;
    ButtonListener normal3_prebt, normal3_nextbt;
    Button pre, next;
    RadioButton radioy, radion;
    EditText pn, py, pm, pd;

    public NormalFragment_3() {

    }

    public NormalFragment_3(Context context) {

        normal3_prebt = new ButtonListener(context);
        normal3_nextbt = new ButtonListener(context);
        cancer = new cancer_position[4];
        operation = new operation_position[13];
        nowContext = context;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.normal_frag_3, container, false);

        pre = (Button) vg.findViewById(R.id.bt_normal3_prev);
        next = (Button) vg.findViewById(R.id.bt_normal3_next);

        pre.setOnClickListener(normal3_prebt);
        next.setOnClickListener(normal3_nextbt);

        StartActivity.dtc.setDataToView(vg);

        initView(vg);

        return vg;
    }


    private void initView(ViewGroup vg) {


        //12번 - 암
        for (int RowID = 0; RowID < 4; RowID++) {
            RadioButton[] rb = new RadioButton[3];
            for (int ColID = 0; ColID < 3; ColID++) {
                rb[ColID] = vg.findViewById(getResId(vg, "normal3_radio_position_6_" + (RowID + 1) + "_" + (ColID + 1)));
            }
            EditText cancerName = vg.findViewById(getResId(vg, "cancer_input_1_" + (RowID + 1)));
            cancer[RowID] = new cancer_position(rb, cancerName);
        }
        //13번 yes or no
        radioy = vg.findViewById(R.id.pro13_radioYes);
        radion = vg.findViewById(R.id.pro13_radioNo);
        pn = vg.findViewById(R.id.eatingPill_name);
        py = vg.findViewById(R.id.eatingPill_year);
        pm = vg.findViewById(R.id.eatingPill_month);
        pd = vg.findViewById(R.id.eatingPill_day);

        radioy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableRadio(radion);
                enableRadio(radioy);
                enableInputs(pn);
                enableInputs(py);
                enableInputs(pm);
                enableInputs(pd);
            }
        });
        radion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableRadio(radioy);
                disableInputs(pn);
                disableInputs(py);
                disableInputs(pm);
                disableInputs(pd);
            }
        });


        //14번

        for (int RowID = 0; RowID < 13; RowID++) {
            RadioButton[] rb = new RadioButton[3];
            RadioButton[] cb = new RadioButton[6];
            for (int ColID = 0; ColID < 3; ColID++) {

                rb[ColID] = vg.findViewById(getResId(vg, "normal3_pro14_radio_position_" + (RowID + 1) + "_" + (ColID + 1)));

            }
            if (RowID == 12) {
                cb[0] = vg.findViewById(R.id.blood_radio_1);
                cb[1] = vg.findViewById(R.id.blood_radio_2);
                cb[2] = vg.findViewById(R.id.blood_radio_3);
                cb[3] = vg.findViewById(R.id.blood_radio_4);
                cb[4] = vg.findViewById(R.id.blood_radio_5);
                cb[5] = vg.findViewById(R.id.blood_radio_6);
                EditText text_11y = vg.findViewById(R.id.blood_input_1);
                EditText text_5y = vg.findViewById(R.id.blood_input_2);
                operation[RowID] = new operation_position(cb, text_11y, text_5y, 1);
            } else {
                EditText eY = vg.findViewById(getResId(vg, "normal3_pro_14input_position_" + (RowID + 1) + "_1"));
                EditText eA = vg.findViewById(getResId(vg, "normal3_pro_14input_position_" + (RowID + 1) + "_2"));

                operation[RowID] = new operation_position(rb, eY, eA);
            }

        }


    }

    // 현재 줄 비활성화
    private void disableInputs(EditText text) {
        text.setText("");
        text.setClickable(false);
        text.setFocusable(false);
        text.setTextColor(getResources().getColor(R.color.text_gray));
    }

    private void disableInputs_no_clear(EditText text) {
        text.setClickable(false);
        text.setFocusable(false);
        text.setTextColor(getResources().getColor(R.color.text_gray));
    }

    // 현재 줄 활성화
    public void enableInputs(EditText text) {
        text.setFocusableInTouchMode(true);
        text.setClickable(true);
        text.setEnabled(true);
        text.setFocusable(true);
        text.setTextColor(getResources().getColor(R.color.text_black));
    }


    //라디오 버튼 비활성화
    private void disableRadio(RadioButton rb) {
        rb.setFocusable(false);
        rb.setChecked(false);
    }

    public void disableRadio_no_click(RadioButton rb) {
        rb.setFocusable(false);
        rb.setClickable(false);
        rb.setChecked(false);
        rb.setEnabled(false);
        rb.setTextColor(getResources().getColor(R.color.text_gray));
    }

    //라디오 버튼 활성화
    private void enableRadio(RadioButton rb) {
        rb.setFocusable(true);
        rb.setClickable(true);
        rb.setEnabled(true);
        rb.setTextColor(getResources().getColor(R.color.text_black));
    }

    private int getResId(ViewGroup vg, String id) {
        int getID = vg.getResources().getIdentifier(id, "id", getContext().getPackageName());
        return getID;
    }

    private class operation_position {

        protected RadioButton[] rbs;
        protected RadioButton[] cbs;
        protected EditText edtYear, edtAge, edtBlood11, edtBlood5;
        protected int count = -1;
        protected int ch = -1;

        //14번
        public operation_position(RadioButton[] op, EditText edtY, EditText edtA) {

            rbs = op;
            edtYear = edtY;
            edtAge = edtA;



            for (int i = 0; i < op.length; i++) {

                if (rbs[i].isChecked()) {
                    count = i;
                    rbs[i].setChecked(true);
                    if(count==0){
                        disableInputs(edtYear);
                        disableInputs(edtAge);
                        disableRadio_no_click(rbs[2]);
                    }
                } else
                    rbs[i].setChecked(false);


                setBtListener1(rbs[i], i);
                if(i==2){
                    if(count==-1){
                        disableInputs(edtYear);
                        disableInputs(edtAge);
                        disableRadio_no_click(rbs[2]);
                    }
                }
            }


        }

        //14번 수혈
        public operation_position(RadioButton[] op, EditText edit11, EditText edit5, int i) {
            cbs = op;
            edtBlood11 = edit11;
            edtBlood5 = edit5;



            for (int k = 0; k < op.length; k++) {
                if (cbs[k].isChecked()) {
                        cbs[k].setChecked(true);
                        ch = k;
                    }
                 else
                     {
                    cbs[k].setChecked(false);
                    if(k==3||k==5){
                        if(!(cbs[2].isChecked()))
                        disableRadio_no_click(cbs[3]);
                        if(!(cbs[4].isChecked()))
                        disableRadio_no_click(cbs[5]);
                    }
                }
                setBtListener2(cbs[k], k);
                if(k==op.length-1){
                    if(ch==-1||ch==0)
                    {
                        disableInputs(edtBlood5);
                        disableInputs(edtBlood11);
                        disableRadio_no_click(cbs[2]);
                        disableRadio_no_click(cbs[3]);
                        disableRadio_no_click(cbs[4]);
                        disableRadio_no_click(cbs[5]);

                    }

                }

            }

        }

        private void setBtListener2(RadioButton rb, int idx) {
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (idx != ch) {
                        if (idx == -1) {
                        }
                        else if (idx == 0) {
                            ch = idx;
                            disableRadio_no_click(cbs[2]);
                            disableRadio_no_click(cbs[3]);
                            disableRadio_no_click(cbs[4]);
                            disableRadio_no_click(cbs[5]);
                            enableRadio(cbs[0]);
                            disableRadio(cbs[1]);
                        } else if (idx == 2) {
                            ch=idx;
                            enableInputs(edtBlood11);
                            enableRadio(cbs[2]);
                            enableRadio(cbs[3]);
                        } else if (idx == 3) {
                            ch=idx;
                            if (cbs[2].isChecked()) {
                                enableRadio(cbs[3]);
                                disableInputs(edtBlood11);
                                setBtTextListener2(edtBlood11);
                            }

                        } else if (idx == 4) {
                            enableInputs(edtBlood5);
                            enableRadio(cbs[4]);
                            enableRadio(cbs[5]);
                        } else if (idx == 5) {
                            if (cbs[4].isChecked()) {
                                enableRadio(cbs[5]);
                                disableInputs(edtBlood5);
                                setBtTextListenr2_1(edtBlood5);
                            }

                        } else {
                            ch = idx;
                            disableRadio(cbs[0]);
                            enableRadio(cbs[1]);
                            enableRadio(cbs[2]);
                            enableRadio(cbs[4]);


                        }

                    }

                }
            });


        }

        private void setBtTextListenr2_1(EditText et) {
            et.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    enableInputs(et);
                    disableRadio(cbs[5]);
                }
            });

        }

        private void setBtTextListener2(EditText et) {

            et.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    enableInputs(et);
                    disableRadio(cbs[3]);
                }
            });

        }


        private void setBtListener1(RadioButton rb, int idx) {

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (idx != count) {
                        if (idx == 0 || idx == -1) {
                            count = idx;
                            enableRadio(rbs[idx]);
                            disableRadio(rbs[1]);
                            disableRadio_no_click(rbs[2]);
                            disableInputs(edtYear);
                            disableInputs(edtAge);
                        } else if (idx == 2) {
                            count = idx;
                            enableRadio(rbs[2]);
                            rbs[2].setChecked(true);
                            disableRadio(rbs[0]);
                            enableRadio(rbs[1]);
                            disableInputs(edtYear);
                            disableInputs(edtAge);

                            edtYear.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    count = 0;
                                    enableInputs(edtYear);
                                    enableInputs(edtAge);
                                    rbs[2].setChecked(false);
                                }
                            });

                            edtAge.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    count = 0;
                                    enableInputs(edtYear);
                                    enableInputs(edtAge);
                                    rbs[2].setChecked(false);
                                }
                            });
                        } else {
                            count = idx;
                            disableRadio(rbs[0]);
                            enableRadio(rbs[1]);
                            enableRadio(rbs[2]);
                            enableInputs(edtYear);
                            enableInputs(edtAge);
                        }

                    }

                }
            });


        }


    }


    private class cancer_position {

        protected RadioButton[] rbs;
        protected CheckBox box;
        protected EditText eText;
        protected int checked = -1;
        int cnt=0;
        public cancer_position(RadioButton[] inRad, EditText inEdt) {

            rbs = inRad;
            eText = inEdt;


            for (int i = 0; i < rbs.length; i++) {
                if (rbs[i].isChecked()) {
                    rbs[i].setChecked(true);
                    checked = i;
                    if (checked == 0) {
                        disableRadio_no_click(rbs[2]);
                        disableInputs(eText);
                    }

                } else {
                    rbs[i].setChecked(false);
                }
                setBtListener(rbs[i], i);
                if(i==2) {
                    if (checked == -1 || checked == 0) {
                        disableRadio_no_click(rbs[2]);
                        disableInputs(eText);
                    }
                }

            }
        }

        private void setBtTextListener(EditText et) {

            et.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    enableInputs(et);
                    disableRadio(rbs[2]);
                }
            });

        }


        private void setBtListener(RadioButton rb, int idx) {

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (idx != checked) {
                        if (idx == 0) {
                            enableRadio(rbs[0]);
                            disableRadio(rbs[1]);
                            disableRadio_no_click(rbs[2]);
                            disableInputs(eText);
                            checked = 0;
                        } else if (idx == 1) {
                            disableRadio(rbs[0]);
                            enableRadio(rbs[1]);
                            enableRadio(rbs[2]);
                            enableInputs(eText);
                            setBtTextListener(eText);
                            checked = 1;
                        } else {
                            checked = 2;
                            if (rbs[1].isChecked()) {
                                Log.e("else", "else");
                                disableInputs(eText);
                            } else
                                disableRadio_no_click(rbs[2]);

                        }

                    }

                }

            });

        }


    }
}