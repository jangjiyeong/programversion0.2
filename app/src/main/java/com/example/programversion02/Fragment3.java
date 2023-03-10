package com.example.programversion02;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
//
//import static android.app.Activity.RESULT_CANCELED;
//import static com.example.programversion02.SetImageboard.camera;
//import static com.example.programversion02.SetImageboard.gallery;

public class Fragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static final int getimagesetting = 1001;
    private static final int RESULT_OK = -1;
    private static final int GET_GALLERY_IMAGE = -1;
    private ImageView imageView_board;
    private Button ClosepopBtn, camerapopBtn, gallerypopBtn;
    static final int camera = 2001;
    static final int gallery = 2002;
    private Uri selectedImageUri;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18, temp19, temp20, temp21, temp22, temp23, temp24, temp25;
    private String temp1;
    private String temp1_dialog, temp2_dialog, temp3_dialog, temp4_dialog, temp5_dialog, temp6_dialog, temp7_dialog, temp8_dialog, temp9_dialog, temp10_dialog,
            temp11_dialog, temp12_dialog, temp13_dialog, temp14_dialog, temp15_dialog, temp16_dialog, temp17_dialog, temp18_dialog, temp19_dialog, temp20_dialog,
            temp21_dialog, temp22_dialog, temp23_dialog, temp24_dialog, temp25_dialog;

    ListViewAdapter_board ListViewAdapter_board;

    private int board_img_case = 0;
    private Button btn_image_board_dialog;


    private Spinner temp1_spinner_board, temp2_spinner_board1,temp2_spinner_board2,temp2_spinner_board3,temp2_spinner_board4,temp2_spinner_board5,temp2_spinner_board6,temp2_spinner_board7,temp2_spinner_board8
            , temp3_spinner_board, temp4_spinner_board, temp5_spinner_board, temp6_spinner_board, temp7_spinner_board, temp8_spinner_board;

    private EditText edt_board_version, edt_board_code, edt_board_chip_name1, edt_board_chip_name2, edt_user_board, edt_Contents_board;

    private EditText spinner_edt_dialog, edt_before_version_dialog1, edt_before_version_dialog2, edt_before_version_dialog3, edt_before_version_dialog4, edt_after_version_dialog1, edt_after_version_dialog2, edt_after_version_dialog3, edt_after_version_dialog4, edt_file_name, edt_git_branch,
            spinner_edt_del;

    private Button btn_before_version_board, btn_after_version_board, btn_image_board, btn_calendar_select_board, btn_insert_listView_board, btn_select_search_board, btn_menu3;

    Dialog spinner_dialog, before_version_dialog, after_version_dialog, spinner_edt_del_dialog, insert_dialog, item_listview_dialog, item_listview_dialog2, item_listview_dialog2_board, SetImageboard, item_listview_board_image;


    private LinearLayout layout_menu3;

    private ListView lv_list_board;
    private ArrayAdapter<String> adapter;

    private Boolean layoutchange = true;

    private int i;

    public Fragment3() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void spinner_list_dialog() {
        spinner_dialog.show();
        spinner_edt_dialog = spinner_dialog.findViewById(R.id.spinner_edt_dialog);
        Button noBtn = spinner_dialog.findViewById(R.id.no_btn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner_dialog.dismiss(); // ??????????????? ??????
            }
        });
        spinner_dialog.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "??????", Toast.LENGTH_SHORT).show();
                spinner_dialog.dismiss();
                String label = spinner_edt_dialog.getText().toString();
                if (label.trim().length() > 0) {
                    switch (i) {
                        case 0:
                            DbHandler_board db = new DbHandler_board(getContext());
                            db.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 1:
                            DbHandler_board1 db1 = new DbHandler_board1(getContext());
                            db1.insertLabel(label);
                            DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getContext());
                            db1_1.insertLabel(label);
                            DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getContext());
                            db1_2.insertLabel(label);
                            DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getContext());
                            db1_3.insertLabel(label);
                            DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getContext());
                            db1_4.insertLabel(label);
                            DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getContext());
                            db1_5.insertLabel(label);
                            DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getContext());
                            db1_6.insertLabel(label);
                            DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getContext());
                            db1_7.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 2:
                            DbHandler_board2 db2 = new DbHandler_board2(getContext());
                            db2.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 3:
                            DbHandler_board3 db3 = new DbHandler_board3(getContext());
                            db3.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 4:
                            DbHandler_board4 db4 = new DbHandler_board4(getContext());
                            db4.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 5:
                            DbHandler_board5 db5 = new DbHandler_board5(getContext());
                            db5.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 6:
                            DbHandler_board6 db6 = new DbHandler_board6(getContext());
                            db6.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 7:
                            DbHandler_board7 db7 = new DbHandler_board7(getContext());
                            db7.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                    }
                }
            }
        });
    }

    private void loadSpinnerData() {
        switch (i) {
            case 0:
                DbHandler_board db = new DbHandler_board(getActivity());
                List<String> labels = db.getAllLabels();
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp1_spinner_board.setAdapter(dataAdapter);
                break;
            case 1:
                DbHandler_board1 db1 = new DbHandler_board1(getActivity());
                List<String> labels1 = db1.getAllLabels();
                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
                dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board1.setAdapter(dataAdapter1);

                DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getActivity());
                List<String> labels1_1 = db1_1.getAllLabels();
                ArrayAdapter<String> dataAdapter1_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_1);
                dataAdapter1_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board2.setAdapter(dataAdapter1_1);

                DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getActivity());
                List<String> labels1_2 = db1_2.getAllLabels();
                ArrayAdapter<String> dataAdapter1_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_2);
                dataAdapter1_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board3.setAdapter(dataAdapter1_2);

                DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getActivity());
                List<String> labels1_3 = db1_3.getAllLabels();
                ArrayAdapter<String> dataAdapter1_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_3);
                dataAdapter1_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board4.setAdapter(dataAdapter1_3);

                DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getActivity());
                List<String> labels1_4 = db1_4.getAllLabels();
                ArrayAdapter<String> dataAdapter1_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_4);
                dataAdapter1_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board5.setAdapter(dataAdapter1_4);

                DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getActivity());
                List<String> labels1_5 = db1_5.getAllLabels();
                ArrayAdapter<String> dataAdapter1_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_5);
                dataAdapter1_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board6.setAdapter(dataAdapter1_5);

                DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getActivity());
                List<String> labels1_6 = db1_6.getAllLabels();
                ArrayAdapter<String> dataAdapter1_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_6);
                dataAdapter1_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board7.setAdapter(dataAdapter1_6);

                DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getActivity());
                List<String> labels1_7 = db1_7.getAllLabels();
                ArrayAdapter<String> dataAdapter1_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_7);
                dataAdapter1_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_board8.setAdapter(dataAdapter1_7);
                break;
            case 2:
                DbHandler_board2 db2 = new DbHandler_board2(getActivity());
                List<String> labels2 = db2.getAllLabels();
                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp3_spinner_board.setAdapter(dataAdapter2);
                break;
            case 3:
                DbHandler_board3 db3 = new DbHandler_board3(getActivity());
                List<String> labels3 = db3.getAllLabels();
                ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
                dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp4_spinner_board.setAdapter(dataAdapter3);
                break;
            case 4:
                DbHandler_board4 db4 = new DbHandler_board4(getActivity());
                List<String> labels4 = db4.getAllLabels();
                ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
                dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp5_spinner_board.setAdapter(dataAdapter4);
                break;
            case 5:
                DbHandler_board5 db5 = new DbHandler_board5(getActivity());
                List<String> labels5 = db5.getAllLabels();
                ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
                dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp6_spinner_board.setAdapter(dataAdapter5);
                break;
            case 6:
                DbHandler_board6 db6 = new DbHandler_board6(getActivity());
                List<String> labels6 = db6.getAllLabels();
                ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
                dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp7_spinner_board.setAdapter(dataAdapter6);
                break;
            case 7:
                DbHandler_board7 db7 = new DbHandler_board7(getActivity());
                List<String> labels7 = db7.getAllLabels();
                ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
                dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp8_spinner_board.setAdapter(dataAdapter7);
                break;
        }

    }

    private void loadSpinnerData1() {
        DbHandler_board db = new DbHandler_board(getActivity());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1_spinner_board.setAdapter(dataAdapter);

        DbHandler_board1 db1 = new DbHandler_board1(getActivity());
        List<String> labels1 = db1.getAllLabels();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board1.setAdapter(dataAdapter1);

        DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getActivity());
        List<String> labels1_1 = db1_1.getAllLabels();
        ArrayAdapter<String> dataAdapter1_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_1);
        dataAdapter1_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board2.setAdapter(dataAdapter1_1);

        DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getActivity());
        List<String> labels1_2 = db1_2.getAllLabels();
        ArrayAdapter<String> dataAdapter1_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_2);
        dataAdapter1_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board3.setAdapter(dataAdapter1_2);

        DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getActivity());
        List<String> labels1_3 = db1_3.getAllLabels();
        ArrayAdapter<String> dataAdapter1_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_3);
        dataAdapter1_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board4.setAdapter(dataAdapter1_3);

        DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getActivity());
        List<String> labels1_4 = db1_4.getAllLabels();
        ArrayAdapter<String> dataAdapter1_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_4);
        dataAdapter1_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board5.setAdapter(dataAdapter1_4);

        DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getActivity());
        List<String> labels1_5 = db1_5.getAllLabels();
        ArrayAdapter<String> dataAdapter1_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_5);
        dataAdapter1_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board6.setAdapter(dataAdapter1_5);

        DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getActivity());
        List<String> labels1_6 = db1_6.getAllLabels();
        ArrayAdapter<String> dataAdapter1_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_6);
        dataAdapter1_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board7.setAdapter(dataAdapter1_6);

        DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getActivity());
        List<String> labels1_7 = db1_7.getAllLabels();
        ArrayAdapter<String> dataAdapter1_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_7);
        dataAdapter1_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_board8.setAdapter(dataAdapter1_7);

        DbHandler_board2 db2 = new DbHandler_board2(getActivity());
        List<String> labels2 = db2.getAllLabels();
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp3_spinner_board.setAdapter(dataAdapter2);

        DbHandler_board3 db3 = new DbHandler_board3(getActivity());
        List<String> labels3 = db3.getAllLabels();
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp4_spinner_board.setAdapter(dataAdapter3);

        DbHandler_board4 db4 = new DbHandler_board4(getActivity());
        List<String> labels4 = db4.getAllLabels();
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp5_spinner_board.setAdapter(dataAdapter4);

        DbHandler_board5 db5 = new DbHandler_board5(getActivity());
        List<String> labels5 = db5.getAllLabels();
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp6_spinner_board.setAdapter(dataAdapter5);

        DbHandler_board6 db6 = new DbHandler_board6(getActivity());
        List<String> labels6 = db6.getAllLabels();
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp7_spinner_board.setAdapter(dataAdapter6);

        DbHandler_board7 db7 = new DbHandler_board7(getActivity());
        List<String> labels7 = db7.getAllLabels();
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp8_spinner_board.setAdapter(dataAdapter7);
    }

    public void spinner_edt_del_dialog() {
        spinner_edt_del_dialog.show();
        spinner_edt_del = spinner_edt_del_dialog.findViewById(R.id.spinner_edt_del);
        Button no_btn_edt_del = spinner_edt_del_dialog.findViewById(R.id.no_btn_edt_del);
        Button yes_btn_edt = spinner_edt_del_dialog.findViewById(R.id.yes_btn_edt);
        Button yes_btn_del = spinner_edt_del_dialog.findViewById(R.id.yes_btn_del);
        no_btn_edt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner_edt_del_dialog.dismiss();
            }
        });
        yes_btn_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "????????????", Toast.LENGTH_SHORT).show();
                String label1 = spinner_edt_del.getText().toString();
                if (label1.trim().length() > 0) {
                    switch (i) {
                        case 0:
                            DbHandler_board db = new DbHandler_board(getContext());
                            db.updateLabel(temp2, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 1:
                            DbHandler_board1 db1 = new DbHandler_board1(getContext());
                            db1.updateLabel(temp3, label1);
                            DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getContext());
                            db1_1.updateLabel(temp3, label1);
                            DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getContext());
                            db1_2.updateLabel(temp3, label1);
                            DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getContext());
                            db1_3.updateLabel(temp3, label1);
                            DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getContext());
                            db1_4.updateLabel(temp3, label1);
                            DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getContext());
                            db1_5.updateLabel(temp3, label1);
                            DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getContext());
                            db1_6.updateLabel(temp3, label1);
                            DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getContext());
                            db1_7.updateLabel(temp3, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 2:
                            DbHandler_board2 db2 = new DbHandler_board2(getContext());
                            db2.updateLabel(temp6, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 3:
                            DbHandler_board3 db3 = new DbHandler_board3(getContext());
                            db3.updateLabel(temp8, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 4:
                            DbHandler_board4 db4 = new DbHandler_board4(getContext());
                            db4.updateLabel(temp10, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 5:
                            DbHandler_board5 db5 = new DbHandler_board5(getContext());
                            db5.updateLabel(temp11, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 6:
                            DbHandler_board6 db6 = new DbHandler_board6(getContext());
                            db6.updateLabel(temp12, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 7:
                            DbHandler_board7 db7 = new DbHandler_board7(getContext());
                            db7.updateLabel(temp18, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;

                    }
                }
            }
        });
        yes_btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i) {
                    case 0:
                        DbHandler_board db = new DbHandler_board(getContext());
                        db.deleteLabel(temp2);
                        break;
                    case 1:
                        DbHandler_board1 db1 = new DbHandler_board1(getContext());
                        db1.deleteLabel(temp3);
                        DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getContext());
                        db1_1.deleteLabel(temp3);
                        DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getContext());
                        db1_2.deleteLabel(temp3);
                        DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getContext());
                        db1_3.deleteLabel(temp3);
                        DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getContext());
                        db1_4.deleteLabel(temp3);
                        DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getContext());
                        db1_5.deleteLabel(temp3);
                        DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getContext());
                        db1_6.deleteLabel(temp3);
                        DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getContext());
                        db1_7.deleteLabel(temp3);
                        break;
                    case 2:
                        DbHandler_board2 db2 = new DbHandler_board2(getContext());
                        db2.deleteLabel(temp6);
                        break;
                    case 3:
                        DbHandler_board3 db3 = new DbHandler_board3(getContext());
                        db3.deleteLabel(temp8);
                        break;
                    case 4:
                        DbHandler_board4 db4 = new DbHandler_board4(getContext());
                        db4.deleteLabel(temp10);
                        break;
                    case 5:
                        DbHandler_board5 db5 = new DbHandler_board5(getContext());
                        db5.deleteLabel(temp11);
                        break;
                    case 6:
                        DbHandler_board6 db6 = new DbHandler_board6(getContext());
                        db6.deleteLabel(temp12);
                        break;
                    case 7:
                        DbHandler_board7 db7 = new DbHandler_board7(getContext());
                        db7.deleteLabel(temp18);
                        break;
                }
                Toast.makeText(getContext(), "?????????????????????.", Toast.LENGTH_LONG).show();
                loadSpinnerData();
                spinner_edt_del_dialog.dismiss();
            }
        });
    }

    public void after_version_dialog() {
        after_version_dialog.show();
        edt_after_version_dialog1 = after_version_dialog.findViewById(R.id.edt_after_version_dialog1);
        edt_after_version_dialog2 = after_version_dialog.findViewById(R.id.edt_after_version_dialog2);
        edt_after_version_dialog3 = after_version_dialog.findViewById(R.id.edt_after_version_dialog3);
        Button btn_after_version_no = after_version_dialog.findViewById(R.id.btn_after_version1);
        Button btn_after_version_yes = after_version_dialog.findViewById(R.id.btn_after_version2);

        btn_after_version_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_version_dialog.dismiss();
                edt_after_version_dialog1.setText("");
            }
        });
        btn_after_version_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = edt_after_version_dialog1.getText().toString();
                String v2 = edt_after_version_dialog2.getText().toString();
                String v3 = edt_after_version_dialog3.getText().toString();
                String after_all_v = v1 + "." + v2 + "." + v3;
                btn_after_version_board.setText(after_all_v);
                edt_after_version_dialog1.setText("");
                edt_after_version_dialog2.setText("");
                edt_after_version_dialog3.setText("");
                after_version_dialog.dismiss();
            }

        });
    }

    public void before_version_dialog() {
        before_version_dialog.show();
        edt_before_version_dialog1 = before_version_dialog.findViewById(R.id.edt_before_version_dialog1);
        edt_before_version_dialog2 = before_version_dialog.findViewById(R.id.edt_before_version_dialog2);
        edt_before_version_dialog3 = before_version_dialog.findViewById(R.id.edt_before_version_dialog3);
        Button btn_before_version_no = before_version_dialog.findViewById(R.id.btn_before_version1);
        Button btn_before_version_yes = before_version_dialog.findViewById(R.id.btn_before_version2);
        btn_before_version_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_version_dialog.dismiss();
                edt_before_version_dialog1.setText("");
            }
        });
        btn_before_version_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1 = edt_before_version_dialog1.getText().toString();
                String v2 = edt_before_version_dialog2.getText().toString();
                String v3 = edt_before_version_dialog3.getText().toString();
                String before_all_v = v1 + "." + v2 + "." + v3;
                btn_before_version_board.setText(before_all_v);
                edt_before_version_dialog1.setText("");
                edt_before_version_dialog2.setText("");
                edt_before_version_dialog3.setText("");
                before_version_dialog.dismiss();
            }
        });

    }

    public void spinner_reset() {
        temp1_spinner_board.setSelection(0);
        temp2_spinner_board1.setSelection(0);
        temp2_spinner_board2.setSelection(0);
        temp2_spinner_board3.setSelection(0);
        temp2_spinner_board4.setSelection(0);
        temp2_spinner_board5.setSelection(0);
        temp2_spinner_board6.setSelection(0);
        temp2_spinner_board7.setSelection(0);
        temp2_spinner_board8.setSelection(0);
        temp3_spinner_board.setSelection(0);
        temp4_spinner_board.setSelection(0);
        temp5_spinner_board.setSelection(0);
        temp6_spinner_board.setSelection(0);
        temp7_spinner_board.setSelection(0);
        temp8_spinner_board.setSelection(0);
        btn_image_board.setText("????????? ??????");
        btn_before_version_board.setText("????????????");
        btn_after_version_board.setText("????????????");
        btn_calendar_select_board.setText("????????????");
        edt_board_version.setText("");
        edt_board_code.setText("");
        edt_board_chip_name1.setText("");
        edt_board_chip_name2.setText("");
        edt_user_board.setText("");
        edt_Contents_board.setText("");
        temp1 = "";
    }

    void select_Spinner(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10,
                        String name11, String name12, String name13, String name14, String name15, String name16, String name17, String name18) {
        //Dbhelper??? ???????????? ????????? ?????????
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT * FROM board_database WHERE" +
                " menual LIKE '%" + name1 + "%' AND " +
                " board_kind LIKE '%" + name2 + "%' AND " +
                " board_type LIKE '%" + name3 + "%' AND" +
                " board_version LIKE '%" + name4 + "%' AND" +
                " board_code LIKE '%" + name5 + "%' AND" +
                " chipset1 LIKE '%" + name6 + "%' AND" +
                " chipset_name1 LIKE '%" + name7 + "%' AND" +
                " chipset2 LIKE '%" + name8 + "%' AND" +
                " chipset_name2 LIKE '%" + name9 + "%' AND" +
                " registration LIKE '%" + name10 + "%' AND" +
                " request LIKE '%" + name11 + "%' AND" +
                " model LIKE '%" + name12 + "%' AND" +
                " before_version LIKE '%" + name13 + "%' AND" +
                " after_version LIKE '%" + name14 + "%' AND" +
                " date LIKE '%" + name15 + "%' AND" +
                " change_point LIKE '%" + name16 + "%' AND" +
                " writer LIKE '%" + name17 + "%' AND" +
                " bundle LIKE '%" + name18 + "%';";

        cursor = database.rawQuery(qry, null); //???????????? ????????? ??????

        ListViewAdapter_board adapter = new ListViewAdapter_board();

        while (cursor.moveToNext()) {
            //num ?????? ?????? ???????????? ????????? 0?????? ??????, name??? 1???
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                    cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18));
        }


        cursor.close();
        database.close();

        lv_list_board.setAdapter(adapter);
    }

    public void insert_dialog() {
        insert_dialog.show();
        Button insert_no_btn = insert_dialog.findViewById(R.id.insert_no_btn);
        Button insert_yes_btn = insert_dialog.findViewById(R.id.insert_yes_btn);

        insert_no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert_dialog.dismiss();
            }
        });
        insert_yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert_Spinner(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18, temp19, temp20, temp21, temp22, temp23, temp24, temp25);
                Toast.makeText(getContext(), "?????????????????????.", Toast.LENGTH_SHORT).show();
                insert_dialog.dismiss();
                spinner_reset();
            }
        });
    }

    void insert_Spinner(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9,
                        String name10, String name11, String name12, String name13, String name14, String name15, String name16, String name17, String name18, String name19,
                        String name20, String name21, String name22, String name23, String name24, String name25) {
        //Dbhelper??? ???????????? ????????? ?????????
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();

        String qry = "INSERT INTO board_database(menual, board_kind, board_type, board_version, board_code, chipset1, chipset_name1, chipset2, chipset_name2, registration, request, model, before_version, after_version, date, change_point, writer, bundle, name19, name20, name21, name22, name23, name24, name25) VALUES(" +
                "'" + name1 + "','" + name2 + "','" + name3 + "','" + name4 + "','" + name5 + "','" + name6 + "','" + name7 + "','" + name8 + "','" + name9 + "','" + name10 + "','" + name11 + "','" + name12 + "','" + name13 + "','" + name14 + "','" + name15 + "','" + name16 + "','" + name17 + "','" + name18 + "','" + name19 + "'" +
                ",'" + name20 + "','" + name21 + "','" + name22 + "','" + name23 + "','" + name24 + "','" + name25 + "')";

        database.execSQL(qry); //???????????? ????????? ??????

        displayList(); //???????????? ????????????

    }

    void displayList() {
        //Dbhelper??? ???????????? ????????? ????????? SQLiteDatabase??? ?????? ????????????
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();

        //Cursor?????? ????????? ????????? ????????????
        Cursor cursor = database.rawQuery("SELECT * FROM board_database", null);

        //??????????????? ?????? ???????????? ????????? adapter??????
        ListViewAdapter_board adapter = new ListViewAdapter_board();

        //????????? ???????????? ???????????? adapter??? ?????? list????????? add
        while (cursor.moveToNext()) {
            //num ?????? ?????? ???????????? ????????? 0?????? ??????, name??? 1???
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                    cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18));
        }

        //??????????????? ????????? ????????? ?????? ????????? adapter??? ??????
        lv_list_board.setAdapter(adapter);

    }

    public void showDialog01(String position, Bitmap position_image) {
        item_listview_dialog.show(); // ??????????????? ?????????
        String position1 = position;
        Bitmap position_image1 = position_image;
        /* ??? ?????? ?????? ????????? ???????????? ????????? ???????????? ??????. */

        // ?????? ?????? ????????? ?????? ????????????~
        // '?????? ????????? ??????'?????? ???????????? ???????????? ???????????? ???????????? ????????????,
        // '?????? ??? ??????'?????? ?????? ???????????? ??????????????? ???????????? ??????.
        // *????????? ???: findViewById()??? ??? ?????? -> ?????? ????????? ??????????????? ????????? ????????? ??????.

        // ????????? ??????
        Button noBtn = item_listview_dialog.findViewById(R.id.btn_cancel);
        Button btn_image_view =item_listview_dialog.findViewById(R.id.btn_image_view);
//        btn_image_view.setVisibility(View.VISIBLE);

        btn_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item_listview_dialog.dismiss();
                item_listview_board_image.show();
                Button listView_board_cancel = item_listview_board_image.findViewById(R.id.listView_board_cancel);
                ImageView listView_board_image = item_listview_board_image.findViewById(R.id.listView_board_image);
                listView_board_image.setImageBitmap(position_image1);
                listView_board_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        item_listview_board_image.dismiss();
                    }
                });
            }
        });



        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                item_listview_dialog.dismiss(); // ??????????????? ??????
            }
        });

        item_listview_dialog.findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "??????", Toast.LENGTH_SHORT).show();
                showDialog02(position1);
                item_listview_dialog.dismiss();
            }
        });

        item_listview_dialog.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "????????????", Toast.LENGTH_SHORT).show();
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                String qry = "DELETE FROM board_database WHERE num = '" + position1 + "'";
                database.execSQL(qry);
                item_listview_dialog.dismiss();
                displayList(); //???????????? ????????????
            }
        });
    }

    public void showDialog02(String position1) {

        item_listview_dialog2_board.show(); // ??????????????? ?????????
        Spinner temp1_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp1_spinner_board_dialog);
        Spinner temp2_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp2_spinner_board_dialog);
        Spinner temp3_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp3_spinner_board_dialog);
        Spinner temp4_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp4_spinner_board_dialog);
        Spinner temp5_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp5_spinner_board_dialog);
        Spinner temp6_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp6_spinner_board_dialog);
        Spinner temp7_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp7_spinner_board_dialog);
        Spinner temp8_spinner_dialog = item_listview_dialog2_board.findViewById(R.id.temp8_spinner_board_dialog);
        EditText edt_board_version_dialog = item_listview_dialog2_board.findViewById(R.id.edt_board_version_dialog);
        EditText edt_board_code_dialog = item_listview_dialog2_board.findViewById(R.id.edt_board_code_dialog);
        EditText edt_chip_name1_dialog = item_listview_dialog2_board.findViewById(R.id.edt_board_chip_name1_dialog);
        EditText edt_chip_name2_dialog = item_listview_dialog2_board.findViewById(R.id.edt_board_chip_name2_dialog);
        EditText edt_User_dialog = item_listview_dialog2_board.findViewById(R.id.edt_user_board_dialog);
        EditText edt_Contents_dialog = item_listview_dialog2_board.findViewById(R.id.edt_Contents_board_dialog);
        Button btn_calendar_select_dialog = item_listview_dialog2_board.findViewById(R.id.btn_calendar_select_board_dialog);
        Button btn_before_version_dialog = item_listview_dialog2_board.findViewById(R.id.btn_before_version_board_dialog);
        Button btn_after_version_dialog = item_listview_dialog2_board.findViewById(R.id.btn_after_version_board_dialog);
        Button btn_item_list_update_dialog = item_listview_dialog2_board.findViewById(R.id.btn_item_list_update_dialog);
        Button btn_item_list_cancel_dialog = item_listview_dialog2_board.findViewById(R.id.btn_item_list_cancel_dialog);
        btn_image_board_dialog = item_listview_dialog2_board.findViewById(R.id.btn_image_board_dialog);


        edt_board_version_dialog.setText("");
        edt_board_code_dialog.setText("");
        edt_chip_name1_dialog.setText("");
        edt_chip_name2_dialog.setText("");
        edt_Contents_dialog.setText("");
        edt_User_dialog.setText("");
        btn_before_version_dialog.setText("????????????");
        btn_after_version_dialog.setText("????????????");
        btn_calendar_select_dialog.setText("????????????");
        btn_image_board_dialog.setText("????????? ??????");
        temp15_dialog = "";

        temp1_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp1_dialog = parent.getItemAtPosition(position).toString();
                if (temp1_dialog.equals("??????")) {
                    temp1_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp2_dialog = parent.getItemAtPosition(position).toString();
                if (temp2_dialog.equals("??????")) {
                    temp2_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp3_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3_dialog = parent.getItemAtPosition(position).toString();
                if (temp3_dialog.equals("??????")) {
                    temp3_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp4_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp4_dialog = parent.getItemAtPosition(position).toString();
                if (temp4_dialog.equals("??????")) {
                    temp4_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp5_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp5_dialog = parent.getItemAtPosition(position).toString();
                if (temp5_dialog.equals("??????")) {
                    temp5_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp6_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp6_dialog = parent.getItemAtPosition(position).toString();
                if (temp6_dialog.equals("??????")) {
                    temp6_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp7_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp7_dialog = parent.getItemAtPosition(position).toString();
                if (temp7_dialog.equals("??????")) {
                    temp7_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp8_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp8_dialog = parent.getItemAtPosition(position).toString();
                if (temp8_dialog.equals("??????")) {
                    temp8_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        DbHandler_board db = new DbHandler_board(getActivity());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1_spinner_dialog.setAdapter(dataAdapter);

        DbHandler_board1 db1 = new DbHandler_board1(getActivity());
        List<String> labels1 = db1.getAllLabels();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1);

        DbHandler_board1_1 db1_1 = new DbHandler_board1_1(getActivity());
        List<String> labels1_1 = db1_1.getAllLabels();
        ArrayAdapter<String> dataAdapter1_1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_1);

        DbHandler_board1_2 db1_2 = new DbHandler_board1_2(getActivity());
        List<String> labels1_2 = db1_2.getAllLabels();
        ArrayAdapter<String> dataAdapter1_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_2);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_2);

        DbHandler_board1_3 db1_3 = new DbHandler_board1_3(getActivity());
        List<String> labels1_3 = db1_3.getAllLabels();
        ArrayAdapter<String> dataAdapter1_3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_3);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_3);

        DbHandler_board1_4 db1_4 = new DbHandler_board1_4(getActivity());
        List<String> labels1_4 = db1_4.getAllLabels();
        ArrayAdapter<String> dataAdapter1_4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_4);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_4);

        DbHandler_board1_5 db1_5 = new DbHandler_board1_5(getActivity());
        List<String> labels1_5 = db1_5.getAllLabels();
        ArrayAdapter<String> dataAdapter1_5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_5);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_5);

        DbHandler_board1_6 db1_6 = new DbHandler_board1_6(getActivity());
        List<String> labels1_6 = db1_6.getAllLabels();
        ArrayAdapter<String> dataAdapter1_6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_6);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_6);

        DbHandler_board1_7 db1_7 = new DbHandler_board1_7(getActivity());
        List<String> labels1_7 = db1_7.getAllLabels();
        ArrayAdapter<String> dataAdapter1_7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1_7);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1_7);

        DbHandler_board2 db2 = new DbHandler_board2(getActivity());
        List<String> labels2 = db2.getAllLabels();
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp3_spinner_dialog.setAdapter(dataAdapter2);

        DbHandler_board3 db3 = new DbHandler_board3(getActivity());
        List<String> labels3 = db3.getAllLabels();
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp4_spinner_dialog.setAdapter(dataAdapter3);

        DbHandler_board4 db4 = new DbHandler_board4(getActivity());
        List<String> labels4 = db4.getAllLabels();
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp5_spinner_dialog.setAdapter(dataAdapter4);

        DbHandler_board5 db5 = new DbHandler_board5(getActivity());
        List<String> labels5 = db5.getAllLabels();
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp6_spinner_dialog.setAdapter(dataAdapter5);

        DbHandler_board6 db6 = new DbHandler_board6(getActivity());
        List<String> labels6 = db6.getAllLabels();
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp7_spinner_dialog.setAdapter(dataAdapter6);

        DbHandler_board7 db7 = new DbHandler_board7(getActivity());
        List<String> labels7 = db7.getAllLabels();
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp8_spinner_dialog.setAdapter(dataAdapter7);


        btn_calendar_select_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog dlg = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            btn_calendar_select_dialog.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            temp16_dialog = btn_calendar_select_dialog.getText().toString();
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dlg.getDatePicker().setCalendarViewShown(false);
                dlg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dlg.show();
            }
        });


        btn_before_version_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_version_dialog.show();
                edt_before_version_dialog1 = before_version_dialog.findViewById(R.id.edt_before_version_dialog1);
                edt_before_version_dialog2 = before_version_dialog.findViewById(R.id.edt_before_version_dialog2);
                edt_before_version_dialog3 = before_version_dialog.findViewById(R.id.edt_before_version_dialog3);
                Button btn_before_version_no = before_version_dialog.findViewById(R.id.btn_before_version1);
                Button btn_before_version_yes = before_version_dialog.findViewById(R.id.btn_before_version2);

                btn_before_version_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        before_version_dialog.dismiss();
                        edt_before_version_dialog1.setText("");
                        edt_before_version_dialog2.setText("");
                        edt_before_version_dialog3.setText("");
                    }
                });
                btn_before_version_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String v1 = edt_before_version_dialog1.getText().toString();
                        String v2 = edt_before_version_dialog2.getText().toString();
                        String v3 = edt_before_version_dialog3.getText().toString();
                        String after_all_v = v1 + "." + v2 + "." + v3;
                        btn_before_version_dialog.setText(after_all_v);
                        edt_before_version_dialog1.setText("");
                        edt_before_version_dialog2.setText("");
                        edt_before_version_dialog3.setText("");
                        before_version_dialog.dismiss();
                    }

                });
            }
        });

        btn_after_version_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_version_dialog.show();
                edt_after_version_dialog1 = after_version_dialog.findViewById(R.id.edt_after_version_dialog1);
                edt_after_version_dialog2 = after_version_dialog.findViewById(R.id.edt_after_version_dialog2);
                edt_after_version_dialog3 = after_version_dialog.findViewById(R.id.edt_after_version_dialog3);
                Button btn_after_version_no = after_version_dialog.findViewById(R.id.btn_after_version1);
                Button btn_after_version_yes = after_version_dialog.findViewById(R.id.btn_after_version2);

                btn_after_version_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        after_version_dialog.dismiss();
                        edt_after_version_dialog1.setText("");
                        edt_after_version_dialog2.setText("");
                        edt_after_version_dialog3.setText("");
                    }
                });
                btn_after_version_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String v1 = edt_after_version_dialog1.getText().toString();
                        String v2 = edt_after_version_dialog2.getText().toString();
                        String v3 = edt_after_version_dialog3.getText().toString();
                        String after_all_v = v1 + "." + v2 + "." + v3;
                        btn_after_version_dialog.setText(after_all_v);
                        edt_after_version_dialog1.setText("");
                        edt_after_version_dialog2.setText("");
                        edt_after_version_dialog3.setText("");
                        after_version_dialog.dismiss();
                    }

                });
            }
        });

        btn_image_board_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board_img_case = 2;
                addImage();
            }
        });

        btn_item_list_update_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String position2 = position1;
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                temp9_dialog = edt_board_version_dialog.getText().toString();
                temp10_dialog = edt_board_code_dialog.getText().toString();
                temp11_dialog = edt_chip_name1_dialog.getText().toString();
                temp12_dialog = edt_chip_name2_dialog.getText().toString();
                temp17_dialog = edt_User_dialog.getText().toString();
                temp18_dialog = edt_Contents_dialog.getText().toString();
                temp13_dialog = btn_before_version_dialog.getText().toString();
                if (temp13_dialog.equals("????????????")) {
                    temp13_dialog = "";
                }
                temp14_dialog = btn_after_version_dialog.getText().toString();
                if (temp14_dialog.equals("????????????")) {
                    temp14_dialog = "";
                }
                if (temp15_dialog == null) {
                    temp15_dialog = "";
                }
                temp16_dialog = btn_calendar_select_dialog.getText().toString();
                if (temp16_dialog.equals("????????????")) {
                    temp16_dialog = "";
                }
                temp_trim_dialog();
                String qry = "UPDATE board_database SET menual = '" + temp15_dialog + "', board_kind = '" + temp1_dialog + "', board_type = '" + temp2_dialog + "', board_version = '" + temp9_dialog + "'" +
                        ", board_code = '" + temp10_dialog + "', chipset1 = '" + temp3_dialog + "', chipset_name1 = '" + temp11_dialog + "', chipset2 = '" + temp4_dialog + "', chipset_name2 = '" + temp12_dialog + "', registration = '" + temp5_dialog + "'" +
                        ", request = '" + temp6_dialog + "', model = '" + temp7_dialog + "', before_version = '" + temp13_dialog + "', after_version = '" + temp14_dialog + "', date = '" + temp16_dialog + "', change_point = '" + temp18_dialog + "'" +
                        ", writer = '" + temp17_dialog + "', bundle = '" + temp8_dialog + "' WHERE  num = '" + position2 + "'";
                database.execSQL(qry);
                edt_board_version_dialog.setText("");
                edt_board_code_dialog.setText("");
                edt_chip_name1_dialog.setText("");
                edt_chip_name2_dialog.setText("");
                edt_Contents_dialog.setText("");
                edt_User_dialog.setText("");
                btn_before_version_dialog.setText("????????????");
                btn_after_version_dialog.setText("????????????");
                btn_calendar_select_dialog.setText("????????????");
                btn_image_board_dialog.setText("????????? ??????");
                temp15_dialog = "";
                Toast.makeText(getContext(), "????????????", Toast.LENGTH_SHORT).show();
                item_listview_dialog2_board.dismiss(); // ??????????????? ??????
                displayList(); //???????????? ????????????
            }
        });

        btn_item_list_cancel_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edt_board_version_dialog.setText("");
                edt_board_code_dialog.setText("");
                edt_chip_name1_dialog.setText("");
                edt_chip_name2_dialog.setText("");
                edt_Contents_dialog.setText("");
                edt_User_dialog.setText("");
                btn_before_version_dialog.setText("????????????");
                btn_after_version_dialog.setText("????????????");
                btn_calendar_select_dialog.setText("????????????");
                btn_image_board_dialog.setText("????????? ??????");
                temp15_dialog = "";
                item_listview_dialog2_board.dismiss(); // ??????????????? ??????
            }
        });
    }

    // Bitmap??? Byte??? ??????
    public byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        byte[] image = null;

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case camera:
                    Bundle extras = data.getExtras();
                    Bitmap bm_camera = (Bitmap) extras.get("data");
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm_camera.compress(Bitmap.CompressFormat.PNG, 70, baos);
                    byte[] bytes_camera = baos.toByteArray();
                    temp1 = Base64.encodeToString(bytes_camera, Base64.DEFAULT);
