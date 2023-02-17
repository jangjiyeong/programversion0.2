package com.example.programversion02;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class Fragment1 extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2, str;

    private int i;

    private TextView tv_insert, edt_Contents, edt_User;

    private Spinner temp1_spinner, temp2_spinner, temp3_spinner, temp4_spinner, temp5_spinner, temp6_spinner, temp7_spinner, temp8_spinner, temp9_spinner;
    public Spinner temp1_spinner_dialog, temp2_spinner_dialog, temp3_spinner_dialog, temp4_spinner_dialog, temp5_spinner_dialog, temp6_spinner_dialog, temp7_spinner_dialog, temp8_spinner_dialog;

    private Button btn_select_search, btn_calendar_select, btn_insert_listView, btn_menu, btn_before_version, btn_after_version,btn_compatibility;
    private String User;

    private String temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18, temp19, temp20, temp21, temp22, temp23, temp24, temp25;
    private String temp1_dialog, temp2_dialog, temp3_dialog, temp4_dialog, temp5_dialog, temp6_dialog, temp7_dialog, temp8_dialog, temp9_dialog, temp10_dialog,
            temp11_dialog, temp12_dialog, temp13_dialog, temp14_dialog, temp15_dialog, temp16_dialog, temp17_dialog, temp18_dialog, temp19_dialog, temp20_dialog,
            temp21_dialog, temp22_dialog, temp23_dialog, temp24_dialog, temp25_dialog;
    static String F_ID, F_ID_dialog;
    private ImageView imageView;
    private final int GET_GALLERY_IMAGE = 200;
    LinearLayout layout_menu;

    Dialog spinner_dialog, before_version_dialog, after_version_dialog, spinner_edt_del_dialog, insert_dialog, item_listview_dialog, item_listview_dialog2,compatibility_dialog;

    private ListView lvList;
    private ArrayAdapter<String> adapter;

    private EditText spinner_edt_dialog, edt_before_version_dialog1, edt_before_version_dialog2, edt_before_version_dialog3, edt_before_version_dialog4, edt_after_version_dialog1, edt_after_version_dialog2, edt_after_version_dialog3, edt_after_version_dialog4, edt_file_name, edt_git_branch,
            spinner_edt_del;

    private Boolean layoutchange = true;


    public Fragment1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
