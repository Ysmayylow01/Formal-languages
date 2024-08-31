package com.example.formallanguage.fragments


import android.annotation.SuppressLint
import android.content.DialogInterface
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.formallanguage.R
import com.example.formallanguage.model.SoragModel
import kotlinx.coroutines.NonCancellable.cancel


class QuizFragment : Fragment() {

    private lateinit var soragList: ArrayList<SoragModel>
    private var index: Int = 0
    private lateinit var soragModel: SoragModel

    private var dogryJogapCount: Int = 0
    private var yalnysJogapCount: Int = 0


    private lateinit var gosmak: TextView
    private lateinit var sorag: TextView
    private lateinit var jogap_A: Button
    private lateinit var jogap_B: Button
    private lateinit var jogap_C: Button
    private lateinit var jogap_D: Button
    private lateinit var dowam: Button


    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        gosmak = view.findViewById(R.id.gosmak)
        sorag = view.findViewById(R.id.sorag)
        jogap_A = view.findViewById(R.id.jogap_A)
        jogap_B = view.findViewById(R.id.jogap_B)
        jogap_C = view.findViewById(R.id.jogap_C)
        jogap_D = view.findViewById(R.id.jogap_D)
        dowam = view.findViewById(R.id.Dowam)



        soragList = ArrayList()
        soragList.add(
            SoragModel(
                "Which of the following is NOT a type of automaton?",
                "Deterministic Finite Automaton (DFA)", " Non-deterministic Finite Automaton (NFA)",
                " Pushdown Automaton (PDA)", "Turing Machine (TM)", "Turing Machine (TM)"
            )
        )
        soragList.add(
            SoragModel(
                "What is the primary purpose of a regular expression?",
                "To describe the behavior of a Turing Machine", "To define the structure of a context-free grammar", "To represent a regular language", "To implement an automaton", "To represent a regular language"
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following formal languages is NOT considered a regular language?",
                "{0^n1^n | n ≥ 0}", "{ww^R | w is a string over {0, 1}*}",
                "{a^n | n is a prime number}", "{a^n | n ≥ 0}", "{ww^R | w is a string over {0, 1}*}"
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a characteristic of a context-free language?",
                "It can be recognized by a deterministic finite automaton.", "It can be recognized by a regular expression.",
                " It can be recognized by a pushdown automaton.", "It can be recognized by a Turing machine.", "It can be recognized by a pushdown automaton"
            )
        )

        soragList.add(
            SoragModel(
                "What is the purpose of the Chomsky hierarchy in formal language theory?",
                "To classify formal languages into different levels of complexity.", "To provide a framework for designing efficient algorithms.",
                "To determine the decidability of a language.", "To define the behavior of a Turing machine.", "To classify formal languages into different levels of complexity."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is true regarding the pumping lemma for regular languages?",
                "It can be used to prove that a language is regular.", " It can be used to prove that a language is context-free.",
                "It can be used to prove that a language is context-sensitive.", " It can be used to prove that a language is recursively enumerable.", "It can be used to prove that a language is regular."
            )
        )
        soragList.add(
            SoragModel(
                "What is the primary difference between a deterministic finite automaton (DFA) and a non-deterministic finite automaton (NFA)?",
                "DFAs can recognize more languages than NFAs.", "NFAs can recognize more languages than DFAs.",
                "DFAs can recognize context-free languages, while NFAs cannot.", "NFAs can recognize context-free languages, while DFAs cannot.", "NFAs can recognize more languages than DFAs."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a characteristic of a context-sensitive language?",
                "It can be recognized by a pushdown automaton with multiple stacks.", "It can be recognized by a deterministic finite automaton.",
                "It can be recognized by a Turing machine with a bounded tape.", "It can be recognized by a Turing machine with a doubly infinite tape.", "It can be recognized by a Turing machine with a bounded tape."
            )
        )
        soragList.add(
            SoragModel(
                "What is the purpose of the pumping lemma for context-free languages?",
                "It can be used to prove that a language is context-free.", "It can be used to prove that a language is regular.",
                "It can be used to prove that a language is recursively enumerable.", "It can be used to prove that a language is context-sensitive.", "It can be used to prove that a language is context-free."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a characteristic of a recursively enumerable language?",
                "It can be recognized by a pushdown automaton.", "It can be recognized by a deterministic finite automaton.",
                "It can be recognized by a Turing machine that halts on all inputs.", "It can be recognized by a Turing machine that may not halt on all inputs.", "It can be recognized by a Turing machine that may not halt on all inputs."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is true regarding the halting problem?",
                "It can be solved by a Turing machine.", " It is undecidable for Turing machines.",
                "It can be solved by a pushdown automaton.", "It is decidable for regular languages.", "It is undecidable for Turing machines."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a characteristic of a recursively enumerable language?",
                "It is closed under complementation.", "It can be recognized by a deterministic finite automaton.",
                "It is always regular.", "Its complement is recursively enumerable.", "Its complement is recursively enumerable."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a property of a regular language?",
                "It can be infinite.", "It can be non-context-free.",
                "It can be recognized by a Turing machine.", "Its complement is always regular.", "It can be infinite."
            )
        )
        soragList.add(
            SoragModel(
                "What is the main purpose of the Myhill-Nerode theorem?",
                "To prove the closure properties of regular languages.", "To determine whether a language is context-free or not.",
                "To construct minimal automata for regular languages.", "To define the pumping lemma for context-free languages.", "To construct minimal automata for regular languages."
            )
        )
        soragList.add(
            SoragModel(
                "Which of the following is a characteristic of a context-free language?",
                "It can be recognized by a linear-bounded automaton.", "It can be recognized by a deterministic finite automaton.",
                "It is closed under complementation.", "Its complement is always context-free.", "It can be recognized by a linear-bounded automaton."
            )
        )



