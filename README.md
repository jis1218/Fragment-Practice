MainActivity, activity_main에서
```java
getFragmentManager().beginTransaction()
.add(R.id.container, new SecondFragment())
.addToBackStack(null).commit();
```
을 통해 FrameLayout 위에 올려놓으면,
맨 처음 Button view가 올려져있고 그 다음 Fragment가 보인다.
아마 버튼 객체가 view에서 가장 우선순위에 있는 듯하다.

만약 First Fragment에 버튼을 하나 올려놓고 그걸 Fragment에서 부르게 되면 버튼은 여전히
Second Fragment 위에 있게 되지만, activity_main의 frameLayout에서 부르게 되면 버튼은 가려진다.
그 이유는 버튼 view가 있는 전에 있던 fragment가 새로운 frameLayout에 올려진 fragment에 의해 가려지기 때문이다.
```java
public class MainActivity extends AppCompatActivity {
  private void setFragment(){
          getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).addToBackStack(null).commit();
      }
    }

/////////////////////////////////////////////////////////////////////////

    public class FirstFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          // Inflate the layout for this fragment

          View view = inflater.inflate(R.layout.fragment_first, container, false);
          button2 = view.findViewById(R.id.button2);
          button2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  setFragment();

              }
          });
  
          return view;
      }  

      public void setFragment(){
        getFragmentManager().beginTransaction().add(R.id.container, new SecondFragment()).commit();
    }
  }
```
위의 코드에서 만약 FirstFragment의 setFragment()에 addToBackStack을 안하게 되면 두 fragment 다 띄우고 뒤로 누르기 했을 때 두번째 fragment는 여전히 보이게 된다. 아마 첫번째 fragment와의 링크가 없기 때문인거 같고, 그냥 띄우기만 하는 것 같다. 스택에 올라가지 않으면 그냥 화면에 띄워지기만 하는 것 같다.
