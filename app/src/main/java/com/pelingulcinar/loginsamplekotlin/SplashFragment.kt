package com.pelingulcinar.loginsamplekotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth


class SplashFragment : Fragment() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val currentUser by lazy { firebaseAuth.currentUser } //?


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth.currentUser?.let {

            return
        }



        object : CountDownTimer(3000, 1000) {

            override fun onFinish() {
                navigate(R.id.action_splashFragment_to_loginFragment)
            }

            override fun onTick(p0: Long) {

            }

        }.start()
    }

    override fun onStart() {
        super.onStart()

        firebaseAuth.currentUser?.let {
            navigate(R.id.action_splashFragment_to_dashboardFragment)
        }
    }

    private fun navigate(action: Int) {

        view?.let { _view ->

            Navigation.findNavController(_view).navigate(action)
        }

    }
}
