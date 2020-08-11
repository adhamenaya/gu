package ps.edu.gu.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ps.edu.gu.R;
import ps.edu.gu.ui.utils.Course;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    CourseAdapter courseAdapter;
    List<Course> courses;
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.rvCourses);
        PrepareData();
        courseAdapter = new CourseAdapter(courses);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(courseAdapter);


        return root;
    }
    private void PrepareData(){
        courses = new ArrayList<Course>();
        Course course1 = new Course("الهندسة","ic_architect","1");
        Course course2 = new Course("علوم الحاسوب و تكنولوجيا المعلومات","ic_code","3");
        Course course3 = new Course("العلوم الإدارية و المالية","ic_woman","6");
        Course course4 = new Course("علوم الإتصال و اللغات","ic_receptionist","5");
        Course course5 = new Course("التربية","ic_writer","4");
        Course course6 = new Course("القانون","ic_lawyer","2");
        Course course7 = new Course("كلية الدراسات المتوسطة","ic_student","7");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);

    }
    class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.VH>{
        List<Course> courses;
        public CourseAdapter(List<Course> courses){
            this.courses = courses;
        }

        @NonNull
        @Override
        public CourseAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_course, parent, false);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = recyclerView.getChildLayoutPosition(view);
                    String item = courses.get(itemPosition).name;
                   // Toast.makeText(getContext(), item, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), CourseDetailActivity.class);
                    intent.putExtra("programId",courses.get(itemPosition).programId);
                    getContext().startActivity(intent);
                }
            });
            return new VH(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull CourseAdapter.VH holder, int position) {
            Course course = courses.get(position);
            Random rnd = new Random();
          //  int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
         //   holder.parent.setBackgroundColor(currentColor);
            holder.tvTitle.setText(course.name);
            final int resourceId = getContext().getResources().getIdentifier(course.icon, "drawable",
                    getContext().getPackageName());
            holder.ivIcon.setImageDrawable(getContext().getResources().getDrawable(resourceId));
          //  holder.age.setText(String.valueOf(data.age));
        }

        @Override
        public int getItemCount() {
            return courses.size();
        }

        class VH extends RecyclerView.ViewHolder{
            TextView tvTitle;
            ImageView ivIcon;

            public VH(View view){
                super(view);
                tvTitle = view.findViewById(R.id.tvTitle);
                ivIcon = view.findViewById(R.id.ivIcon);
            }
        }
    }
}