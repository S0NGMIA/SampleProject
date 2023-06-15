package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myfirstapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    String currCount;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        currCount=getArguments().getString("count");
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.getCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.displayCount.setText("COUNT: " + currCount);
                binding.displayCount.setVisibility(View.VISIBLE);
            }
        });

        binding.randNumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.randNumDisplay.setVisibility(View.VISIBLE);
                if (binding.leftNum.getText().length()!=0 && binding.rightNum.getText().length()!=0) {
                    int min = Integer.parseInt(binding.leftNum.getText().toString());
                    int max = Integer.parseInt(binding.rightNum.getText().toString());
                    if (max < min) {
                        int temp = max;
                        max = min;
                        min = temp;
                    }
                    int randNum = (int) (Math.random() * (max - min + 1)) + min;
                    binding.randNumDisplay.setText("" + randNum);
                } else {
                    binding.randNumDisplay.setText(getString(R.string.no_rand_num));
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}