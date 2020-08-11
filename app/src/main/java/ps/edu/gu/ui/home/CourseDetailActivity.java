package ps.edu.gu.ui.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ps.edu.gu.R;
import ps.edu.gu.ui.dashboard.DepthPageTransformer;
import ps.edu.gu.ui.dashboard.ImageModel;
import ps.edu.gu.ui.utils.Course;
import ps.edu.gu.ui.utils.CourseDetails;
import ps.edu.gu.ui.utils.Util;

public class CourseDetailActivity extends AppCompatActivity {
    CourseDetailsAdapter courseDetailsAdapter;
    List<CourseDetails> courseDetailsList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_course_details);

        //toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
       // setSupportActionBar(toolbar);

      //  data = getIntent().getParcelableArrayListExtra("data");
        String programId = "1";
        if(getIntent()!=null ) {
            programId = getIntent().getStringExtra("programId");
        }
       // setTitle(data.get(pos).getName());

        recyclerView = findViewById(R.id.rvCourses);
        PrepareData();
        filterData(programId);
        courseDetailsAdapter = new CourseDetailsAdapter(courseDetailsList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(courseDetailsAdapter);

    }
    private void PrepareData(){
        courseDetailsList = new ArrayList<CourseDetails>();
        CourseDetails course0 = new CourseDetails("Math 1",
                "1","18","17","Type1",
                 "65%","No comment","BA","15%");
        CourseDetails course1= new CourseDetails("1","الهندسة المدنية","بكالوريوس","العلمي/ الصناعي/ فرع تكنولوجيا المعلومات","80%","24","25%","18","");
        CourseDetails course2= new CourseDetails("1","هندسة الحاسوب","بكالوريوس","العلمي/ الصناعي/ فرع تكنولوجيا المعلومات","80%","24","25%","18","");
        CourseDetails course3= new CourseDetails("2","القانون","بكالوريوس","العلمي/ الأدبي/ الشرعي","75%","18","25%","14","");
        CourseDetails course4= new CourseDetails("3","التصميم الجرافيكي والوسائط المتعددة","بكالوريوس","جميع التخصصات","65%","20","25%","15","");
        CourseDetails course5= new CourseDetails("3","علوم الحاسوب","بكالوريوس","العلمي/ الصناعي/ فرع تكنولوجيا المعلومات","65%","20","25%","15","");
        CourseDetails course6= new CourseDetails("4","التعليم الأساسي","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course7= new CourseDetails("4","تعليم اللغة الإنجليزية ","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course8= new CourseDetails("4","تعليم اللغة العربية ","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course9= new CourseDetails("4","تعليم الرياضيات","بكالوريوس","العلمي/ الصناعي/ فرع تكنولوجيا المعلومات/ الزراعي","65%","16","25%","12","");
        CourseDetails course10= new CourseDetails("4","تعليم الاجتماعيات","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course11= new CourseDetails("5","اللغة الإنجليزية والترجمة","بكالوريوس","جميع التخصصات","65%","18","25%","14","");
        CourseDetails course12= new CourseDetails("5","العلاقات العامة","بكالوريوس","جميع التخصصات","65%","18","25%","14","");
        CourseDetails course13= new CourseDetails("5","الإنتاج التلفزيوني والسينمائي","بكالوريوس","جميع التخصصات","65%","18","25%","14","");
        CourseDetails course14= new CourseDetails("5","الإعلام الإلكتروني","بكالوريوس","جميع التخصصات","65%","18","25%","14","");
        CourseDetails course15= new CourseDetails("6","إدارة الأعمال (باللغة العربية)","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course16= new CourseDetails("6","إدارة الأعمال  (باللغة الإنجليزية)","بكالوريوس","جميع التخصصات","65%","20","25%","15","");
        CourseDetails course17= new CourseDetails("6","إدارة الأعمال (باللغة الإنجليزية)","بكالوريوس","جميع التخصصات","65%","16","25%","12","");
        CourseDetails course18= new CourseDetails("6","المحاسبة (باللغة الإنجليزية)","بكالوريوس","جميع التخصصات","65%","20","25%","15","");
        CourseDetails course19= new CourseDetails("7","العلوم المالية والمصرفية","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course20= new CourseDetails("7","إدارة وأتمتة المكاتب","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course21= new CourseDetails("7","السكرتارية الطبية","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course22= new CourseDetails("7","تربية الطفل","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course23= new CourseDetails("7","السكرتارية القانونية","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course24= new CourseDetails("7","البرمجيات وقواعد البيانات","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course25= new CourseDetails("7","العلاقات العامة والإعلان","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course26= new CourseDetails("7","التصميم الجرافيكي","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course27= new CourseDetails("7","التصوير السينمائي والمونتاج","دبلوم","جميع التخصصات","50%","20","25%","15","");
        CourseDetails course28= new CourseDetails("7","التسويق الإلكتروني","دبلوم","جميع التخصصات","50%","20","25%","15","");
        courseDetailsList.add(course1);
        courseDetailsList.add(course2);
        courseDetailsList.add(course3);
        courseDetailsList.add(course4);
        courseDetailsList.add(course5);
        courseDetailsList.add(course6);
        courseDetailsList.add(course7);
        courseDetailsList.add(course8);
        courseDetailsList.add(course9);
        courseDetailsList.add(course10);
        courseDetailsList.add(course11);
        courseDetailsList.add(course12);
        courseDetailsList.add(course13);
        courseDetailsList.add(course14);
        courseDetailsList.add(course15);
        courseDetailsList.add(course16);
        courseDetailsList.add(course17);
        courseDetailsList.add(course18);
        courseDetailsList.add(course19);
        courseDetailsList.add(course20);
        courseDetailsList.add(course21);
        courseDetailsList.add(course22);
        courseDetailsList.add(course23);
        courseDetailsList.add(course24);
        courseDetailsList.add(course25);
        courseDetailsList.add(course26);
        courseDetailsList.add(course27);
        courseDetailsList.add(course28);

    }

    private void filterData(String programId){
        List<CourseDetails> courseDetailsList2 = new ArrayList<CourseDetails>();
        for(CourseDetails details: courseDetailsList){
            if(details.programId.equals(programId)){
                courseDetailsList2.add(details);
            }
        }
        courseDetailsList.clear();
        courseDetailsList.addAll(courseDetailsList2);
    }
    class CourseDetailsAdapter extends RecyclerView.Adapter<CourseDetailActivity.CourseDetailsAdapter.VH>{
        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;
        List<CourseDetails> courses;
        public CourseDetailsAdapter(List<CourseDetails> courses){
            this.courses = courses;
        }

        @NonNull
        @Override
        public CourseDetailActivity.CourseDetailsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView;
            if(viewType == TYPE_HEADER) {
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_course_details_header, parent, false);
            }
            else{
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_course_details, parent, false);
            }
            return new CourseDetailActivity.CourseDetailsAdapter.VH(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull CourseDetailActivity.CourseDetailsAdapter.VH holder, int position) {
            if (isHeader(position)) {
                return;
            }else {
                position =  position - 1;
                CourseDetails course = courses.get(position);
                //  int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                //   holder.parent.setBackgroundColor(currentColor);
                holder.tvName1.setText(course.name);
                holder.tvName2.setText(course.degree);
                holder.tvName3.setText(course.percentage);
                holder.tvName4.setText(course.degreeType);
                holder.tvName5.setText(course.priceBeforeSch);
                holder.tvName6.setText(course.schPercentage);
                holder.tvName7.setText(course.priceAfterSch);
               // holder.tvName8.setText(course.comments);

                holder.btnPlanDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(CourseDetailActivity.this, ViewPDFActivity.class);
                        startActivity(i);
                    }
                });
            }

        }
        public boolean isHeader(int position) {
            return position == 0;
        }
        @Override
        public int getItemCount() {
            return (courses.size() + 1); // 1 for header
        }
        @Override
        public int getItemViewType(int position) {
            return isHeader(position) ? TYPE_HEADER : TYPE_ITEM;
        }
        class VH extends RecyclerView.ViewHolder{
            TextView tvName1;
            TextView tvName2;
            TextView tvName3;
            TextView tvName4;
            TextView tvName5;
            TextView tvName6;
            TextView tvName7;
            Button btnPlanDownload;

            public VH(View view){
                super(view);

                tvName1 = view.findViewById(R.id.tvName1);
                tvName2 = view.findViewById(R.id.tvName2);
                tvName3 = view.findViewById(R.id.tvName3);
                tvName4 = view.findViewById(R.id.tvName4);
                tvName5 = view.findViewById(R.id.tvName5);
                tvName6 = view.findViewById(R.id.tvName6);
                tvName7 = view.findViewById(R.id.tvName7);
                btnPlanDownload = view.findViewById(R.id.btnPlanDownload);

             }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public ArrayList<ImageModel> data = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<ImageModel> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position, data.get(position).getName(), data.get(position).getUrl());
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data.get(position).getName();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        String name, url;
        int pos;
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMG_TITLE = "image_title";
        private static final String ARG_IMG_URL = "image_url";

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            this.pos = args.getInt(ARG_SECTION_NUMBER);
            this.name = args.getString(ARG_IMG_TITLE);
            this.url = args.getString(ARG_IMG_URL);
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String name, String url) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_IMG_TITLE, name);
            args.putString(ARG_IMG_URL, url);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public void onStart() {
            super.onStart();

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            final ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_image);

            Glide.with(getActivity()).load(url).thumbnail(0.1f).into(imageView);

            return rootView;
        }

    }
}
