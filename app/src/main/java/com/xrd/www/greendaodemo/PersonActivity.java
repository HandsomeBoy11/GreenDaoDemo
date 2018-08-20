package com.xrd.www.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.xrd.www.greendaodemo.adapter.PersonAdapter;
import com.xrd.www.greendaodemo.bean.Person;
import com.xrd.www.greendaodemo.daoUtils.SQLiteUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_age)
    EditText etXueli;
    @BindView(R.id.et_sex)
    EditText EtSchool;
    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.bt_query)
    Button btQuery;
    @BindView(R.id.lv_person)
    ListView lvPerson;
    private String name;
    private String xueli;
    private String school;
    private List<Person> personList=new ArrayList<>();
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        personAdapter = new PersonAdapter(this, personList);
        lvPerson.setAdapter(personAdapter);
    }

    @OnClick({R.id.bt_add, R.id.bt_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                name = etName.getText().toString().trim();
                xueli = etXueli.getText().toString().trim();
                school = EtSchool.getText().toString().trim();
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(xueli)||TextUtils.isEmpty(school)){
                    Toast.makeText(this, "请讲信息填写完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                SQLiteUtils.getInstance().insertData(new Person(null,name,xueli,school));
                notifyAdapter();
                break;
            case R.id.bt_query:
                notifyAdapter();
                break;
        }
    }

    private void notifyAdapter() {
        personList.clear();
        List<Person> allPerson = SQLiteUtils.getInstance().findAllPerson();
        personList.addAll(allPerson);
        personAdapter.notifyDataSetChanged();
    }
}
