package com.mastercoding.coffeebreak.CreateAccount;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mastercoding.coffeebreak.R;

import java.util.Objects;

import com.mastercoding.coffeebreak.Products.Products;

public class RegisterFragment extends Fragment {
    Button register;
    EditText ed_firstName;
    EditText ed_lastName;
    EditText ed_phone;
    EditText ed_email;
    EditText ed_password;
    EditText ed_confirmPassword;
    FirebaseAuth mAuth=null;
    //==================================================================================================
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//
    public RegisterFragment() {
        // Required empty public constructor
    }
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initFieldRegister(view);
//        createSinUp(view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        register = view.findViewById(R.id.btn_register);
        initFieldRegister(view);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                createSinUp(view);
                goToProducts();
            }
        });

        return view;
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (mAuth!=null){
//            startActivity(new Intent(getActivity(),Products.class));
//        }
//    }
//=================================================================================================
    private void initFieldRegister(View view){
        ed_firstName = view.findViewById(R.id.edit_PersonName);
        ed_lastName=view.findViewById(R.id.edit_lastName);
        ed_phone=view.findViewById(R.id.edit_phoneNumber);
        ed_email=view.findViewById(R.id.edit_resetEmail);
        ed_password =view.findViewById(R.id.edit_ResetPassword);
        ed_confirmPassword=view.findViewById(R.id.edit_confirmPassword);
    }
    //this method to sin Up (Register new account) with firebase.
    private void createSinUp(View view){
        mAuth = FirebaseAuth.getInstance();
        String fName = ed_firstName.getText().toString();
        String lName = ed_lastName.getText().toString();
        String phoneNum = ed_phone.getText().toString();
        String emailRegister = ed_email.getText().toString();
        String passwordRegister = ed_password.getText().toString();
        String conPasswordRegister = ed_confirmPassword.getText().toString();

        if (fName.isEmpty()&&lName.isEmpty()&&phoneNum.isEmpty()&&
                emailRegister.isEmpty()&&passwordRegister.isEmpty()&&conPasswordRegister.isEmpty()){
            Toast.makeText(getContext(), "you must full all Field", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.createUserWithEmailAndPassword(emailRegister,passwordRegister)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                      sendEmailVerification();
                    }
                }
            });

        }
    }
    //this method to move to another class (Products.class) used by Intent.
    private void goToProducts() {
        Intent intent = new Intent(getActivity(), Products.class);
        startActivity(intent);
    }
    private void sendEmailVerification(){
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getContext(), Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_SHORT).show();
                }else {
                    goToProducts();
                }

            }
        });
    }

}