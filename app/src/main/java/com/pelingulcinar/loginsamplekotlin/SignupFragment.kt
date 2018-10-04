package com.pelingulcinar.loginsamplekotlin

//import kotlinx.android.synthetic.main.fragment_login.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val userEmail by lazy { edtUserEmail.text.toString() }
    private val userPassword by lazy { edtUserPassword.text.toString() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnSignUp.setOnClickListener { _ ->

            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {

                            view?.let { _view ->
                                navigate(R.id.action_signupFragment_to_dashboardFragment)
                            }

                        }
                    }
        }
    }

    private fun navigate(action: Int) {

        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }

    }

}


// Fragment'ta asla onActivityCreated kullanma
// Acitivtylerde kullanabilirsin.
// Material yerine widget.cardview kullandım



