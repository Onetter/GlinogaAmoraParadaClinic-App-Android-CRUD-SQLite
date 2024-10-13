package info.codestart.glinogaprdrecrds;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements Filterable {

    private List<Person> exampleList;
    private List<Person> exampleListFull;
    private Context mContext;
    private RecyclerView mRecyclerV;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView personNameTxtV;
        public TextView personAgeTxtV;
        public TextView personDateTxtV;



        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            personNameTxtV = (TextView) v.findViewById(R.id.name);
            personAgeTxtV = (TextView) v.findViewById(R.id.age);
            personDateTxtV = (TextView) v.findViewById(R.id.date);
        }


    }

    public void add(int position, Person person) {
        exampleList.add(position, person);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        exampleList.remove(position);
        notifyItemRemoved(position);
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public PersonAdapter(List<Person> myDataset, Context context, RecyclerView recyclerView) {
       this.exampleList = myDataset;
        exampleListFull = new ArrayList<>(exampleList);
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.single_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Person person = exampleList.get(position);
        holder.personNameTxtV.setText("Name: " + person.getName());
        holder.personAgeTxtV.setText("Age: " + person.getAge());
        holder.personDateTxtV.setText("Date: " + person.getDate());

        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("View, Update or Delete record?");
                builder.setPositiveButton("View / Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    //go to update activity
                        goToUpdateActivity(person.getId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonDBHelper dbHelper = new PersonDBHelper(mContext);
                        dbHelper.deletePersonRecord(person.getId(), mContext);

                        exampleList.remove(position);
                        mRecyclerV.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, exampleList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });


    }

    private void goToUpdateActivity(long personId){
        Intent goToUpdate = new Intent(mContext, UpdateRecordActivity.class);
        goToUpdate.putExtra("USER_ID", personId);
        mContext.startActivity(goToUpdate);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter(){
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Person> filteredList = new ArrayList<>();
           // ArrayList<String> flist=new ArrayList<>();
            if(charSequence == null || charSequence.length()==0){
                filteredList.addAll(exampleListFull);
            }else{
                String filterPatern = charSequence.toString().toLowerCase().trim();
                for (Person item : exampleListFull){
                    if(item.getName().toLowerCase().contains(filterPatern)){     //PersonAdapter.java189 Here sir
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            exampleList.clear();
            exampleList.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };
}