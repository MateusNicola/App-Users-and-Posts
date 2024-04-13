package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

import Models.UserModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private final List<UserModel> users;

    public UserAdapter(List<UserModel> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView usernameTextView;
        private final TextView emailTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_name);
            usernameTextView = itemView.findViewById(R.id.text_username);
            emailTextView = itemView.findViewById(R.id.text_email);
        }

        public void bind(UserModel user) {
            nameTextView.setText(user.getName());
            usernameTextView.setText(user.getUsername());
            emailTextView.setText(user.getEmail());
        }
    }
}

