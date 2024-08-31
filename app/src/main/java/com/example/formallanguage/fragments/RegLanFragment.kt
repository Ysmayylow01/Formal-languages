package com.example.formallanguage.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.R
import com.example.formallanguage.adapter.PAdapter
import com.example.formallanguage.model.PModel
import java.util.*
import kotlin.collections.ArrayList

class RegLanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private var itemList = ArrayList<PModel>()
    private lateinit var PAdapter : PAdapter
    private lateinit var adapter: PAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_reg_lan, container, false)




        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()




        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }
    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<PModel>()
            for (i in itemList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
                else  {

                }
            }

            if (filteredList.isEmpty()) {
                adapter.setFilteredList(filteredList)


            }
            else {
                adapter.setFilteredList(filteredList)
            }

        }}
    private fun addDataToList() {
        itemList = ArrayList()
        itemList.add(
            PModel("Deterministic Finite Automata (DFA)","Deterministic Finite Automata (DFA) are a type of finite automaton used to recognize and accept or reject strings belonging to a regular language. DFAs are deterministic in the sense that for every input symbol, there is a unique transition to the next state.\n" +
                "\n" +
                "A DFA consists of the following components:\n" +
                "\n" +
                "Set of States (Q):\n" +
                "A finite set of states represents the possible configurations the automaton can be in. Each state is uniquely identified and has a specific meaning or role in the automaton.\n" +
                "\n" +
                "Alphabet (Σ):\n" +
                "An alphabet is a finite set of symbols or input characters that the DFA reads from the input string. These symbols are the valid inputs that the DFA can process.\n" +
                "\n" +
                "Transition Function (δ):\n" +
                "The transition function defines the behavior of the DFA. It specifies the next state based on the current state and the input symbol. For a DFA, the transition function is deterministic, meaning that for each state and input symbol, there is only one possible next state.\n" +
                "\n" +
                "The transition function is defined as follows:\n" +
                "δ: Q × Σ → Q\n" +
                "\n" +
                "Start State (q0):\n" +
                "The start state is the initial state of the DFA. It represents the configuration of the automaton before processing any input symbols. Once the DFA starts, it reads the input string from left to right.\n" +
                "\n" +
                "Set of Accept States (F):\n" +
                "The set of accept states comprises the final or accepting states of the DFA. When the DFA reaches an accept state after processing the entire input string, it signifies that the string belongs to the language recognized by the DFA.\n" +
                "\n" +
                "The formal definition of a DFA is a 5-tuple (Q, Σ, δ, q0, F), where:\n" +
                "\n" +
                "Q is the set of states,\n" +
                "Σ is the input alphabet,\n" +
                "δ is the transition function,\n" +
                "q0 is the start state, and\n" +
                "F is the set of accept states.\n" +
                "To recognize a string using a DFA, you start from the start state and process each input symbol according to the transition function. Once the entire string is processed, if the DFA is in an accept state, the string is accepted; otherwise, it is rejected.\n" +
                "\n" +
                "DFAs are particularly useful for pattern matching, lexical analysis, and simple language recognition tasks. They are easy to implement and have efficient time complexity, making them suitable for many practical applications.")
        )
        itemList.add(
            PModel("NFA with ε-moves","Nondeterministic Finite Automata with ε-moves (also known as ε-NFA or NFAε) are an extension of Nondeterministic Finite Automata (NFA) that allow transitions on empty or epsilon (ε) symbols. These transitions allow the automaton to move from one state to another without consuming any input symbol.\n" +
                "\n" +
                "In addition to the components of an NFA (set of states, alphabet, transition function, start state, and set of accept states), NFAε introduces ε-transitions, which are transitions that occur without reading any input symbol.\n" +
                "\n" +
                "The transition function of an NFAε is defined as follows:\n" +
                "δ: Q × (Σ ∪ {ε}) → 2^Q\n" +
                "\n" +
                "Here, Σ is the input alphabet, and ε represents the empty symbol or no input. The transition function can now take ε as an input symbol and can have multiple next states or remain in the same state for ε-transitions.\n" +
                "\n" +
                "The presence of ε-transitions allows the NFAε to make \"epsilon moves,\" enabling more flexibility in its behavior. The NFAε can take these epsilon moves to explore alternative paths and potentially reach a final state without consuming any input symbols.\n" +
                "\n" +
                "To recognize a string using an NFAε, you start from the start state and process each input symbol according to the transition function. However, when encountering an ε-transition, the NFAε can make an epsilon move to one or more states without consuming any input symbol. This non-determinism allows the NFAε to consider different paths simultaneously.\n" +
                "\n" +
                "Acceptance in an NFAε can be defined differently depending on the specific acceptance criteria. One common approach is called ε-closure. An NFAε accepts a string if there exists a sequence of transitions, including ε-transitions, that lead from the start state to an accept state, consuming all input symbols.\n" +
                "\n" +
                "NFAε is a more expressive model than both NFA and DFA, as it can recognize a broader class of languages. However, it is also more complex to design, simulate, and analyze due to the additional non-determinism introduced by ε-transitions. In practice, NFAε is often converted to an equivalent NFA or DFA using algorithms like ε-NFA to NFA/DFA conversion before implementation.")
        )
        itemList.add(
            PModel("Nondeterministic finite automata (NFA)","Nondeterministic Finite Automata (NFA) are a type of finite automaton that can have multiple possible transitions for a given input symbol and current state. Unlike deterministic finite automata (DFA), NFAs allow for nondeterministic behavior, meaning that they can have multiple paths to follow at each step.\n" +
                "\n" +
                "An NFA consists of the following components:\n" +
                "\n" +
                "Set of States (Q):\n" +
                "Similar to DFAs, the set of states represents the possible configurations the automaton can be in. Each state is uniquely identified and has a specific meaning or role in the automaton.\n" +
                "\n" +
                "Alphabet (Σ):\n" +
                "The alphabet is a finite set of symbols or input characters that the NFA reads from the input string. These symbols are the valid inputs that the NFA can process.\n" +
                "\n" +
                "Transition Function (δ):\n" +
                "The transition function defines the behavior of the NFA. It specifies the set of possible next states based on the current state and the input symbol. Unlike DFAs, which have a unique next state for each combination of current state and input symbol, NFAs can have multiple next states for a given combination.\n" +
                "\n" +
                "The transition function is defined as follows:\n" +
                "δ: Q × Σ → 2^Q\n" +
                "\n" +
                "Here, 2^Q represents the power set of Q, which is the set of all possible subsets of Q. This allows for multiple next states to be represented as a set of states.\n" +
                "\n" +
                "Start State (q0):\n" +
                "The start state is the initial state of the NFA, representing the configuration of the automaton before processing any input symbols.\n" +
                "\n" +
                "Set of Accept States (F):\n" +
                "The set of accept states comprises the final or accepting states of the NFA. When the NFA reaches an accept state after processing the entire input string, it signifies that the string belongs to the language recognized by the NFA.\n" +
                "\n" +
                "The formal definition of an NFA is a 5-tuple (Q, Σ, δ, q0, F), where:\n" +
                "\n" +
                "Q is the set of states,\n" +
                "Σ is the input alphabet,\n" +
                "δ is the transition function,\n" +
                "q0 is the start state, and\n" +
                "F is the set of accept states.\n" +
                "To recognize a string using an NFA, you start from the start state and process each input symbol according to the transition function. At each step, the NFA can follow multiple paths simultaneously, leading to different combinations of states. If there is at least one path that reaches an accept state after processing the entire input string, the string is accepted.\n" +
                "\n" +
                "NFAs are more expressive than DFAs and can recognize a broader class of languages. However, they are also more complex to design and analyze. In practice, NFAs are often converted to DFAs through a process called NFA to DFA conversion to facilitate implementation and improve efficiency.")
        )
        itemList.add(
            PModel("Regular expressions","Regular expressions are powerful patterns used for matching and manipulating strings. They provide a concise and flexible syntax to describe specific patterns of characters within text. Regular expressions are widely used in various programming languages, text editors, and command-line tools.\n" +
                "\n" +
                "Here are some common elements and syntax used in regular expressions:\n" +
                "\n" +
                "Literal Characters:\n" +
                "Literal characters represent themselves and match exactly the same characters in the input string. For example, the regular expression \"abc\" matches the exact sequence \"abc\" in the input string.\n" +
                "\n" +
                "Metacharacters:\n" +
                "Metacharacters have special meanings in regular expressions. Some commonly used metacharacters include:\n" +
                "\n" +
                "Dot (.) matches any single character except a newline.\n" +
                "Asterisk (*) matches zero or more occurrences of the preceding element.\n" +
                "Plus sign (+) matches one or more occurrences of the preceding element.\n" +
                "Question mark (?) matches zero or one occurrence of the preceding element.\n" +
                "Square brackets ([ ]) define a character class, matching any single character within the brackets.\n" +
                "Vertical bar (|) denotes alternation, matching either the expression before or after it.\n" +
                "Character Classes:\n" +
                "Character classes allow you to define sets of characters to match. Some examples:\n" +
                "\n" +
                "[0-9] matches any digit from 0 to 9.\n" +
                "[a-zA-Z] matches any uppercase or lowercase letter.\n" +
                "[^abc] matches any character except a, b, or c.\n" +
                "Anchors:\n" +
                "Anchors are used to specify the position of a match within the input string. Some common anchors include:\n" +
                "\n" +
                "Caret (^) matches the start of a line or string.\n" +
                "Dollar sign (\$) matches the end of a line or string.\n" +
                "Word boundaries (\\b) match the position between a word character and a non-word character.\n" +
                "Quantifiers:\n" +
                "Quantifiers specify the number of occurrences of a preceding element to match. Some examples:\n" +
                "\n" +
                "{n} matches exactly n occurrences of the preceding element.\n" +
                "{n,} matches at least n occurrences of the preceding element.\n" +
                "{n,m} matches at least n and at most m occurrences of the preceding element.\n" +
                "Regular expressions provide a powerful and flexible way to search, match, and manipulate strings based on specific patterns. They are commonly used for tasks such as input validation, text parsing, data extraction, and text substitution. Each programming language or tool may have slight variations in syntax and available features for regular expressions, so it's important to consult the documentation of the specific tool or language you are using.")
        )
        itemList.add(
            PModel("The pumping lemma","The pumping lemma is a fundamental theorem in formal language theory that provides a tool for proving that a language is not regular. It establishes a condition that any regular language must satisfy, and by demonstrating a violation of that condition, we can conclude that a language is not regular.\n" +
                "\n" +
                "The pumping lemma for regular languages states the following:\n" +
                "\n" +
                "For any regular language L, there exists a pumping length p (a positive integer) such that for any string w in L with |w| ≥ p, we can decompose w into three parts, w = xyz, satisfying the following conditions:\n" +
                "\n" +
                "|xy| ≤ p: The length of xy (the first two parts) is less than or equal to the pumping length p.\n" +
                "|y| > 0: The length of y (the second part) is greater than zero.\n" +
                "For all non-negative integers i, the string xyiz is also in L: Pumping (repeating) y any number of times, including zero, should result in a string that is still in the language L.\n" +
                "In simpler terms, the pumping lemma states that for any regular language, there exists a pumping length such that any sufficiently long string in the language can be \"pumped\" or repeated in a way that the resulting string remains in the language.\n" +
                "\n" +
                "To prove that a language is not regular using the pumping lemma, we need to show that at least one of the conditions above is violated for all possible decompositions of strings of sufficient length.\n" +
                "\n" +
                "The pumping lemma is a valuable tool for demonstrating the non-regularity of languages, but it does not prove the regularity of a language. It only provides a way to prove that a language is not regular when the conditions of the lemma are violated. Other techniques, such as closure properties or constructing a finite automaton, are used to prove that a language is regular.")
        )
        itemList.add(
            PModel("Closure properties","Closure properties in formal language theory refer to the properties that certain operations or transformations have on languages within a specific class. These properties describe how languages are preserved or transformed when subjected to various operations.\n" +
                "\n" +
                "The closure properties are typically discussed in the context of different classes of languages, such as regular languages, context-free languages, and recursively enumerable languages. Here are some common closure properties associated with each class:\n" +
                "\n" +
                "Regular Languages:\n" +
                "Regular languages are closed under the following operations:\n" +
                "\n" +
                "Union: If L1 and L2 are regular languages, their union L1 ∪ L2 is also a regular language.\n" +
                "Concatenation: If L1 and L2 are regular languages, their concatenation L1L2 is also a regular language.\n" +
                "Kleene Star: If L is a regular language, its Kleene star L* (including the empty string) is also a regular language.\n" +
                "Complementation: The complement of a regular language is also regular.\n" +
                "Context-Free Languages:\n" +
                "Context-free languages are closed under the following operations:\n" +
                "\n" +
                "Union: If L1 and L2 are context-free languages, their union L1 ∪ L2 is also a context-free language.\n" +
                "Concatenation: If L1 and L2 are context-free languages, their concatenation L1L2 is also a context-free language.\n" +
                "Kleene Star: If L is a context-free language, its Kleene star L* (including the empty string) is also a context-free language.\n" +
                "Recursively Enumerable Languages:\n" +
                "Recursively enumerable languages (also known as recursively enumerable sets) are closed under the following operations:\n" +
                "\n" +
                "Union: If L1 and L2 are recursively enumerable languages, their union L1 ∪ L2 is also a recursively enumerable language.\n" +
                "Intersection: If L1 and L2 are recursively enumerable languages, their intersection L1 ∩ L2 is also a recursively enumerable language.\n" +
                "Concatenation: If L1 and L2 are recursively enumerable languages, their concatenation L1L2 is also a recursively enumerable language.\n" +
                "It's worth noting that some operations may not preserve closure properties across all classes. For example, the intersection of two context-free languages may not be context-free. Additionally, closure properties may differ depending on the class of languages under consideration.\n" +
                "\n" +
                "Closure properties are essential in formal language theory as they provide insight into the relationships between different classes of languages and help in proving certain language properties or in designing algorithms for language manipulation and analysis.")
        )
        itemList.add(
            PModel(" Decision algorithms","Decision algorithms, also known as decision procedures or decision algorithms, are algorithms that determine whether a given input satisfies a specific property or condition. These algorithms are designed to make a binary decision, typically answering \"yes\" or \"no\" to a particular question or problem.\n" +
                "\n" +
                "Decision algorithms are used in various fields, including computer science, mathematics, logic, and artificial intelligence. They play a fundamental role in solving problems related to language recognition, graph theory, optimization, satisfiability, and more. The efficiency and correctness of decision algorithms are crucial considerations in practice.\n" +
                "\n" +
                "Here are a few examples of decision algorithms:\n" +
                "\n" +
                "Membership Decision:\n" +
                "Given a set or a language L and an input x, a membership decision algorithm determines whether x belongs to L or not. For example, in regular languages, a decision algorithm can determine if a given string is part of the language recognized by a finite automaton.\n" +
                "\n" +
                "Equivalence Decision:\n" +
                "Given two structures or objects, an equivalence decision algorithm determines whether they are equivalent or not with respect to a specific property. For example, in graph theory, an equivalence decision algorithm can determine if two graphs are isomorphic.\n" +
                "\n" +
                "Satisfiability Decision:\n" +
                "In propositional logic or boolean satisfiability (SAT) problems, a satisfiability decision algorithm determines whether a given logical formula can be satisfied by assigning truth values to its variables. It checks if there exists an assignment that makes the formula evaluate to true.\n" +
                "\n" +
                "Feasibility Decision:\n" +
                "In optimization problems, a feasibility decision algorithm determines whether a feasible solution exists for a given set of constraints. It checks if there is a solution that satisfies all the problem's constraints.\n" +
                "\n" +
                "Consistency Decision:\n" +
                "In formal systems or theories, a consistency decision algorithm determines whether a given set of axioms or logical statements is consistent. It checks if there is no contradiction among the statements.\n" +
                "\n" +
                "The design and analysis of decision algorithms involve considerations such as time complexity, space complexity, correctness, and optimality. Different algorithms may have different trade-offs in terms of efficiency and resources required. Determining the existence and efficiency of decision algorithms is an active area of research in theoretical computer science and mathematics, leading to advancements in solving complex decision problems.")
        )
        itemList.add(
            PModel("Myhill-Nerode theorem","The Myhill-Nerode theorem is a fundamental result in formal language theory that provides a necessary and sufficient condition for a language to be regular. It establishes a connection between the behavior of strings in a language and the number of distinct states required in a minimal deterministic finite automaton (DFA) recognizing that language.\n" +
                "\n" +
                "The theorem is based on the concept of equivalence classes defined by a language. Let's define an equivalence relation ≡L on strings over an alphabet Σ as follows: For two strings x and y, x ≡L y if and only if, for every string z, either all three of the strings xz, yz are in the language L or none of them are.\n" +
                "\n" +
                "The Myhill-Nerode theorem states that a language L over Σ is regular if and only if the number of distinct equivalence classes under the relation ≡L is finite.\n" +
                "\n" +
                "In other words, if the language L has a finite number of equivalence classes, then there exists a minimal DFA with that same number of states that recognizes the language. Conversely, if the language L has an infinite number of equivalence classes, then no DFA with a finite number of states can recognize the language.\n" +
                "\n" +
                "The theorem provides a powerful tool for proving non-regularity of languages by showing an infinite number of equivalence classes. By considering the behavior of strings and finding an infinite number of distinguishable states, we can conclude that the language is not regular.\n" +
                "\n" +
                "The Myhill-Nerode theorem is an essential result in formal language theory and provides insights into the structure and complexity of regular languages. It is used to characterize the regular languages and to prove the non-regularity of languages by establishing an infinite number of equivalence classes.")
        )


        adapter = PAdapter(itemList)
        recyclerView.adapter = adapter



    }












}