        soragList.shuffle()
        soragModel = soragList[index]

        setAllQuestions()
        onFinish()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dowam.setOnClickListener {
            disableButton()
            onFinish()
        }

        jogap_A.setOnClickListener {
            disableButton()
            if (soragModel.jogap_A == soragModel.jogap) {
                jogap_A.background = resources.getDrawable(R.drawable.correct_option_border_bg)
                dogryJogap(jogap_A)
            } else {
                yalnysJogap(jogap_A)
            }
        }

        jogap_B.setOnClickListener {
            disableButton()
            if (soragModel.jogap_B == soragModel.jogap) {
                jogap_B.background = resources.getDrawable(R.drawable.correct_option_border_bg)
                dogryJogap(jogap_B)
            } else {
                yalnysJogap(jogap_B)
            }
        }

        jogap_C.setOnClickListener {
            disableButton()
            if (soragModel.jogap_C == soragModel.jogap) {
                jogap_C.background = resources.getDrawable(R.drawable.correct_option_border_bg)
                dogryJogap(jogap_C)
            } else {
                yalnysJogap(jogap_C)
            }
        }

        jogap_D.setOnClickListener {
            disableButton()
            if (soragModel.jogap_D == soragModel.jogap) {
                jogap_D.background = resources.getDrawable(R.drawable.correct_option_border_bg)
                dogryJogap(jogap_D)
            } else {
                yalnysJogap(jogap_D)
            }
        }
    }

    private fun disableButton() {
        jogap_A.isClickable = false
        jogap_B.isClickable = false
        jogap_C.isClickable = false
        jogap_D.isClickable = false
        dowam.isClickable = true
    }

    private fun onFinish() {
        index++
        if (index < 11) {
            soragModel = soragList[index]
            gosmak.text = index.toString()
            resetBackground()
            enableButton()
            setAllQuestions()
        } else {
            oyunNetije()
        }
    }

    private fun setAllQuestions() {
        sorag.text = soragModel.sorag
        jogap_A.text = soragModel.jogap_A
        jogap_B.text = soragModel.jogap_B
        jogap_C.text = soragModel.jogap_C
        jogap_D.text = soragModel.jogap_D
    }

    private fun enableButton() {
        jogap_A.isClickable = true
        jogap_B.isClickable = true
        jogap_C.isClickable = true
        jogap_D.isClickable = true
        dowam.isClickable = false
    }

    private fun resetBackground() {
        jogap_A.background = resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_B.background = resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_C.background = resources.getDrawable(R.drawable.selected_option_border_bg)
        jogap_D.background = resources.getDrawable(R.drawable.selected_option_border_bg)
    }

    private fun dogryJogap(option: Button) {
        option.background = resources.getDrawable(R.drawable.correct_option_border_bg)
        dogryJogapCount++
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.dogryy)
        mediaPlayer.start()
    }
    private fun yalnysJogap(option: Button) {
        option.background = resources.getDrawable(R.drawable.wrong_option_border_bg)
        yalnysJogapCount++

        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.yalnys)
        mediaPlayer.start()
    }

    private fun oyunNetije() {
        val pastStatus: String = if (dogryJogapCount == 10) {
            "Excellent"
        } else if (dogryJogapCount > 10 * 0.50) {
            "Good"
        } else {
            "Low"
        }

        val builder = AlertDialog.Builder(requireContext())
            .setTitle(pastStatus)
            .setMessage("You answered question $dogryJogapCount correctly out of 10.You answered question  $yalnysJogapCount incorrectly")
            builder.setPositiveButton("Restart quiz") { dialogInterface: DialogInterface?, i: Int ->
                tazedenBasla()
            }

           .show()
    }



    private fun tazedenBasla() {
        dogryJogapCount = 0
        index = 0
        yalnysJogapCount = 0

        soragList.shuffle()
        soragModel = soragList[index]

        setAllQuestions()
        onFinish()
    }




}