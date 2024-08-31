package com.example.formallanguage.fragments


import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.formallanguage.BookActivity
import com.example.formallanguage.InfoActivity
import com.example.formallanguage.R
import com.example.formallanguage.VideoActivity


class HomeFragment : Fragment() {

    lateinit var preCard : CardView
    lateinit var regCard : CardView
    lateinit var conCard : CardView
    lateinit var recCard: CardView
    lateinit var quizCard : CardView
    lateinit var infoCard : CardView
lateinit var img:ImageView
lateinit var videoCard: CardView
lateinit var bookCard : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        preCard=view.findViewById(R.id.preCard)
        regCard=view.findViewById(R.id.regCard)
        conCard=view.findViewById(R.id.conCard)
        recCard=view.findViewById(R.id.recCard)
        quizCard=view.findViewById(R.id.quizCard)
        infoCard=view.findViewById(R.id.infoCard)
        img=view.findViewById(R.id.img)
        videoCard=view.findViewById(R.id.videoCard)
        bookCard=view.findViewById(R.id.booksCard)

        val objectAnimator2 = ObjectAnimator.ofFloat(
            img,
            "rotationY",
            0f,
            360f
        )
        objectAnimator2.duration = 3000 // rotate duration in milliseconds
        objectAnimator2.repeatCount = ObjectAnimator.INFINITE // repeat indefinitely

        objectAnimator2.start()



        preCard.setOnClickListener{
            val fragment = preliminariesFragment() // Create an instance of the fragment you want to navigate to
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
            transaction.commit()
        }
        regCard.setOnClickListener{
            val fragment = RegLanFragment() // Create an instance of the fragment you want to navigate to
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
            transaction.commit()
        }
        conCard.setOnClickListener{
            val fragment = ConFrLanFragment() // Create an instance of the fragment you want to navigate to
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
            transaction.commit()
        }
        recCard.setOnClickListener{
            val fragment = RecEnumLanFragment() // Create an instance of the fragment you want to navigate to
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
            transaction.commit()
        }
        infoCard.setOnClickListener{
            val intent = Intent(requireContext(), InfoActivity::class.java)
            startActivity(intent)
        }
        quizCard.setOnClickListener {
            val fragment = QuizFragment() // Create an instance of the fragment you want to navigate to
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
            transaction.commit()
        }
        videoCard.setOnClickListener {
            val intent = Intent(requireContext(), VideoActivity::class.java)
            startActivity(intent)
        }

        bookCard.setOnClickListener{
            val intent = Intent(requireContext(), BookActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}



