package com.example.programversion02;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner temp1_spinner_update, temp2_spinner_update;
    private String temp1, temp2, temp3, temp4, temp5;
    private int i;
    private Dialog spinner_dialog, before_version_dialog, after_version_dialog, spinner_edt_del_dialog, insert_dialog, item_listview_dialog, item_listview_dialog2,item_listview_update_select_dialog;
    private EditText spinner_edt_dialog, edt_before_version_dialog1, edt_before_version_dialog2, edt_before_version_dialog3, edt_before_version_dialog4, edt_after_version_dialog1, edt_after_version_dialog2, edt_after_version_dialog3, edt_after_version_dialog4, edt_file_name, edt_git_branch,
            spinner_edt_del;
    private Button btn_select_search_update, btn_before_version_update, btn_after_version_update, btn_calendar_select_update;
    private ListView lv_list_update, lv_list_board_content, lv_list_sw_content, lv_list_firmware_content;



    private String[] arr;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Fragment4() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
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

    private void loadSpinnerData1() {
        DbHandler_update db = new DbHandler_update(getActivity());
        List<String> labels = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1_spinner_update.setAdapter(dataAdapter);
        DbHandler_update1 db1 = new DbHandler_update1(getActivity());
        List<String> labels1 = db1.getAllLabels();
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp2_spinner_update.setAdapter(dataAdapter1);
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
                            DbHandler_update db = new DbHandler_update(getContext());
                            db.insertLabel(label);
                            spinner_edt_dialog.setText("");
                            loadSpinnerData();
                            break;
                        case 1:
                            DbHandler_update1 db1 = new DbHandler_update1(getContext());
                            db1.insertLabel(label);
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
                DbHandler_update db = new DbHandler_update(getActivity());
                List<String> labels = db.getAllLabels();
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp1_spinner_update.setAdapter(dataAdapter);
                break;
            case 1:
                DbHandler_update1 db1 = new DbHandler_update1(getActivity());
                List<String> labels1 = db1.getAllLabels();
                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labels1);
                dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                temp2_spinner_update.setAdapter(dataAdapter1);
                break;
        }
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
                            DbHandler_board db = new DbHandler_board(getContext());
                            db.updateLabel(temp2, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                        case 1:
                            DbHandler_board1 db1 = new DbHandler_board1(getContext());
                            db1.updateLabel(temp3, label1);
                            spinner_edt_del.setText("");
                            loadSpinnerData();
                            spinner_edt_del_dialog.dismiss();
                            break;
                    }
                }
            }
        });
    }

    void select_Spinner(String date, String model, String camera, String before_version, String after_version) {
        //Dbhelper의 쓰기모드 객체를 가져옴
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT  ifnull(sw_database.date,'null'), ifnull(sw_database.date,'null')  , ifnull(sw_database.model,'null')," +
                " ifnull(sw_database.camera,'null'), ifnull(sw_database.after_version,'null'), ifnull(form_database.board_code,'null')," +
                " ifnull(form_database.after_version,'null'), ifnull(board_database.board_type,'null'), ifnull(board_database.board_code,'null'), ifnull(sw_database.bundle,'null')" +
                " FROM sw_database, form_database, board_database WHERE" +
                " ((sw_database.date LIKE '%" + date + "%' OR" +
                " form_database.date LIKE '%" + date + "%' OR" +
                " board_database.date LIKE '%" + date + "%') AND" +
                " (sw_database.bundle != ''OR form_database.bundle != ''OR board_database.bundle != '') AND" +
                " sw_database.date = form_database.date AND" +
                " sw_database.bundle = form_database.bundle AND" +
                " (sw_database.bundle != '해당없음' OR form_database.bundle != '해당없음' OR board_database.bundle != '해당없음') AND" +
                " form_database.board_code = board_database.board_code)" +
                " UNION" +
                " SELECT ifnull(sw_database.date,'null'), ifnull(sw_database.date,'null')  , ifnull(sw_database.model,'null')," +
                " ifnull(sw_database.camera,'null'), ifnull(sw_database.after_version,'null'), ifnull(sw_database.name25,'null')," +
                " ifnull(sw_database.name25,'null'), ifnull(sw_database.name25,'null'), ifnull(sw_database.name25,'null'), ifnull(sw_database.bundle,'null')" +
                " FROM sw_database WHERE" +
                " (sw_database.date LIKE '%" + date + "%' AND sw_database.bundle = '해당없음')" +
                " UNION" +
                " SELECT ifnull(form_database.date,'null'), ifnull(form_database.date,'null')  , ifnull(form_database.model,'null')," +
                " ifnull(form_database.camera,'null'), ifnull(form_database.name25,'null'), ifnull(form_database.board_code,'null')," +
                " ifnull(form_database.after_version,'null'), ifnull(form_database.name25,'null'), ifnull(form_database.name25,'null'), ifnull(form_database.bundle,'null')" +
                " FROM form_database WHERE" +
                " (form_database.date LIKE '%" + date + "%' AND form_database.bundle = '해당없음')" +
                " UNION" +
                " SELECT ifnull(board_database.date,'null'), ifnull(board_database.date,'null')  , ifnull(board_database.model,'null')," +
                " ifnull(board_database.name25,'null'), ifnull(board_database.name25,'null'), ifnull(board_database.name25,'null')," +
                " ifnull(board_database.name25,'null'), ifnull(board_database.board_type,'null'), ifnull(board_database.board_code,'null'), ifnull(board_database.bundle,'null')" +
                " FROM board_database WHERE" +
                " (board_database.date LIKE '%" + date + "%' AND board_database.bundle = '해당없음');";

        cursor = database.rawQuery(qry, null); //만들어준 쿼리문 실행

        ListViewAdapter_update adapter = new ListViewAdapter_update();

        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
        }
        cursor.close();
        database.close();

        lv_list_update.setAdapter(adapter);
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
                btn_after_version_update.setText(after_all_v);
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
                btn_before_version_update.setText(before_all_v);
                edt_before_version_dialog1.setText("");
                edt_before_version_dialog2.setText("");
                edt_before_version_dialog3.setText("");
                before_version_dialog.dismiss();
            }
        });

    }

    public void spinner_reset() {
        temp1_spinner_update.setSelection(0);
        temp2_spinner_update.setSelection(0);
        btn_before_version_update.setText("이전버전");
        btn_after_version_update.setText("변경버전");
        btn_calendar_select_update.setText("날짜선택");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_4, container, false);

        temp1_spinner_update = (Spinner) view.findViewById(R.id.temp1_spinner_update);
        temp2_spinner_update = (Spinner) view.findViewById(R.id.temp2_spinner_update);
        btn_select_search_update = (Button) view.findViewById(R.id.btn_select_search_update);
        lv_list_update = (ListView) view.findViewById(R.id.lv_list_update);
        btn_calendar_select_update = (Button) view.findViewById(R.id.btn_calendar_select_update);
        btn_before_version_update = (Button) view.findViewById(R.id.btn_before_version_update);
        btn_after_version_update = (Button) view.findViewById(R.id.btn_after_version_update);

        before_version_dialog = new Dialog(getContext());       // Dialog 초기화
        before_version_dialog.setTitle("이전 버전");
        before_version_dialog.setContentView(R.layout.before_version_dialog);

        after_version_dialog = new Dialog(getContext());       // Dialog 초기화
        after_version_dialog.setTitle("변경 버전");
        after_version_dialog.setContentView(R.layout.after_version_dialog);

        item_listview_update_select_dialog = new Dialog(getContext());       // Dialog 초기화
        item_listview_update_select_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        item_listview_update_select_dialog.setContentView(R.layout.item_listview_update_select_dialog);

        temp1_spinner_update.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp2 = parent.getItemAtPosition(position).toString();
                if (temp2.equals("전체")) {
                    temp2 = "";
                } else if (temp2.equals("항목추가")) {
                    i = 0;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp1_spinner_update.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 0;
                spinner_edt_del_dialog();
                return true;
            }
        });

        temp2_spinner_update.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp3 = parent.getItemAtPosition(position).toString();
                if (temp3.equals("전체")) {
                    temp3 = "";
                } else if (temp3.equals("항목추가")) {
                    i = 1;
                    spinner_list_dialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        temp2_spinner_update.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                i = 1;
                spinner_edt_del_dialog();
                return true;
            }
        });

        loadSpinnerData1(); //스피너 db 불러오는거

        btn_select_search_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp1 = btn_calendar_select_update.getText().toString();
                if (temp1.equals("날짜선택")) {
                    temp1 = "";
                }
                temp4 = btn_before_version_update.getText().toString();
                if (temp4.equals("이전버전")) {
                    temp4 = "";
                }
                temp5 = btn_after_version_update.getText().toString();
                if (temp5.equals("변경버전")) {
                    temp5 = "";
                }
                temp2 = "";
                temp3 = "";

                select_Spinner(temp1, temp2, temp3, temp4, temp5);
                spinner_reset();
            }
        });

        btn_calendar_select_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog dlg = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            btn_calendar_select_update.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            temp1 = btn_calendar_select_update.getText().toString();
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

        btn_after_version_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_version_dialog();
            }
        });

        btn_before_version_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_version_dialog();
            }
        });

        lv_list_update.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                arr = (String[]) adapterView.getAdapter().getItem(position);
