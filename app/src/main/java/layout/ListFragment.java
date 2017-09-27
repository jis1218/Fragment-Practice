package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentbasic.R;

import static android.R.attr.button;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    CallBack callBack = null;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) { // 이 컨텍스트가 나를 삽입한 액티비티이다.
        // 1. 나를 사용한 액티비티가 내가 제공한 인터페이스를 구현했는지 확인
        if(context instanceof CallBack){
            callBack = (CallBack) context;
        }
        super.onAttach(context);
        Log.d("Frag", "===============onAttach()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Frag", "===============onDetach()");
    }

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("Frag", "===============onCreateView()");
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        button = (Button) view.findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callBack.goDetail();

            }
        });
        return view;
    }

    public interface CallBack{
        public void goDetail();
    };

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Frag", "===============onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Frag", "===============onResume()");
    }
}
