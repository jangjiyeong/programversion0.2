package com.example.programversion02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter_form extends BaseAdapter {

    ArrayList<ListViewAdapterData_form> list = new ArrayList<ListViewAdapterData_form>();

    @Override
    public int getCount() {
        return list.size(); //그냥 배열의 크기를 반환하면 됨
    }

    @Override
    public Object getItem(int i) {
        return list.get(i).getGtemp1(); //배열에 아이템을 현재 위치값을 넣어 가져옴
    }

    @Override
    public long getItemId(int i) {
        return i; //그냥 위치값을 반환해도 되지만 원한다면 아이템의 num 을 반환해도 된다.
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Context context = viewGroup.getContext();

        //리스트뷰에 아이템이 인플레이트 되어있는지 확인한후
        //아이템이 없다면 아래처럼 아이템 레이아웃을 인플레이트 하고 view객체에 담는다.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_listview_form, viewGroup, false);
        }

        //이제 아이템에 존재하는 텍스트뷰 객체들을 view객체에서 찾아 가져온다
        TextView tvtemp1 = (TextView) view.findViewById(R.id.list_edtName_temp1);
        TextView tvtemp2 = (TextView) view.findViewById(R.id.list_edtName_temp2);
        TextView tvtemp3 = (TextView) view.findViewById(R.id.list_edtName_temp3);
        TextView tvtemp4 = (TextView) view.findViewById(R.id.list_edtName_temp4);
        TextView tvtemp5 = (TextView) view.findViewById(R.id.list_edtName_temp5);
        TextView tvtemp6 = (TextView) view.findViewById(R.id.list_edtName_temp6);
        TextView tvtemp7 = (TextView) view.findViewById(R.id.list_edtName_temp7);
        TextView tvtemp8 = (TextView) view.findViewById(R.id.list_edtName_temp8);
        TextView tvtemp9 = (TextView) view.findViewById(R.id.list_edtName_temp9);
        TextView tvtemp10 = (TextView) view.findViewById(R.id.list_edtName_temp10);
        TextView tvtemp11 = (TextView) view.findViewById(R.id.list_edtName_temp11);
        TextView tvtemp12 = (TextView) view.findViewById(R.id.list_edtName_temp12);
        TextView tvtemp13 = (TextView) view.findViewById(R.id.list_edtName_temp13);
        TextView tvtemp14 = (TextView) view.findViewById(R.id.list_edtName_temp14);
        TextView tvtemp15 = (TextView) view.findViewById(R.id.list_edtName_temp15);
        TextView tvtemp16 = (TextView) view.findViewById(R.id.list_edtName_temp16);
        TextView tvtemp17 = (TextView) view.findViewById(R.id.list_edtName_temp17);
        TextView tvtemp18 = (TextView) view.findViewById(R.id.list_edtName_temp18);
        TextView tvtemp19 = (TextView) view.findViewById(R.id.list_edtName_temp19);
        TextView tvtemp20 = (TextView) view.findViewById(R.id.list_edtName_temp20);
        TextView tvtemp21 = (TextView) view.findViewById(R.id.list_edtName_temp21);
        TextView tvtemp22 = (TextView) view.findViewById(R.id.list_edtName_temp22);
//        TextView tvtemp23 = (TextView) view.findViewById(R.id.list_edtName_temp23);

        //현재 포지션에 해당하는 아이템에 글자를 적용하기 위해 list배열에서 객체를 가져온다.
        ListViewAdapterData_form listdata = list.get(i);

        //가져온 객체안에 있는 글자들을 각 뷰에 적용한다
        tvtemp1.setText(Integer.toString(listdata.getGtemp1())); //원래 int형이라 String으로 형 변환
        tvtemp2.setText(listdata.getGtemp2());
        tvtemp3.setText(listdata.getGtemp3());
        tvtemp4.setText(listdata.getGtemp4());
        tvtemp5.setText(listdata.getGtemp5());
        tvtemp6.setText(listdata.getGtemp6());
        tvtemp7.setText(listdata.getGtemp7());
        tvtemp8.setText(listdata.getGtemp8());
        tvtemp9.setText(listdata.getGtemp9());
        tvtemp10.setText(listdata.getGtemp10());
        tvtemp11.setText(listdata.getGtemp11());
        tvtemp12.setText(listdata.getGtemp12());
        tvtemp13.setText(listdata.getGtemp13());
        tvtemp14.setText(listdata.getGtemp14());
        tvtemp15.setText(listdata.getGtemp15());
        tvtemp16.setText(listdata.getGtemp16());
        tvtemp17.setText(listdata.getGtemp17());
        tvtemp18.setText(listdata.getGtemp18());
        tvtemp19.setText(listdata.getGtemp19());
        tvtemp20.setText(listdata.getGtemp20());
        tvtemp21.setText(listdata.getGtemp21());
        tvtemp22.setText(listdata.getGtemp22());
//        tvtemp23.setText(listdata.getGtemp23());

        return view;
    }

    //ArrayList로 선언된 list 변수에 목록을 채워주기 위함 다른방식으로 구현해도 됨
    public void addItemToList(int gtemp1, String gtemp2, String gtemp3, String gtemp4,
                              String gtemp5, String gtemp6, String gtemp7, String gtemp8,String gtemp9,
                               String gtemp10, String gtemp11, String gtemp12, String gtemp13,
                              String gtemp14, String gtemp15, String gtemp16, String gtemp17, String gtemp18, String gtemp19, String gtemp20, String gtemp21, String gtemp22) {
        ListViewAdapterData_form listdata = new ListViewAdapterData_form();

        listdata.setGtemp1(gtemp1);
        listdata.setGtemp2(gtemp2);
        listdata.setGtemp3(gtemp3);
        listdata.setGtemp4(gtemp4);
        listdata.setGtemp5(gtemp5);
        listdata.setGtemp6(gtemp6);
        listdata.setGtemp7(gtemp7);
        listdata.setGtemp8(gtemp8);
        listdata.setGtemp9(gtemp9);
        listdata.setGtemp10(gtemp10);
        listdata.setGtemp11(gtemp11);
        listdata.setGtemp12(gtemp12);
        listdata.setGtemp13(gtemp13);
        listdata.setGtemp14(gtemp14);
        listdata.setGtemp15(gtemp15);
        listdata.setGtemp16(gtemp16);
        listdata.setGtemp17(gtemp17);
        listdata.setGtemp18(gtemp18);
        listdata.setGtemp19(gtemp19);
        listdata.setGtemp20(gtemp20);
        listdata.setGtemp21(gtemp21);
        listdata.setGtemp22(gtemp22);

        //값들의 조립이 완성된 listdata객체 한개를 list배열에 추가
        list.add(listdata);

    }


}



