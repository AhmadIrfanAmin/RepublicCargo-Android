package com.logixcess.republiccargo.customer.adapters;
//import android.content.Context;
//        import android.net.Uri;
//        import android.support.annotation.NonNull;
//        import android.support.v7.widget.RecyclerView;
//
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//
//        import com.logixcess.owsadmin.R;
//        import com.logixcess.owsadmin.models.Service;
//        import com.squareup.picasso.Picasso;
//
//        import java.util.ArrayList;
//
//        import de.hdodenhof.circleimageview.CircleImageView;
//
//public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.BaseViewHolder> {
//    ArrayList<Service> services;
//    Context my_context;
//    @NonNull
//    @Override
//    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return new BaseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_service, viewGroup, false));
//
//    }
//    public BoxAdapter(Context context,ArrayList<Service> services)
//    {
//        my_context = context;
//        this.services = services;
//    }
//    @Override
//    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
//        Service service = services.get(position);
//        if (baseViewHolder instanceof BaseViewHolder) {
//            baseViewHolder.tv_service_name.setText(service.getService_name());
//            Picasso.get().load(service.getService_image_url()).into(baseViewHolder.iv_service_icon);
//        }
//    }
//    @Override
//    public int getItemCount() {
//        return services.size();
//    }
//    class BaseViewHolder extends RecyclerView.ViewHolder {
//        TextView tv_service_name;
//        CircleImageView iv_service_icon;
//        public BaseViewHolder(View itemView) {
//            super(itemView);
//            iv_service_icon = itemView.findViewById(R.id.iv_service_icon);
//            tv_service_name = itemView.findViewById(R.id.tv_service_name);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v)
//                {
//                    int position = getAdapterPosition();
//                    Service service = services.get(position);
//
//                }
//            });
//        }
//    }
//
//}
//




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.models.Box;
import com.ramotion.foldingcell.FoldingCell;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Programmer on 1/29/2018.
 */
