package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myfirstapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("count", binding.countDisplay.getText().toString());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, args);
            }
        });
       /* binding.toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.hiToast.isShown()) {
                    binding.hiToast.setVisibility(View.VISIBLE);
                } else {
                    binding.hiToast.setVisibility(View.INVISIBLE);
                }
            }
        }); */

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        binding.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countString = binding.countDisplay.getText().toString();
                Integer count = Integer.parseInt(countString);
                count++;
                binding.countDisplay.setText(count.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}