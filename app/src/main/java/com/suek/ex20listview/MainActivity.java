package com.suek.ex20listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1) 참조변수 생성
    ListView listView;

    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.lv);
        // 2) 리스트뷰에서 보여줄 View 들을 만들어주는 객체생성(인쇄기 같은 역할= 시안작업한 것(배치모양)을 인쇄해서 Activity(화면)에 보여줌
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.list_item);

        // 3) 리스트뷰에게 아답터 설정
        listView.setAdapter(adapter);

        // 4 )리스트뷰의 항목(item)을 클릭하는 것을 듣는 리스너 객체 생성 및 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent= AdapterView(ListView),
                // view=눌른놈, 어떤뷰를 눌렀나(식별자/ 별도의 식별자를 지정 안했으면 0번 1번...이런식)

                // 5) res '창고관리자(Resources)' 객체 생성아니고 "소환"
                Resources res= getResources();      // Resources res= this.getResources(); this 를 쓰게되면 OnItemClickListener 의 this 로 알아듣지못하고 mainActivity 의 this 로 알아들음
                                                    //OnItemClickListener 가 mainActivity 의 이너클래스 이기때문

                // res/values/arrays.xml 문서안에 있는 datas 라는 이름의 배열 얻어오기
                String[] arr= res.getStringArray(R.array.datas);

                // 4) 리스너객체가 생성되었는지 확인하기 위해 Toast 생성
                //Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();    //OnItemClickListener 안에 있기때문에 this 가 아니라 MainActivity.this
                                                                                     //position+"": @StringRes int resId=>> string 을 xml 문서에 만들기위한 목적으로 꼭 문자열로 바꿔줌
                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();


            }
        });

        // 6) 아이템 롱~~클릭리스너 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "long click", Toast.LENGTH_SHORT).show();

                // 보통 이곳에서 PopupMenu 를 만들어서 보여줌

                return  true;   //true 로 안하면 onClick 도 발동함
            }
        });


    }
}
