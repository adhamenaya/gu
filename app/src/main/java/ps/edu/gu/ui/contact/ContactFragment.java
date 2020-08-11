package ps.edu.gu.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ps.edu.gu.R;
import ps.edu.gu.ui.home.HomeFragment;
import ps.edu.gu.ui.utils.Contact;
import ps.edu.gu.ui.utils.Course;

public class ContactFragment extends Fragment {

    ContactAdapter contactAdapter;
    List<Contact> contacts;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.list);
        PrepareData();
        contactAdapter = new ContactAdapter(contacts);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(contactAdapter);


        return root;
    }
    private void PrepareData(){
        contacts = new ArrayList<Contact>();
        Contact contact = new Contact("عمادة القبول والتسجيل", "0599990559");
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);
        contacts.add(contact);

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
            return new VH(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull CourseAdapter.VH holder, int position) {
            Course course = courses.get(position);
            Random rnd = new Random();
          //  int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
         //   holder.parent.setBackgroundColor(currentColor);
            holder.tvTitle.setText(course.name);
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

    class ContactAdapter extends RecyclerView.Adapter<ContactFragment.ContactAdapter.VH>{
        List<Contact> contacts;
        public ContactAdapter(List<Contact> contacts){
            this.contacts = contacts;
        }

        @NonNull
        @Override
        public ContactFragment.ContactAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_contact, parent, false);
            return new ContactFragment.ContactAdapter.VH(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactFragment.ContactAdapter.VH holder, int position) {
            Contact contact = contacts.get(position);
            Random rnd = new Random();
            //  int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            //   holder.parent.setBackgroundColor(currentColor);
            holder.tvName.setText(contact.name);
            holder.tvNumber.setText(contact.number);
            //  holder.age.setText(String.valueOf(data.age));
        }

        @Override
        public int getItemCount() {
            return contacts.size();
        }

        class VH extends RecyclerView.ViewHolder{
            TextView tvName;
            TextView tvNumber;
            ImageView ivCall;

            public VH(View view){
                super(view);
                tvName = view.findViewById(R.id.tvName);
                tvNumber = view.findViewById(R.id.tvNumber);
                ivCall = view.findViewById(R.id.ivCall);
            }
        }
    }
}