public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.ViewHolder>
{

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    public  HashMap<String,ImageView> user_profile_record = new HashMap<>();
    public  HashMap<String,ArrayList<TextView>> flight_traveler_name = new HashMap<>();
    List<Box> boxList ;
    Context my_context;
    //    public MyViewHolder(View view) {
//        super(view);
//        title = (TextView) view.findViewById(R.id.title);
//        genre = (TextView) view.findViewById(R.id.genre);
//        year = (TextView) view.findViewById(R.id.year);
//        }
    public BoxAdapter(Context context, List<Box> objects)
    {
        boxList = objects;
        my_context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //FoldingCell cell = (FoldingCell) parent;
        //final ViewHolder viewHolder;
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell, parent, false);
        return new ViewHolder(itemView);
    }


    // simple methods for register cell state changes
    public void registerToggle(int position)
    {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }



    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position)
    {
        final Box box = boxList.get(position);
        //box.setReceiver_address("415 Rehmanpura Lahore");
        //box.setReceiver_address_map("24,33");
        //box.setReceiver_name("Ahmad");
        //box.setReceiver_phone("03124001981");
        //box.setSender_address("615 Ali Arcade");
        //box.setSender_address_map("34,43");
        //box.setSender_name("Saman Ali");
        //box.setSender_phone("03124477168");
        viewHolder.tv_destination1.setText(box.getReceiver_address());
        //viewHolder.arrival_date.setText(flight.getArrival_date()+" "+flight.getArrival_time());
        viewHolder.tv_origin1.setText(box.getSender_address());
        viewHolder.tv_receiver_name1.setText(box.getReceiver_name());
        viewHolder.tv_sender_name1.setText(box.getSender_name());
        viewHolder.tv_sender_phone1.setText(box.getSender_phone());
        viewHolder.tv_receiver_name1.setText(box.getReceiver_name());


        viewHolder.tv_destination_address2.setText(box.getReceiver_address());
        viewHolder.tv_origin_address2.setText(box.getSender_address());
        viewHolder.tv_receiver_name2.setText(box.getReceiver_name());
        viewHolder.tv_receiver_phone2.setText(box.getReceiver_phone());
        viewHolder.tv_sender_name2.setText(box.getSender_name());
        viewHolder.tv_sender_phone2.setText(box.getSender_phone());
        viewHolder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do whatever
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                registerToggle(position);
            }
        });
        viewHolder.btn_book.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });



    }

    @Override
    public int getItemCount() {
        return boxList.size();
        //return 4;
    }

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_sender_name2;
        TextView tv_sender_phone2;
        TextView tv_receiver_name2;
        TextView tv_receiver_phone2;
        TextView tv_origin_address2;
        TextView tv_destination_address2;
        ////TextView contentRequestBtn;
        //        TextView pledgePrice;
        ImageView iv_ocean_air2;

        Button btn_book;

        TextView tv_sender_name1;
        TextView tv_sender_phone1;
        TextView tv_receiver_name1;
        TextView tv_receiver_phone1;
        TextView tv_origin1;
        TextView tv_destination1;
        ////TextView contentRequestBtn;
        //        TextView pledgePrice;
        ImageView iv_ocean_air1;

        com.ramotion.foldingcell.FoldingCell foldingCell;
        public ViewHolder(View itemView) {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.folding_cell2);
            tv_sender_name2 = (TextView) itemView.findViewById(R.id.tv_sender_name2);
            tv_sender_phone2 = (TextView) itemView.findViewById(R.id.tv_sender_phone2);
            tv_receiver_name2 = (TextView) itemView.findViewById(R.id.tv_receiver_name2);
            tv_receiver_phone2 = (TextView) itemView.findViewById(R.id.tv_receiver_phone2);
            tv_origin_address2 = (TextView) itemView.findViewById(R.id.tv_origin_address2);
            tv_destination_address2 = (TextView) itemView.findViewById(R.id.tv_destination_address2);
            iv_ocean_air2 = (ImageView) itemView.findViewById(R.id.iv_ocean_air2);

            btn_book = (Button) itemView.findViewById(R.id.btn_book);
            tv_sender_name1 = (TextView) itemView.findViewById(R.id.tv_sender_name1);
            tv_sender_phone1 = (TextView) itemView.findViewById(R.id.tv_sender_phone1);
            tv_receiver_name1 = (TextView) itemView.findViewById(R.id.tv_receiver_name1);
            tv_receiver_phone1 = (TextView) itemView.findViewById(R.id.tv_receiver_phone1);
            tv_origin_address2 = (TextView) itemView.findViewById(R.id.tv_origin_address2);
            tv_origin1 = itemView.findViewById(R.id.tv_origin1);
            tv_destination1 = itemView.findViewById(R.id.tv_destination1);
            iv_ocean_air1 = itemView.findViewById(R.id.iv_ocean_air1);


        }
        //        TextView requestsCount;
        ////TextView date;
        ////TextView time;
    }
}
//public class FoldingCellListAdapter extends ArrayAdapter<FlightData>
//{
//
//    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
//    private View.OnClickListener defaultRequestBtnClickListener;
//    public  HashMap<String,ImageView> user_profile_record = new HashMap<>();
//    public  HashMap<String,ArrayList<TextView>> flight_traveler_name = new HashMap<>();
//    List<FlightData> flightDataArrayList ;
//
//    public FoldingCellListAdapter(Context context, List<FlightData> objects)
//    {
//        super(context, 0, objects);
//        flightDataArrayList = objects;
//        Log.d("objects",""+objects.size()+"\n");
//    }
//    FlightData flightData;
//    Flight flight;
//
//    @Override
//    public int getCount() {
//        Log.d("objects",""+flightDataArrayList.size()+"\n");
//        return flightDataArrayList.size();
//        //return flightDataArrayList == null ? 0 : flightDataArrayList.size();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {// get item for selected view
//        flightData = getItem(position);//flightDataArrayList.get(position);
//          flight = flightData.getFlight();
//        //Item item = getItem(position);
//        // if cell is exists - reuse it, if not - create the new one from resource
//                FoldingCell cell = (FoldingCell) convertView;
//        final ViewHolder viewHolder;
//        if (cell == null)
//        {
//            viewHolder = new ViewHolder();
//            LayoutInflater vi = LayoutInflater.from(getContext());
//            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
//            // binding view parts to view holder
//            viewHolder.price = (TextView) cell.findViewById(R.id.title_price);
//            viewHolder.arrival_time = (TextView) cell.findViewById(R.id.arrival_time);
//            viewHolder.arrival_time2 = (TextView) cell.findViewById(R.id.arrival_time2);
//            viewHolder.arrival_date = (TextView) cell.findViewById(R.id.arrival_date);
//            viewHolder.arrival_date2 = (TextView) cell.findViewById(R.id.arrival_date2);
//            viewHolder.fromAddress = (TextView) cell.findViewById(R.id.tv_origin);
//            viewHolder.toAddress = (TextView) cell.findViewById(R.id.tv_destination);
//
//            viewHolder.tv_weight = (TextView) cell.findViewById(R.id.tv_weight);
//            viewHolder.tv_weight2 = (TextView) cell.findViewById(R.id.tv_weight2);
//            viewHolder.tv_carryon = (TextView) cell.findViewById(R.id.tv_carryon);
//            viewHolder.tv_carryon2 = (TextView) cell.findViewById(R.id.tv_carryon2);
//            viewHolder.tv_checked_bag = (TextView) cell.findViewById(R.id.tv_checked_bag);
//            viewHolder.tv_checked_bag2 = (TextView) cell.findViewById(R.id.tv_checked_bag2);
//            viewHolder.label_weight = cell.findViewById(R.id.label_weight);
//            viewHolder.label_weight2 = cell.findViewById(R.id.label_weight2);
//            viewHolder.label_space_available = cell.findViewById(R.id.label_space_available);
//            viewHolder.label_space_available2 = cell.findViewById(R.id.label_space_available2);
//
//            viewHolder.tv_origin2 = cell.findViewById(R.id.tv_origin2);
//            viewHolder.tv_destination2 = cell.findViewById(R.id.tv_destination2);
//            viewHolder.tv_traveler_name = cell.findViewById(R.id.tv_traveler_name);
//            viewHolder.btn_request = cell.findViewById(R.id.btn_request);
//
//            viewHolder.label_weight.setPaintFlags(viewHolder.label_weight.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_weight.setText("Weight Available");
//            viewHolder.label_space_available.setPaintFlags(viewHolder.label_space_available.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_space_available.setText("Space Available");
//
//            viewHolder.label_weight2.setPaintFlags(viewHolder.label_weight2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_weight2.setText("Weight Available");
//            viewHolder.label_space_available2.setPaintFlags(viewHolder.label_space_available2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_space_available2.setText("Space Available");
//            //change
//            viewHolder.label_arrival = cell.findViewById(R.id.label_arrival);
//            viewHolder.label_arrival2 = cell.findViewById(R.id.label_arrival2);
//            viewHolder.label_space_price = cell.findViewById(R.id.label_space_price);
//            viewHolder.space_price = cell.findViewById(R.id.space_price);
//            viewHolder.arrival_date = cell.findViewById(R.id.arrival_date);
//            viewHolder.iv_profile = cell.findViewById(R.id.iv_profile);
//            viewHolder.rb_traveler = cell.findViewById(R.id.rb_traveler);
//
//            viewHolder.label_arrival.setPaintFlags(viewHolder.label_arrival.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_arrival.setText("Arrival:");
//
//            viewHolder.label_arrival2.setPaintFlags(viewHolder.label_arrival2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_arrival2.setText("Arrival:");
//            viewHolder.label_space_price.setPaintFlags(viewHolder.label_space_price.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//            viewHolder.label_space_price.setText("Price for Space:");
//
//            if(flightData.getTraveler_image()!=null)
//            new DownloadImageTask((viewHolder.iv_profile),0,getContext()).execute(flightData.getTraveler_image());
//            viewHolder.tv_traveler_name.setText(flightData.getTraveler_name());
//
//
//            cell.setTag(viewHolder);
//        }
//        else
//        {
//            // for existing cell set valid valid state(without animation)
//            if (unfoldedIndexes.contains(position)) {
//                cell.unfold(true);
//            } else {
//                cell.fold(true);
//            }
//            viewHolder = (ViewHolder) cell.getTag();
//        }
//
//        // bind data from selected element to view through view holder
//        viewHolder.price.setText(flight.getPrice_requested());
//        viewHolder.arrival_time.setText(flight.getArrival_time());
//        viewHolder.arrival_date.setText(flight.getArrival_date());
//        viewHolder.fromAddress.setText(flight.getOrigin());
//        viewHolder.toAddress.setText(flight.getDestination());
//        //viewHolder.arrival_date.setText(flight.getArrival_date()+" "+flight.getArrival_time());
//        viewHolder.space_price.setText(flight.getPrice_requested());
//        viewHolder.tv_carryon.setText(String.valueOf(flight.getCarry_on()));
//        viewHolder.tv_carryon2.setText(String.valueOf(flight.getCarry_on()));
//        viewHolder.tv_checked_bag.setText(String.valueOf(flight.getChecked_bag()));
//        viewHolder.tv_checked_bag2.setText(String.valueOf(flight.getChecked_bag()));
//        viewHolder.tv_weight.setText(flight.getWeight()+" lbs.");//("3 lbs.");
//        viewHolder.tv_weight2.setText(flight.getWeight()+" lbs.");
//
//        viewHolder.tv_origin2.setText(flight.getOrigin());
//        viewHolder.tv_destination2.setText(flight.getDestination());
//        viewHolder.arrival_time2.setText(flight.getArrival_time());
//        viewHolder.arrival_date2.setText(flight.getArrival_date());
//        viewHolder.rb_traveler.setRating(flightData.getUser_rating());
//
//        viewHolder.btn_request.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(getContext(), RequestFlightActivity.class);
//                intent.putExtra("flight",flight);
//                intent.putExtra("traveler_name",viewHolder.tv_traveler_name.getText().toString());
//                intent.putExtra("traveler_pic",flightData.getTraveler_image());
//                getContext().startActivity(intent);
//            }
//        });
//
//
//        return cell;
//    }
//
//    // simple methods for register cell state changes
//    public void registerToggle(int position)
//    {
//        if (unfoldedIndexes.contains(position))
//            registerFold(position);
//        else
//            registerUnfold(position);
//    }
//
//    public void registerFold(int position) {
//        unfoldedIndexes.remove(position);
//    }
//
//    public void registerUnfold(int position) {
//        unfoldedIndexes.add(position);
//    }
//
//    public View.OnClickListener getDefaultRequestBtnClickListener() {
//        return defaultRequestBtnClickListener;
//    }
//
//    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
//        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
//    }
//
//    // View lookup cache
//    private static class ViewHolder
//    {
//        TextView price;
//        TextView arrival_date;
//        TextView arrival_time;
//        TextView arrival_time2;
//        TextView arrival_date2;
//        ////TextView contentRequestBtn;
//        //        TextView pledgePrice;
//        TextView fromAddress;
//        TextView toAddress;
//
//        TextView tv_weight;
//
//        TextView tv_carryon;
//        TextView tv_carryon2;
//        TextView tv_checked_bag2;
//        TextView tv_checked_bag;
//        TextView label_weight;
//        TextView label_weight2;
//        TextView label_space_available;
//        TextView label_space_available2;
//
//        TextView label_arrival;
//        TextView label_arrival2;
//        TextView label_space_price;
//        TextView space_price;
//        RatingBar rb_traveler;
//
//
//        //cell content layout
//
//        TextView tv_origin2;
//        TextView tv_destination2;
//
//        TextView tv_traveler_name;
//
//        TextView tv_weight2;
//        Button btn_request;
//        ImageView iv_profile;
//        //        TextView requestsCount;
//        ////TextView date;
//        ////TextView time;
//    }
//}