//        myDBHelper = new myDBHelper(getActivity());

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK) {
            if (data != null && data.getData() != null) {
                int count = data.getClipData().getItemCount();
                for (int i = 0; i < count; i++) {
                    Uri imageUri = data.getClipData().getItemAt(i).getUri();
                }
            } else if (data.getData() != null) {
                Uri selectedImageUri = data.getData();
            }

//            Uri selectedImageUri = data.getData();
//            imageView.setImageURI(selectedImageUri);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }


    void displayList() {
        //Dbhelper의 읽기모드 객체를 가져와 SQLiteDatabase에 담아 사용준비
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();

        //Cursor라는 그릇에 목록을 담아주기
        Cursor cursor = database.rawQuery("SELECT * FROM sw_database", null);

        //리스트뷰에 목록 채워주는 도구인 adapter준비
        ListViewAdapter adapter = new ListViewAdapter();

        //목록의 개수만큼 순회하여 adapter에 있는 list배열에 add
        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                    cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16));
        }

        //리스트뷰의 어댑터 대상을 여태 설계한 adapter로 설정
        lvList.setAdapter(adapter);

    }

    void insert_Spinner(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9,
                        String name10, String name11, String name12, String name13, String name14, String name15, String name16, String name17, String name18, String name19,
                        String name20, String name21, String name22, String name23, String name24, String name25) {
        //Dbhelper의 쓰기모드 객체를 가져옴
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();

        String qry = "INSERT INTO sw_database(model, camera, resolution, channel, registration, request, board_type, country, bundle, before_version, after_version, date, file_name, git_branch, change_point, writer, name17, name18, name19, name20, name21, name22, name23, name24, name25) VALUES(" +
                "'" + name1 + "','" + name2 + "','" + name3 + "','" + name4 + "','" + name5 + "','" + name6 + "','" + name7 + "','" + name8 + "','" + name9 + "','" + name10 + "','" + name11 + "','" + name12 + "','" + name13 + "','" + name14 + "','" + name15 + "','" + name16 + "','" + name17 + "','" + name18 + "','" + name19 + "'" +
                ",'" + name20 + "','" + name21 + "','" + name22 + "','" + name23 + "','" + name24 + "','" + name25 + "')";

        database.execSQL(qry); //만들어준 쿼리문 실행

        displayList(); //리스트뷰 새로고침

    }

    void spinner_updateStudent(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9,
                               String name10, String name11, String name12, String name13, String name14, String name15, String name16, String name17, String name18, String name19,
                               String name20, String name21, String name22, String name23, String name24, String name25) {
        //Dbhelper의 쓰기모드 객체를 가져옴
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();

        String qry = "UPDATE sw_database SET model = '" + spinner_edt_del + "' WHERE  '" + name1 + "' = '" + temp1 + "'";
        database.execSQL(qry); //만들어준 쿼리문 실행

        displayList(); //리스트뷰 새로고침

    }

    void select_Spinner(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10,
                        String name11, String name12, String name13, String name14, String name15, String name16) {
        //Dbhelper의 쓰기모드 객체를 가져옴
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT * FROM sw_database WHERE" +
                " model LIKE '%" + name1 + "%' AND " +
                " camera LIKE '%" + name2 + "%' AND " +
                " resolution LIKE '%" + name3 + "%' AND" +
                " channel LIKE '%" + name4 + "%' AND" +
                " registration LIKE '%" + name5 + "%' AND" +
                " request LIKE '%" + name6 + "%' AND" +
                " board_type LIKE '%" + name7 + "%' AND" +
                " country LIKE '%" + name8 + "%' AND" +
                " bundle LIKE '%" + name9 + "%' AND" +
                " before_version LIKE '%" + name10 + "%' AND" +
                " after_version LIKE '%" + name11 + "%' AND" +
                " date LIKE '%" + name12 + "%' AND" +
                " file_name LIKE '%" + name13 + "%' AND" +
                " git_branch LIKE '%" + name14 + "%' AND" +
                " change_point LIKE '%" + name15 + "%' AND" +
                " writer LIKE '%" + name16 + "%';";

        cursor = database.rawQuery(qry, null); //만들어준 쿼리문 실행

        ListViewAdapter adapter = new ListViewAdapter();

        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
                    cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                    cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16));
        }


        cursor.close();
        database.close();

        lvList.setAdapter(adapter);

    }

    public void showDialog01(String position) {
        item_listview_dialog.show(); // 다이얼로그 띄우기
        String position1 = position;
        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

        // 아니오 버튼
        Button noBtn = item_listview_dialog.findViewById(R.id.btn_cancel);
        Button btn_image_view =item_listview_dialog.findViewById(R.id.btn_image_view);
        btn_image_view.setVisibility(View.GONE);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                item_listview_dialog.dismiss(); // 다이얼로그 닫기
            }
        });

        item_listview_dialog.findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "수정", Toast.LENGTH_SHORT).show();
                showDialog02(position1);
                item_listview_dialog.dismiss();
            }
        });

        item_listview_dialog.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "삭제완료", Toast.LENGTH_SHORT).show();
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                String qry = "DELETE FROM sw_database WHERE num = '" + position1 + "'";
                database.execSQL(qry);
                item_listview_dialog.dismiss();
                displayList(); //리스트뷰 새로고침
            }
        });
    }

    public void showDialog02(String position1) {
        item_listview_dialog2.show(); // 다이얼로그 띄우기
        Spinner temp1_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp1_spinner_dialog);
        Spinner temp2_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp2_spinner_dialog);
        Spinner temp3_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp3_spinner_dialog);
        Spinner temp4_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp4_spinner_dialog);
        Spinner temp5_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp5_spinner_dialog);
        Spinner temp6_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp6_spinner_dialog);
        Spinner temp7_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp7_spinner_dialog);
        Spinner temp8_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp8_spinner_dialog);
        Spinner temp9_spinner_dialog = item_listview_dialog2.findViewById(R.id.temp9_spinner_dialog);
        Button btn_calendar_select_dialog = item_listview_dialog2.findViewById(R.id.btn_calendar_select_dialog);
        Button btn_before_version_dialog = item_listview_dialog2.findViewById(R.id.btn_before_version_dialog);
        Button btn_after_version_dialog = item_listview_dialog2.findViewById(R.id.btn_after_version_dialog);
        EditText edt_User_dialog = item_listview_dialog2.findViewById(R.id.edt_User_dialog);
        EditText edt_git_branch_dialog = item_listview_dialog2.findViewById(R.id.edt_git_branch_dialog);
        EditText edt_file_name_dialog = item_listview_dialog2.findViewById(R.id.edt_file_name_dialog);
        EditText edt_Contents_dialog = item_listview_dialog2.findViewById(R.id.edt_Contents_dialog);


        temp1_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp1_dialog = parent.getItemAtPosition(position).toString();
                if (temp1_dialog.equals("전체")) {
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
                if (temp2_dialog.equals("전체")) {
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
                if (temp3_dialog.equals("전체")) {
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
                if (temp4_dialog.equals("전체")) {
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
                if (temp5_dialog.equals("전체")) {
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
                if (temp6_dialog.equals("전체")) {
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
                if (temp7_dialog.equals("전체")) {
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
                if (temp8_dialog.equals("전체")) {
                    temp8_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        temp9_spinner_dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp9_dialog = parent.getItemAtPosition(position).toString();
                if (temp9_dialog.equals("전체")) {
                    temp9_dialog = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        DbHandler db = new DbHandler(getActivity());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1_spinner_dialog.setAdapter(dataAdapter);

        DbHandler1 db1 = new DbHandler1(getActivity());
        List<String> labels1 = db1.getAllLabels();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_dialog.setAdapter(dataAdapter1);

        DbHandler2 db2 = new DbHandler2(getActivity());
        List<String> labels2 = db2.getAllLabels();
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp3_spinner_dialog.setAdapter(dataAdapter2);

        DbHandler3 db3 = new DbHandler3(getActivity());
        List<String> labels3 = db3.getAllLabels();
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp4_spinner_dialog.setAdapter(dataAdapter3);

        DbHandler4 db4 = new DbHandler4(getActivity());
        List<String> labels4 = db4.getAllLabels();
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp5_spinner_dialog.setAdapter(dataAdapter4);

        DbHandler5 db5 = new DbHandler5(getActivity());
        List<String> labels5 = db5.getAllLabels();
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp6_spinner_dialog.setAdapter(dataAdapter5);

        DbHandler6 db6 = new DbHandler6(getActivity());
        List<String> labels6 = db6.getAllLabels();
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp7_spinner_dialog.setAdapter(dataAdapter6);

        DbHandler7 db7 = new DbHandler7(getActivity());
        List<String> labels7 = db7.getAllLabels();
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp8_spinner_dialog.setAdapter(dataAdapter7);

        DbHandler8 db8 = new DbHandler8(getActivity());
        List<String> labels8 = db8.getAllLabels();
        ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels8);
        dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp9_spinner_dialog.setAdapter(dataAdapter8);

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
                            temp12_dialog = btn_calendar_select_dialog.getText().toString();
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

        Button btn_dialog02_update_dialog = item_listview_dialog2.findViewById(R.id.btn_item_list_update_dialog);
        btn_dialog02_update_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String position2 = position1;
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                temp10_dialog = btn_before_version_dialog.getText().toString();
                if (temp10_dialog.equals("이전버전")) {
                    temp10_dialog = "";
                }
                temp11_dialog = btn_after_version_dialog.getText().toString();
                if (temp11_dialog.equals("변경버전")) {
                    temp11_dialog = "";
                }
                if (temp12_dialog == null) {
                    temp12_dialog = "";
                }
                temp13_dialog = edt_file_name_dialog.getText().toString();
                temp14_dialog = edt_git_branch_dialog.getText().toString();
                temp15_dialog = edt_Contents_dialog.getText().toString();
                F_ID_dialog = edt_User_dialog.getText().toString();
                temp_trim_dialog();
                String qry = "UPDATE sw_database SET model = '" + temp1_dialog + "', camera = '" + temp2_dialog + "', resolution = '" + temp3_dialog + "', channel = '" + temp4_dialog + "'" +
                        ", registration = '" + temp5_dialog + "', request = '" + temp6_dialog + "', board_type = '" + temp7_dialog + "', country = '" + temp8_dialog + "', bundle = '" + temp9_dialog + "', before_version = '" + temp10_dialog + "'" +
                        ", after_version = '" + temp11_dialog + "', date = '" + temp12_dialog + "', file_name = '" + temp13_dialog + "', git_branch = '" + temp14_dialog + "', change_point = '" + temp15_dialog + "', writer = '" + F_ID_dialog + "' WHERE  num = '" + position2 + "'";
                database.execSQL(qry);
                edt_file_name_dialog.setText("");
                edt_git_branch_dialog.setText("");
                edt_Contents_dialog.setText("");
                edt_User_dialog.setText("");
                btn_before_version_dialog.setText("이전버전");
                btn_after_version_dialog.setText("변경버전");
                btn_calendar_select_dialog.setText("날짜선택");

                Toast.makeText(getContext(), "수정완료", Toast.LENGTH_SHORT).show();
                item_listview_dialog2.dismiss(); // 다이얼로그 닫기
                displayList(); //리스트뷰 새로고침
            }
        });
        Button btn_item_list_cancel_dialog = item_listview_dialog2.findViewById(R.id.btn_item_list_cancel_dialog);
        btn_item_list_cancel_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edt_file_name_dialog.setText("");
                edt_git_branch_dialog.setText("");
                edt_Contents_dialog.setText("");
                edt_User_dialog.setText("");
                btn_before_version_dialog.setText("이전버전");
                btn_after_version_dialog.setText("변경버전");
                btn_calendar_select_dialog.setText("날짜선택");
                item_listview_dialog2.dismiss(); // 다이얼로그 닫기
            }
        });
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
                Toast.makeText(getContext(), "수정완료", Toast.LENGTH_SHORT).show();
                String label1 = spinner_edt_del.getText().toString();
                if (label1.trim().length() > 0) {
                    switch (i) {
                        case 0:
                            DbHandler db = new DbHandler(getContext());
                            db.updateLabel(temp1, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 1:
                            DbHandler1 db1 = new DbHandler1(getContext());
                            db1.updateLabel(temp2, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 2:
                            DbHandler2 db2 = new DbHandler2(getContext());
                            db2.updateLabel(temp3, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 3:
                            DbHandler3 db3 = new DbHandler3(getContext());
                            db3.updateLabel(temp4, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 4:
                            DbHandler4 db4 = new DbHandler4(getContext());
                            db4.updateLabel(temp5, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 5:
                            DbHandler5 db5 = new DbHandler5(getContext());
                            db5.updateLabel(temp6, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 6:
                            DbHandler6 db6 = new DbHandler6(getContext());
                            db6.updateLabel(temp7, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 7:
                            DbHandler7 db7 = new DbHandler7(getContext());
                            db7.updateLabel(temp8, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 8:
                            DbHandler8 db8 = new DbHandler8(getContext());
                            db8.updateLabel(temp9, label1);
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
                        DbHandler db = new DbHandler(getContext());
                        db.deleteLabel(temp1);
                        break;
                    case 1:
                        DbHandler1 db1 = new DbHandler1(getContext());
                        db1.deleteLabel(temp2);
                        break;
                    case 2:
                        DbHandler2 db2 = new DbHandler2(getContext());
                        db2.deleteLabel(temp3);
                        break;
                    case 3:
                        DbHandler3 db3 = new DbHandler3(getContext());
                        db3.deleteLabel(temp4);
                        break;
                    case 4:
                        DbHandler4 db4 = new DbHandler4(getContext());
                        db4.deleteLabel(temp5);
                        break;
                    case 5:
                        DbHandler5 db5 = new DbHandler5(getContext());
                        db5.deleteLabel(temp6);
                        break;
                    case 6:
                        DbHandler6 db6 = new DbHandler6(getContext());
                        db6.deleteLabel(temp7);
                        break;
                    case 7:
                        DbHandler7 db7 = new DbHandler7(getContext());
                        db7.deleteLabel(temp8);
                        break;
                    case 8:
                        DbHandler8 db8 = new DbHandler8(getContext());
                        db8.deleteLabel(temp9);
                        break;
                }
                Toast.makeText(getContext(), "삭제되었습니다.", Toast.LENGTH_LONG).show();
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
                btn_after_version.setText(after_all_v);
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
                String before_all_v = v1 + "." + v2 + "." + v3;
                btn_before_version.setText(before_all_v);
                edt_before_version_dialog1.setText("");
                edt_before_version_dialog2.setText("");
                edt_before_version_dialog3.setText("");
                before_version_dialog.dismiss();
            }
        });
    }


    public void spinner_list_dialog() {
        spinner_dialog.show();
        spinner_edt_dialog = spinner_dialog.findViewById(R.id.spinner_edt_dialog);
        Button noBtn = spinner_dialog.findViewById(R.id.no_btn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner_dialog.dismiss(); // 다이얼로그 닫기
            }
        });
        spinner_dialog.findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "확인", Toast.LENGTH_SHORT).show();
                spinner_dialog.dismiss();
                String label = spinner_edt_dialog.getText().toString();
                if (label.trim().length() > 0) {
                    switch (i) {
                        case 0:
                            DbHandler db = new DbHandler(getContext());
                            db.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 1:
                            DbHandler1 db1 = new DbHandler1(getContext());
                            db1.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 2:
                            DbHandler2 db2 = new DbHandler2(getContext());
                            db2.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 3:
                            DbHandler3 db3 = new DbHandler3(getContext());
                            db3.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 4:
                            DbHandler4 db4 = new DbHandler4(getContext());
                            db4.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 5:
                            DbHandler5 db5 = new DbHandler5(getContext());
                            db5.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 6:
                            DbHandler6 db6 = new DbHandler6(getContext());
                            db6.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 7:
                            DbHandler7 db7 = new DbHandler7(getContext());
                            db7.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 8:
                            DbHandler8 db8 = new DbHandler8(getContext());
                            db8.insertLabel(label);
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
                DbHandler db = new DbHandler(getActivity());
                List<String> labels = db.getAllLabels();
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp1_spinner.setAdapter(dataAdapter);
                break;
            case 1:
                DbHandler1 db1 = new DbHandler1(getActivity());
                List<String> labels1 = db1.getAllLabels();
                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
                dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner.setAdapter(dataAdapter1);
                break;
            case 2:
                DbHandler2 db2 = new DbHandler2(getActivity());
                List<String> labels2 = db2.getAllLabels();
                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp3_spinner.setAdapter(dataAdapter2);
                break;
            case 3:
                DbHandler3 db3 = new DbHandler3(getActivity());
                List<String> labels3 = db3.getAllLabels();
                ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
                dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp4_spinner.setAdapter(dataAdapter3);
                break;
            case 4:
                DbHandler4 db4 = new DbHandler4(getActivity());
                List<String> labels4 = db4.getAllLabels();
                ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
                dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp5_spinner.setAdapter(dataAdapter4);
                break;
            case 5:
                DbHandler5 db5 = new DbHandler5(getActivity());
                List<String> labels5 = db5.getAllLabels();
                ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
                dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp6_spinner.setAdapter(dataAdapter5);
                break;
            case 6:
                DbHandler6 db6 = new DbHandler6(getActivity());
                List<String> labels6 = db6.getAllLabels();
                ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
                dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp7_spinner.setAdapter(dataAdapter6);
                break;
            case 7:
                DbHandler7 db7 = new DbHandler7(getActivity());
                List<String> labels7 = db7.getAllLabels();
                ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
                dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp8_spinner.setAdapter(dataAdapter7);
                break;
            case 8:
                DbHandler8 db8 = new DbHandler8(getActivity());
                List<String> labels8 = db8.getAllLabels();
                ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels8);
                dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp9_spinner.setAdapter(dataAdapter8);
                break;
        }

    }

    private void loadSpinnerData1() {
        DbHandler db = new DbHandler(getActivity());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1_spinner.setAdapter(dataAdapter);
        DbHandler1 db1 = new DbHandler1(getActivity());
        List<String> labels1 = db1.getAllLabels();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner.setAdapter(dataAdapter1);
        DbHandler2 db2 = new DbHandler2(getActivity());
        List<String> labels2 = db2.getAllLabels();
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp3_spinner.setAdapter(dataAdapter2);
        DbHandler3 db3 = new DbHandler3(getActivity());
        List<String> labels3 = db3.getAllLabels();
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp4_spinner.setAdapter(dataAdapter3);
        DbHandler4 db4 = new DbHandler4(getActivity());
        List<String> labels4 = db4.getAllLabels();
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp5_spinner.setAdapter(dataAdapter4);
        DbHandler5 db5 = new DbHandler5(getActivity());
        List<String> labels5 = db5.getAllLabels();
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp6_spinner.setAdapter(dataAdapter5);
        DbHandler6 db6 = new DbHandler6(getActivity());
        List<String> labels6 = db6.getAllLabels();
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels6);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp7_spinner.setAdapter(dataAdapter6);
        DbHandler7 db7 = new DbHandler7(getActivity());
        List<String> labels7 = db7.getAllLabels();
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels7);
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp8_spinner.setAdapter(dataAdapter7);
        DbHandler8 db8 = new DbHandler8(getActivity());
        List<String> labels8 = db8.getAllLabels();
        ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels8);
        dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp9_spinner.setAdapter(dataAdapter8);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void spinner_reset() {
        temp1_spinner.setSelection(0);
        temp2_spinner.setSelection(0);
        temp3_spinner.setSelection(0);
        temp4_spinner.setSelection(0);
        temp5_spinner.setSelection(0);
        temp6_spinner.setSelection(0);
        temp7_spinner.setSelection(0);
        temp8_spinner.setSelection(0);
        temp9_spinner.setSelection(0);
        btn_before_version.setText("이전버전");
        btn_after_version.setText("변경버전");
        btn_calendar_select.setText("날짜선택");
        edt_file_name.setText("");
        edt_git_branch.setText("");
        edt_User.setText("");
        edt_Contents.setText("");
        temp12 = "";
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
                insert_Spinner(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, F_ID, temp17, temp18, temp19, temp20, temp21, temp22, temp23, temp24, temp25);
                Toast.makeText(getContext(), "등록되었습니다.", Toast.LENGTH_SHORT).show();
                insert_dialog.dismiss();
                spinner_reset();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);


        temp1_spinner = (Spinner) view.findViewById(R.id.temp1_spinner);
        temp2_spinner = (Spinner) view.findViewById(R.id.temp2_spinner);
        temp3_spinner = (Spinner) view.findViewById(R.id.temp3_spinner);
        temp4_spinner = (Spinner) view.findViewById(R.id.temp4_spinner);
        temp5_spinner = (Spinner) view.findViewById(R.id.temp5_spinner);
        temp6_spinner = (Spinner) view.findViewById(R.id.temp6_spinner);
        temp7_spinner = (Spinner) view.findViewById(R.id.temp7_spinner);
        temp8_spinner = (Spinner) view.findViewById(R.id.temp8_spinner);
        temp9_spinner = (Spinner) view.findViewById(R.id.temp9_spinner);

        btn_select_search = (Button) view.findViewById(R.id.btn_select_search);
        btn_calendar_select = (Button) view.findViewById(R.id.btn_calendar_select);
        btn_compatibility = (Button) view.findViewById(R.id.btn_compatibility);


        tv_insert = (TextView) view.findViewById(R.id.tv_insert);
        edt_Contents = (TextView) view.findViewById(R.id.edt_Contents);


        edt_User = (TextView) view.findViewById(R.id.edt_User);

        btn_insert_listView = (Button) view.findViewById(R.id.btn_insert_listView);


        lvList = (ListView) view.findViewById(R.id.lv_list);



        item_listview_dialog = new Dialog(getContext());       // Dialog 초기화
        item_listview_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        item_listview_dialog.setContentView(R.layout.item_listview_dialog);

        item_listview_dialog2 = new Dialog(getContext());       // Dialog 초기화
        item_listview_dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        item_listview_dialog2.setContentView(R.layout.dialog02);

        spinner_dialog = new Dialog(getContext());       // Dialog 초기화
        spinner_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        spinner_dialog.setContentView(R.layout.spinner_dialog);

        spinner_edt_del_dialog = new Dialog(getContext());       // Dialog 초기화
        spinner_edt_del_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        spinner_edt_del_dialog.setContentView(R.layout.spinner_edt_del_dialog);

        insert_dialog = new Dialog(getContext());       // Dialog 초기화
        insert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        insert_dialog.setContentView(R.layout.insert_dialog);


        before_version_dialog = new Dialog(getContext());       // Dialog 초기화
        before_version_dialog.setTitle("이전 버전");
        before_version_dialog.setContentView(R.layout.before_version_dialog);

        after_version_dialog = new Dialog(getContext());       // Dialog 초기화
        after_version_dialog.setTitle("변경 버전");
        after_version_dialog.setContentView(R.layout.after_version_dialog);

        compatibility_dialog = new Dialog(getContext());       // Dialog 초기화
        compatibility_dialog.setTitle("변경 버전");
        compatibility_dialog.setContentView(R.layout.compatibility_dialog);

        btn_menu = (Button) view.findViewById(R.id.btn_menu);
        layout_menu = (LinearLayout) view.findViewById(R.id.layout_menu);
        btn_before_version = (Button) view.findViewById(R.id.btn_before_version);
        btn_after_version = (Button) view.findViewById(R.id.btn_after_version);

        edt_file_name = view.findViewById(R.id.edt_file_name);
        edt_git_branch = view.findViewById(R.id.edt_git_branch);


        displayList();

        btn_after_version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_version_dialog();
            }
        });

        btn_before_version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_version_dialog();
            }
        });

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutchange == true) { //true일 때 실행
                    btn_menu.setText("━");
                    layout_menu.setVisibility(View.VISIBLE);
                    layoutchange = false; // 실행 후 false로 변경
                } else { // 다를 때
                    btn_menu.setText("╋");
                    layout_menu.setVisibility(View.GONE);
                    layoutchange = true; // 실행 후 true로 변경
                }
            }
        });


        btn_insert_listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp10 = btn_before_version.getText().toString();
                if (temp10.equals("이전버전")) {
                    temp10 = "";
                }
                temp11 = btn_after_version.getText().toString();
                if (temp11.equals("변경버전")) {
                    temp11 = "";
                }
                F_ID = edt_User.getText().toString();
                if (temp12 == null) {
                    temp12 = "";
                }
                temp13 = edt_file_name.getText().toString();
                temp14 = edt_git_branch.getText().toString();
                temp15 = edt_Contents.getText().toString();
                temp17 = "";
                temp18 = "";
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


        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String position1 = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "NO. "+position1, Toast.LENGTH_SHORT).show();
            }

        });

        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                DBHelper_all helper = new DBHelper_all(getContext());
                SQLiteDatabase database = helper.getReadableDatabase();
                item_listview_dialog.dismiss();
                String position1 = adapterView.getItemAtPosition(position).toString();
