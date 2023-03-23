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
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mastercoding.coffeebreak.R;

import com.mastercoding.coffeebreak.Products.Products;
public class LoginFragment extends Fragment {
    Button log;
    ImageButton facebook;
    ImageButton gmail;
    EditText ed_email;
    EditText ed_namePerson;
    EditText ed_password;
    Button resetPassword;
    FirebaseAuth mAuth=null;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
//        initField(view);
//        createLogin(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_login, container, false);
        mAuth = FirebaseAuth.getInstance();
        log = rootView.findViewById(R.id.btn_login);

        initFieldLogin(rootView);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               CreateSingIn(view);
                goToProducts();
            }
        });
//        resetPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resetPassword();
//            }
//        });
        return rootView;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if (mAuth!=null){
//            startActivity(new Intent(getActivity(),Products.class));
//        }
//    }

    //================================================================================================
    public void initFieldLogin(View view){
        resetPassword=view.findViewById(R.id.btn_forgetten);
        ed_email = view.findViewById(R.id.edit_Email);
        ed_namePerson=view.findViewById(R.id.edit_name);
        ed_password=view.findViewById(R.id.edit_password);
    }
    public void CreateSingIn(View view) {
        mAuth = FirebaseAuth.getInstance();
        String email = ed_email.getText().toString();
        String name = ed_namePerson.getText().toString();
        String password = ed_password.getText().toString();
        if (email.isEmpty()&&name.isEmpty()&&password.isEmpty()){
            Toast.makeText(getContext(), "You must enter full above field", Toast.LENGTH_SHORT).show();
        }else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
                        verifyEmailAddress();
                    }
                }
            });
        }
    }
    public void goToProducts() {
        Intent intent = new Intent(getActivity(), Products.class);
        startActivity(intent);
    }
    public void verifyEmailAddress(){
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        if (user.isEmailVerified()){
            Toast.makeText(getContext(), "Please,verify Your account", Toast.LENGTH_SHORT).show();
        }else{
            goToProducts();
        }
    }
    private void resetPassword(){
        String email = ed_email.getText().toString();
        String newPassword = ed_password.toString();
        FirebaseUser user = mAuth.getCurrentUser();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getContext(), "reset password", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.confirmPasswordReset("",newPassword);
                }
            }
        });
    }
}