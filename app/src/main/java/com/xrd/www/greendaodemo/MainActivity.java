package com.xrd.www.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xrd.www.greendaodemo.adapter.UserAdapter;
import com.xrd.www.greendaodemo.bean.User;
import com.xrd.www.greendaodemo.daoUtils.SQLiteUtils;
import com.xrd.www.greendaodemo.utils.CommentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_way)
    TextView tvWay;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.bt_delete)
    Button btDelete;
    @BindView(R.id.bt_updata)
    Button btUpdata;
    @BindView(R.id.bt_find_all)
    Button btFindAll;
    @BindView(R.id.bt_name)
    Button btName;
    @BindView(R.id.bt_age)
    Button btAge;
    @BindView(R.id.bt_delete_all)
    Button btDeleteAll;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.et_sex)
    EditText etSex;
    private String name;
    private String age;
    private String phone;
    private List<User> userList = new ArrayList<>();
    private UserAdapter userAdapter;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        userAdapter = new UserAdapter(this, userList);
        lv.setAdapter(userAdapter);
    }

    @OnClick({R.id.bt_add, R.id.bt_delete, R.id.bt_updata, R.id.bt_find_all, R.id.bt_name, R.id.bt_age, R.id.bt_delete_all,R.id.bt_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                name = etName.getText().toString().trim();
                age = etAge.getText().toString().trim();
                phone = etPhone.getText().toString().trim();
                sex = etSex.getText().toString().trim();

                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(age)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(sex)){
                    Toast.makeText(this, "请将用户信息填写完整", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(CommentUtils.getInstance().isInteger(age)){
                    User user = new User(null, name, Integer.valueOf(age), phone,sex/*,"爱好"*/);
                    SQLiteUtils.getInstance().addUser(user);
                }else{
                    Toast.makeText(this, "你输入的年龄不是数字", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bt_delete:
                tvWay.setText(btDelete.getText().toString().trim());
                for (int i = 0; i < userList.size(); i++) {
                    if("女".equals(userList.get(i).getSex())){
                        SQLiteUtils.getInstance().deleteUser(userList.get(i));
                    }
                }
                findAllAndNotify();
                break;
            case R.id.bt_updata:
                for (int i = 0; i < userList.size(); i++) {
                    userList.get(i).setAge(25);
                    SQLiteUtils.getInstance().updataUser(userList.get(i));
                }
                findAllAndNotify();
                break;
            case R.id.bt_find_all:
                tvWay.setText(btFindAll.getText().toString().trim());
                findAllAndNotify();
                break;
            case R.id.bt_name:
                tvWay.setText(btName.getText().toString().trim());
                List<User> listName = SQLiteUtils.getInstance().selectName("小明");
                if (listName.size() == 0) {
                    Toast.makeText(this, "没有相匹配的查询", Toast.LENGTH_SHORT).show();
                }
                userList.clear();
                userList.addAll(listName);
                userAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_age:
                break;
            case R.id.bt_delete_all:
                SQLiteUtils.getInstance().deleteAll();

                tvWay.setText(btDeleteAll.getText().toString().trim());
                userList.clear();
                findAllAndNotify();
                break;
            case R.id.bt_person:
                startActivity(new Intent(this,PersonActivity.class));
                break;
        }
    }

    /**
     * 查询所有数据 并更新适配器
     */
    private void findAllAndNotify() {
        userList.clear();
        List<User> all = SQLiteUtils.getInstance().findAll();
        if (all.size() == 0) {
            Toast.makeText(this, "没有查询到任何数据", Toast.LENGTH_SHORT).show();
        }
        userList.addAll(all);
        userAdapter.notifyDataSetChanged();
    }
}
