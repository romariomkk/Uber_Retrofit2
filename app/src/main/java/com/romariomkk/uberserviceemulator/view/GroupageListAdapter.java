package com.romariomkk.uberserviceemulator.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.romariomkk.uberserviceemulator.R;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class GroupageListAdapter extends RecyclerView.Adapter<GroupageListAdapter.ViewHolder> {

    private Context context;
    private List<Groupage> groupages;

    public GroupageListAdapter(Context ctxt, List<Groupage> groupages)
    {
        this.context = ctxt;
        this.groupages = groupages;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        List<TextView> textViews;

        public ViewHolder(View itemView)
        {
            super(itemView);
            textViews = new LinkedList<TextView>(){{
                add((TextView) itemView.findViewById(R.id.gr_Desc));
                add((TextView) itemView.findViewById(R.id.time_Start));
                add((TextView) itemView.findViewById(R.id.time_End));
                add((TextView) itemView.findViewById(R.id.gr_Status));
                add((TextView) itemView.findViewById(R.id.gr_commission));
                add((TextView) itemView.findViewById(R.id.gr_createdAt));
                add((TextView) itemView.findViewById(R.id.gr_updatedAt));
                add((TextView) itemView.findViewById(R.id.gr_driver_reward));
                add((TextView) itemView.findViewById(R.id.gr_companyProceeds));
            }};
        }

        public void setGroupage(Groupage groupage)
        {
            textViews.get(0).setText(String.format(context.getString(R.string.gr_Desc),
                    groupage.getGroupageDescription()));
            textViews.get(1).setText(String.format(context.getString(R.string.start_time),
                    groupage.getExpectedPickUpTime().getStartTime()));
            textViews.get(2).setText(String.format(context.getString(R.string.end_time),
                    groupage.getExpectedPickUpTime().getEndTime()));
            textViews.get(3).setText(String.format(context.getString(R.string.status),
                    groupage.getGroupageStatus()));
            textViews.get(4).setText(String.format(context.getString(R.string.delivery_commission),
                    groupage.getDeliveryCommission()));
            textViews.get(5).setText(String.format(context.getString(R.string.created_at),
                    groupage.getCreatedAt()));
            textViews.get(6).setText(String.format(context.getString(R.string.updated_at),
                    groupage.getUpdatedAt()));
            textViews.get(7).setText(String.format(context.getString(R.string.driver_reward),
                    groupage.getDriverReward()));
            textViews.get(8).setText(String.format(context.getString(R.string.company_proceeds),
                    groupage.getCompanyProceeds()));

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.single_groupage_item, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Groupage groupage = groupages.get(position);
        holder.setGroupage(groupage);
    }

    @Override
    public int getItemCount()
    {
        return groupages.size();
    }

}