//                    temp1 = baos.toByteArray();
                    if (board_img_case == 1){
                        temp1 = Base64.encodeToString(bytes_camera, Base64.DEFAULT);
                        btn_image_board.setText("????????? ????????????");
                    } else if (board_img_case == 2){
                        temp15_dialog = Base64.encodeToString(bytes_camera, Base64.DEFAULT);
                        btn_image_board_dialog.setText("????????? ????????????");
                    }
                    break;

                case gallery:
                    selectedImageUri = data.getData();
                    Bitmap bm_gallery = null;
                    Bitmap resize = null;
                    try {
                        bm_gallery = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
//                        resize  = bm_gallery.createScaledBitmap(bm_gallery,150,120,true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    temp1 = selectedImageUri.toString();
//                    imageView_board.setImageURI(selectedImageUri);
//                    BitmapDrawable drawable = (BitmapDrawable) imageView_board.getDrawable();
//                    Bitmap bitmap = drawable.getBitmap();
//                    BitmapDrawable ob1 = new BitmapDrawable(getResources(), bm);
//                    imageView_board.setBackground(ob1);
//                    imageView_board.setImageBitmap(bm);
                    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                    bm_gallery.compress(Bitmap.CompressFormat.PNG, 70, baos1);
                    byte[] bytes_gallery = baos1.toByteArray();
                    if (board_img_case == 1){
                        temp1 = Base64.encodeToString(bytes_gallery, Base64.DEFAULT);
                        btn_image_board.setText("????????? ????????????");
                    } else if (board_img_case == 2){
                        temp15_dialog = Base64.encodeToString(bytes_gallery, Base64.DEFAULT);
                        btn_image_board_dialog.setText("????????? ????????????");
                    }
                    break;
            }
        }
    }


    void addImage() {
        SetImageboard.show();

        camerapopBtn = (Button) SetImageboard.findViewById(R.id.camerapopBtn);
        gallerypopBtn = (Button) SetImageboard.findViewById(R.id.gallerypopBtn);
        ClosepopBtn = (Button) SetImageboard.findViewById(R.id.ClosepopBtn);

        camerapopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imageTakeIntent, camera);
                SetImageboard.dismiss();
            }
        });

        gallerypopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                startActivityForResult(intent, gallery);
                SetImageboard.dismiss();
            }
        });

        ClosepopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "?????????????????????.", Toast.LENGTH_SHORT).show();
                SetImageboard.dismiss();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        layout_menu3 = (LinearLayout) view.findViewById(R.id.layout_menu3);
        lv_list_board = (ListView) view.findViewById(R.id.lv_list_board);

        temp1_spinner_board = (Spinner) view.findViewById(R.id.temp1_spinner_board);
        temp2_spinner_board1 = (Spinner) view.findViewById(R.id.temp2_spinner_board1);
        temp2_spinner_board2 = (Spinner) view.findViewById(R.id.temp2_spinner_board2);
        temp2_spinner_board3 = (Spinner) view.findViewById(R.id.temp2_spinner_board3);
        temp2_spinner_board4 = (Spinner) view.findViewById(R.id.temp2_spinner_board4);
        temp2_spinner_board5 = (Spinner) view.findViewById(R.id.temp2_spinner_board5);
        temp2_spinner_board6 = (Spinner) view.findViewById(R.id.temp2_spinner_board6);
        temp2_spinner_board7 = (Spinner) view.findViewById(R.id.temp2_spinner_board7);
        temp2_spinner_board8 = (Spinner) view.findViewById(R.id.temp2_spinner_board8);
        temp3_spinner_board = (Spinner) view.findViewById(R.id.temp3_spinner_board);
        temp4_spinner_board = (Spinner) view.findViewById(R.id.temp4_spinner_board);
        temp5_spinner_board = (Spinner) view.findViewById(R.id.temp5_spinner_board);
        temp6_spinner_board = (Spinner) view.findViewById(R.id.temp6_spinner_board);
        temp7_spinner_board = (Spinner) view.findViewById(R.id.temp7_spinner_board);
        temp8_spinner_board = (Spinner) view.findViewById(R.id.temp8_spinner_board);

        btn_menu3 = (Button) view.findViewById(R.id.btn_menu3);
        btn_before_version_board = (Button) view.findViewById(R.id.btn_before_version_board);
        btn_after_version_board = (Button) view.findViewById(R.id.btn_after_version_board);
        btn_calendar_select_board = (Button) view.findViewById(R.id.btn_calendar_select_board);
        btn_select_search_board = (Button) view.findViewById(R.id.btn_select_search_board);
        btn_insert_listView_board = (Button) view.findViewById(R.id.btn_insert_listView_board);
        btn_image_board = (Button) view.findViewById(R.id.btn_image_board);

        imageView_board = (ImageView) view.findViewById(R.id.imageView_board);

        edt_board_version = (EditText) view.findViewById(R.id.edt_board_version);
        edt_board_code = (EditText) view.findViewById(R.id.edt_board_code);
        edt_board_chip_name1 = (EditText) view.findViewById(R.id.edt_board_chip_name1);
        edt_board_chip_name2 = (EditText) view.findViewById(R.id.edt_board_chip_name2);
        edt_user_board = (EditText) view.findViewById(R.id.edt_user_board);
        edt_Contents_board = (EditText) view.findViewById(R.id.edt_Contents_board);


        item_listview_board_image = new Dialog(getContext());       // Dialog ?????????
        item_listview_board_image.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        item_listview_board_image.setContentView(R.layout.item_listview_board_image);

        item_listview_dialog2_board = new Dialog(getContext());       // Dialog ?????????
        item_listview_dialog2_board.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        item_listview_dialog2_board.setContentView(R.layout.item_listview_dialog2_board);

        SetImageboard = new Dialog(getContext());       // Dialog ?????????
        SetImageboard.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        SetImageboard.setContentView(R.layout.board_setimage);

        item_listview_dialog = new Dialog(getContext());       // Dialog ?????????
        item_listview_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        item_listview_dialog.setContentView(R.layout.item_listview_dialog);

        item_listview_dialog2 = new Dialog(getContext());       // Dialog ?????????
        item_listview_dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        item_listview_dialog2.setContentView(R.layout.dialog02);

        spinner_dialog = new Dialog(getContext());       // Dialog ?????????
        spinner_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        spinner_dialog.setContentView(R.layout.spinner_dialog);

        spinner_edt_del_dialog = new Dialog(getContext());       // Dialog ?????????
        spinner_edt_del_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        spinner_edt_del_dialog.setContentView(R.layout.spinner_edt_del_dialog);

        insert_dialog = new Dialog(getContext());       // Dialog ?????????
        insert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // ????????? ??????
        insert_dialog.setContentView(R.layout.insert_dialog);


        before_version_dialog = new Dialog(getContext());       // Dialog ?????????
        before_version_dialog.setTitle("?????? ??????");
        before_version_dialog.setContentView(R.layout.before_version_dialog);

        after_version_dialog = new Dialog(getContext());       // Dialog ?????????
        after_version_dialog.setTitle("?????? ??????");
        after_version_dialog.setContentView(R.layout.after_version_dialog);


        btn_image_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board_img_case = 1;
                addImage();
            }
        });

        btn_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutchange == true) { //true??? ??? ??????
                    btn_menu3.setText("???");
                    layout_menu3.setVisibility(View.VISIBLE);
                    layoutchange = false; // ?????? ??? false??? ??????
                } else {
                    btn_menu3.setText("???");
                    layout_menu3.setVisibility(View.GONE);
                    layoutchange = true; // ?????? ??? true??? ??????
                }
            }
        });

        temp1_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp2 = parent.getItemAtPosition(position).toString();
                if (temp2.equals("??????")) {
                    temp2 = "";
                } else if(temp2.equals("??????????????????")){
                    temp2_spinner_board1.setVisibility(View.VISIBLE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("SORTING??????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.VISIBLE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("LED???????????????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.VISIBLE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("?????????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.VISIBLE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("DIO??????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.VISIBLE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("FEEDER??????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.VISIBLE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("EJECT??????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.VISIBLE);
                    temp2_spinner_board8.setVisibility(View.GONE);
                }else if(temp2.equals("DISPLAY??????")){
                    temp2_spinner_board1.setVisibility(View.GONE);
                    temp2_spinner_board2.setVisibility(View.GONE);
                    temp2_spinner_board3.setVisibility(View.GONE);
                    temp2_spinner_board4.setVisibility(View.GONE);
                    temp2_spinner_board5.setVisibility(View.GONE);
                    temp2_spinner_board6.setVisibility(View.GONE);
                    temp2_spinner_board7.setVisibility(View.GONE);
                    temp2_spinner_board8.setVisibility(View.VISIBLE);
                } else if (temp2.equals("????????????")) {
                    i = 0;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp1_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 0;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_board8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("??????")) {
                    temp3 = "";
                } else if (temp3.equals("????????????")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp2_spinner_board8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp3_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp6 = parent.getItemAtPosition(position).toString();
                if (temp6.equals("??????")) {
                    temp6 = "";
                } else if (temp6.equals("????????????")) {
                    i = 2;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp3_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 2;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp4_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp8 = parent.getItemAtPosition(position).toString();
                if (temp8.equals("??????")) {
                    temp8 = "";
                } else if (temp8.equals("????????????")) {
                    i = 3;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp4_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 3;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp5_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp10 = parent.getItemAtPosition(position).toString();
                if (temp10.equals("??????")) {
                    temp10 = "";
                } else if (temp10.equals("????????????")) {
                    i = 4;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp5_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 4;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp6_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp11 = parent.getItemAtPosition(position).toString();
                if (temp11.equals("??????")) {
                    temp11 = "";
                } else if (temp11.equals("????????????")) {
                    i = 5;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp6_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 5;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp7_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp12 = parent.getItemAtPosition(position).toString();
                if (temp12.equals("??????")) {
                    temp12 = "";
                } else if (temp12.equals("????????????")) {
                    i = 6;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp7_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 6;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp8_spinner_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp18 = parent.getItemAtPosition(position).toString();
                if (temp18.equals("??????")) {
                    temp18 = "";
                } else if (temp18.equals("????????????")) {
                    i = 7;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp8_spinner_board.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 7;
                spinner_edt_del_dialog();
                return true;
            }
        });

        loadSpinnerData1(); //???????????? ????????? ????????? ??????

        btn_after_version_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_version_dialog();
            }
        });

        btn_before_version_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_version_dialog();
            }
        });

        btn_calendar_select_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog dlg = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            btn_calendar_select_board.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            temp15 = btn_calendar_select_board.getText().toString();
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dlg.getDatePicker().setCalendarViewShown(false);
                dlg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dlg.show();
            }
        });

        btn_insert_listView_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp1 == null) {
                    temp1 = "";
                }
                temp4 = edt_board_version.getText().toString();
                temp5 = edt_board_code.getText().toString();
                temp7 = edt_board_chip_name1.getText().toString();
                temp9 = edt_board_chip_name2.getText().toString();
                temp13 = btn_before_version_board.getText().toString();
                if (temp13.equals("????????????")) {
                    temp13 = "";
                }
                temp14 = btn_after_version_board.getText().toString();
                if (temp14.equals("????????????")) {
                    temp14 = "";
                }
                temp15 = btn_calendar_select_board.getText().toString();
                if (temp15 == null) {
                    temp15 = "";
                }
                if (temp15.equals("????????????")) {
                    temp15 = "";
                }
                temp16 = edt_Contents_board.getText().toString();
                temp17 = edt_user_board.getText().toString();
                temp19 = "";
                temp20 = "";
                temp21 = "";
                temp22 = "";
                temp23 = "";
                temp24 = "";
                temp25 = "";
                temp_trim();
                insert_dialog();
            }
        });

        btn_select_search_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp1 == null) {
                    temp1 = "";
                }
                temp4 = edt_board_version.getText().toString();
                temp5 = edt_board_code.getText().toString();
                temp7 = edt_board_chip_name1.getText().toString();
                temp9 = edt_board_chip_name2.getText().toString();
                temp13 = btn_before_version_board.getText().toString();
                if (temp13.equals("????????????")) {
                    temp13 = "";
                }
                temp14 = btn_after_version_board.getText().toString();
                if (temp14.equals("????????????")) {
                    temp14 = "";
                }
                temp15 = btn_calendar_select_board.getText().toString();
                if (temp15 == null) {
                    temp15 = "";
                }
                if (temp15.equals("????????????")) {
                    temp15 = "";
                }
                temp16 = edt_Contents_board.getText().toString();
                temp17 = edt_user_board.getText().toString();
                temp_trim();
                select_Spinner(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18);
                spinner_reset();
            }
        });

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        lv_list_board.setAdapter(adapter);

        lv_list_board.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String position1 = adapterView.getItemAtPosition(position).toString();
                Bitmap position1_image= (Bitmap) adapterView.getAdapter().getItem(position);