//                Toast.makeText(getContext(), Arrays.toString(arr),Toast.LENGTH_SHORT).show();
                item_listview_update_select_dialog(arr);
            }
        });
        return view;

    }
    private void item_listview_update_select_dialog(String[] arr){
        item_listview_update_select_dialog.show();

        Button item_listview_update_soft_content = (Button) item_listview_update_select_dialog.findViewById(R.id.item_listview_update_soft_content);
        Button item_listview_update_firm_content = (Button) item_listview_update_select_dialog.findViewById(R.id.item_listview_update_firm_content);
        Button item_listview_update_board_content = (Button) item_listview_update_select_dialog.findViewById(R.id.item_listview_update_board_content);
        Button item_listview_update_select_cancel = (Button) item_listview_update_select_dialog.findViewById(R.id.item_listview_update_select_cancel);
        HorizontalScrollView sw_content = (HorizontalScrollView) item_listview_update_select_dialog.findViewById(R.id.sw_content);
        HorizontalScrollView fw_content = (HorizontalScrollView) item_listview_update_select_dialog.findViewById(R.id.fw_content);
        HorizontalScrollView board_content = (HorizontalScrollView) item_listview_update_select_dialog.findViewById(R.id.board_content);
        ListView lv_list_board_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_board_content);
        ListView lv_list_firmware_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_firmware_content);
        ListView lv_list_sw_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_sw_content);


        item_listview_update_soft_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw_content.setVisibility(View.VISIBLE);
                fw_content.setVisibility(View.GONE);
                board_content.setVisibility(View.GONE);
                select_content_sw(arr);

            }
        });

        item_listview_update_firm_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw_content.setVisibility(View.GONE);
                fw_content.setVisibility(View.VISIBLE);
                board_content.setVisibility(View.GONE);
                select_content_fw(arr);
            }
        });

        item_listview_update_board_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw_content.setVisibility(View.GONE);
                fw_content.setVisibility(View.GONE);
                board_content.setVisibility(View.VISIBLE);
                select_content_board(arr);

            }
        });

        item_listview_update_select_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item_listview_update_select_dialog.dismiss();
                sw_content.setVisibility(View.GONE);
                fw_content.setVisibility(View.GONE);
                board_content.setVisibility(View.GONE);
            }
        });
    }

    void select_content_sw(String[] arr) {
        //Dbhelper의 쓰기모드 객체를 가져옴

        ListView lv_list_sw_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_sw_content);
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT * FROM sw_database WHERE" +
                " date LIKE '%" + arr[0] + "%' AND" +
                " model LIKE '%" + arr[1] + "%' AND" +
                " camera LIKE '%" + arr[2] + "%' AND" +
                " after_version LIKE '%" + arr[3] + "%' AND" +
                " bundle LIKE '%" + arr[8] + "%';";

        cursor = database.rawQuery(qry, null); //만들어준 쿼리문 실행

        ListViewAdapter adapter = new ListViewAdapter();

        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16));
        }
        cursor.close();
        database.close();

        lv_list_sw_content.setAdapter(adapter);
    }

    void select_content_fw(String[] arr) {
        //Dbhelper의 쓰기모드 객체를 가져옴

        ListView lv_list_firmware_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_firmware_content);
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT * FROM form_database WHERE" +
                " date LIKE '%" + arr[0] + "%' AND" +
                " after_version LIKE '%" + arr[3] + "%' AND" +
                " board_code LIKE '%" + arr[7] + "%' AND" +
                " bundle LIKE '%" + arr[8] + "%';";

        cursor = database.rawQuery(qry, null); //만들어준 쿼리문 실행

        ListViewAdapter_form adapter = new ListViewAdapter_form();

        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),
                    cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17),cursor.getString(18),
                    cursor.getString(19),cursor.getString(20),cursor.getString(21));
        }
        cursor.close();
        database.close();

        lv_list_firmware_content.setAdapter(adapter);
    }

    void select_content_board(String[] arr) {
        //Dbhelper의 쓰기모드 객체를 가져옴

        ListView lv_list_board_content = (ListView) item_listview_update_select_dialog.findViewById(R.id.lv_list_board_content);
        DBHelper_all helper = new DBHelper_all(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        String qry = "SELECT * FROM board_database WHERE" +
                " date LIKE '%" + arr[0] + "%' AND" +
                " board_type LIKE '%" + arr[6] + "%' AND" +
                " board_code LIKE '%" + arr[7] + "%' AND" +
                " bundle LIKE '%" + arr[8] + "%';";

        cursor = database.rawQuery(qry, null); //만들어준 쿼리문 실행

        ListViewAdapter_board adapter = new ListViewAdapter_board();

        while (cursor.moveToNext()) {
            //num 행은 가장 첫번째에 있으니 0번이 되고, name은 1번
            adapter.addItemToList(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),
                    cursor.getString(14),cursor.getString(15),cursor.getString(16),cursor.getString(17),cursor.getString(18));
        }
        cursor.close();
        database.close();

        lv_list_board_content.setAdapter(adapter);
    }
}