//                adapterView.getSelectedItemPosition();
//                adapterView.getSelectedItem().toString();
                Toast.makeText(getContext(), position1, Toast.LENGTH_SHORT).show();
                showDialog01(position1);
                return true;
            }
        });

        temp1_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp1 = parent.getItemAtPosition(position).toString();
                if (temp1.equals("전체")) {
                    temp1 = "";
                } else if (temp1.equals("항목추가")) {
                    i = 0;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp1_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 0;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp2 = parent.getItemAtPosition(position).toString();
                if (temp2.equals("전체")) {
                    temp2 = "";
                } else if (temp2.equals("항목추가")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp2_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp3_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("전체")) {
                    temp3 = "";
                } else if (temp3.equals("항목추가")) {
                    i = 2;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp3_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 2;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp4_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp4 = parent.getItemAtPosition(position).toString();
                if (temp4.equals("전체")) {
                    temp4 = "";
                } else if (temp4.equals("항목추가")) {
                    i = 3;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp4_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 3;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp5_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp5 = parent.getItemAtPosition(position).toString();
                if (temp5.equals("전체")) {
                    temp5 = "";
                } else if (temp5.equals("항목추가")) {
                    i = 4;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp5_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 4;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp6_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp6 = parent.getItemAtPosition(position).toString();
                if (temp6.equals("전체")) {
                    temp6 = "";
                } else if (temp6.equals("항목추가")) {
                    i = 5;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp6_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 5;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp7_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp7 = parent.getItemAtPosition(position).toString();
                if (temp7.equals("전체")) {
                    temp7 = "";
                } else if (temp7.equals("항목추가")) {
                    i = 6;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp7_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 6;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp8_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp8 = parent.getItemAtPosition(position).toString();
                if (temp8.equals("전체")) {
                    temp8 = "";
                } else if (temp8.equals("항목추가")) {
                    i = 7;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp8_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 7;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp9_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp9 = parent.getItemAtPosition(position).toString();
                if (temp9.equals("전체")) {
                    temp9 = "";
                } else if (temp9.equals("항목추가")) {
                    i = 8;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp9_spinner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 8;
                spinner_edt_del_dialog();
                return true;
            }
        });
        loadSpinnerData1(); //드롭다운 스피너 데이터 로드


        btn_select_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp10 = btn_before_version.getText().toString();
                if (temp10.equals("이전버전")) {
                    temp10 = "";
                }
                temp11 = btn_after_version.getText().toString();
                if (temp11.equals("변경버전")) {
                    temp11 = "";
                }
                if (temp12 == null) {
                    temp12 = "";
                }
                temp13 = edt_file_name.getText().toString();
                temp14 = edt_git_branch.getText().toString();
                temp15 = edt_Contents.getText().toString();
                F_ID = edt_User.getText().toString();
                temp_trim();
                select_Spinner(temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, F_ID);
                spinner_reset();
            }
        });

        btn_calendar_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog dlg = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            btn_calendar_select.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            temp12 = btn_calendar_select.getText().toString();
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

        btn_compatibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compatibility_dialog.show();
            }
        });
        return view;
    }

    private void temp_trim(){
        temp1 = temp1.trim();
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
        F_ID = F_ID.trim();
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
        temp15_dialog = temp15_dialog.trim();
        F_ID_dialog = F_ID_dialog.trim();
    }
}