//                Toast.makeText(getContext(), position1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "NO. " + position1, Toast.LENGTH_SHORT).show();
                item_listview_board_image.show();
                Button listView_board_cancel = item_listview_board_image.findViewById(R.id.listView_board_cancel);
                ImageView listView_board_image = item_listview_board_image.findViewById(R.id.listView_board_image);
                listView_board_image.setImageBitmap(position1_image);
                listView_board_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        item_listview_board_image.dismiss();
                    }
                });
            }

        });

        lv_list_board.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                item_listview_dialog.dismiss();
                ListViewAdapter_board ListViewAdapter_board = new ListViewAdapter_board() ;
                String position1 = adapterView.getItemAtPosition(position).toString();
//                int position_to_int = Integer.parseInt(position1);
//                Bitmap position1_image = ListViewAdapter_board.getItem_image(position_to_int);
                Bitmap position1_image= (Bitmap) adapterView.getAdapter().getItem(position);
//                String aa = ListViewAdapter_board.getItem(position).toString();
//                Toast.makeText(getContext(), position1, Toast.LENGTH_SHORT).show();
                showDialog01(position1, position1_image);
                return true;
            }
        });

        return view;
    }
    private void temp_trim(){
//        temp1 = temp1.trim(); ?????????
        temp2 = temp2.trim();
        temp3 = temp3.trim();
        temp4 = temp4.trim();
        temp5 = temp5.trim();
        temp6 = temp6.trim();
        temp7 = temp7.trim();
        temp8 = temp8.trim();
        temp9 = temp9.trim();
        temp10 = temp10.trim();
        temp11 = temp11.trim();
        temp12 = temp12.trim();
        temp13 = temp13.trim();
        temp14 = temp14.trim();
        temp15 = temp15.trim();
        temp16 = temp16.trim();
        temp17 = temp17.trim();
        temp18 = temp18.trim();
    }

    private void temp_trim_dialog(){
        temp1_dialog = temp1_dialog.trim();
        temp2_dialog = temp2_dialog.trim();
        temp3_dialog = temp3_dialog.trim();
        temp4_dialog = temp4_dialog.trim();
        temp5_dialog = temp5_dialog.trim();
        temp6_dialog = temp6_dialog.trim();
        temp7_dialog = temp7_dialog.trim();
        temp8_dialog = temp8_dialog.trim();
        temp9_dialog = temp9_dialog.trim();
        temp10_dialog = temp10_dialog.trim();
        temp11_dialog = temp11_dialog.trim();
        temp12_dialog = temp12_dialog.trim();
        temp13_dialog = temp13_dialog.trim();
        temp14_dialog = temp14_dialog.trim();
//        temp15_dialog = temp15_dialog.trim(); ?????????
        temp16_dialog = temp16_dialog.trim();
        temp17_dialog = temp17_dialog.trim();
        temp18_dialog = temp18_dialog.trim();
    }
}