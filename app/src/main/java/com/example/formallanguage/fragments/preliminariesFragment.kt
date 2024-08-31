package com.example.formallanguage.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formallanguage.R
import com.example.formallanguage.adapter.PAdapter
import com.example.formallanguage.model.PModel
import java.util.*
import kotlin.collections.ArrayList

class preliminariesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private var itemList = ArrayList<PModel>()
    private lateinit var PAdapter : PAdapter
    private lateinit var adapter: PAdapter



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_preliminaries, container, false)



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
            PModel("Introduction","Automata and formal languages are fundamental concepts in computer science and mathematics. They provide a framework for studying and analyzing the structure, behavior, and patterns of languages and systems.\n" +
                    "\n" +
                    "A formal language is a set of strings composed of symbols from a given alphabet. These languages are defined by formal grammars, which are sets of rules specifying how valid strings in the language can be generated or recognized. Formal languages are used to describe programming languages, communication protocols, natural languages, and more.\n" +
                    "\n" +
                    "Automata, on the other hand, are mathematical models that simulate or represent systems that exhibit certain behaviors. An automaton consists of a set of states and transitions between these states based on inputs or symbols. Automata are used to recognize or generate strings belonging to a particular formal language.\n" +
                    "\n" +
                    "Automata theory explores different types of automata and their capabilities. The most basic type is a finite-state machine (FSM), which has a finite number of states and transitions. FSMs are commonly used to model systems with a fixed number of states, such as vending machines or elevators.\n" +
                    "\n" +
                    "Another type is the pushdown automaton (PDA), which extends the capabilities of FSMs by incorporating a stack. PDAs are useful for recognizing context-free languages, which have more complex structures than regular languages.\n" +
                    "\n" +
                    "Turing machines (TMs) are the most powerful type of automaton. They have an infinite tape as their memory and can perform computations on input strings. TMs are used to study computability and the limits of what can be computed.\n" +
                    "\n" +
                    "The study of automata and formal languages involves analyzing the properties and relationships between different types of automata, understanding the expressiveness and complexity of formal languages, and developing algorithms and techniques for automata-based problem-solving.\n" +
                    "\n" +
                    "Automata and formal languages find applications in various areas, including programming language design, compiler construction, natural language processing, artificial intelligence, and theoretical computer science.\n" +
                    "\n" +
                    "By understanding automata and formal languages, computer scientists and mathematicians can model and analyze systems, design efficient algorithms, and gain insights into the fundamental principles of computation and language theory.")
        )
                    itemList.add(
            PModel("Alphabets, words and languages","Alphabet: An alphabet is a finite set of symbols or characters. In the context of formal languages, an alphabet serves as the basic building block for constructing words or strings. The symbols in an alphabet can be anything—letters, digits, special characters, or even emojis. Common examples of alphabets include {0, 1} for binary strings, {a, b, c} for strings composed of lowercase letters, or {a, b, ..., z} for the English alphabet.\n" +
                    "\n" +
                    "Word/String: In the context of formal languages, a word (also referred to as a string) is a finite sequence of symbols from an alphabet. It is formed by concatenating symbols together. For instance, if we consider the alphabet {0, 1}, some examples of words/strings could be \"0101,\" \"101010,\" or the empty string, denoted as ε. The length of a word is the number of symbols it contains.\n" +
                    "\n" +
                    "Language: A language is a set of words formed from a given alphabet. It represents a collection of strings that follow a particular set of rules. These rules may be defined by a formal grammar or other constraints. Languages can vary in complexity, ranging from simple regular languages to more complex context-free or context-sensitive languages. Languages can be finite, containing a specific number of words, or infinite, containing an infinite number of words.\n" +
                    "\n" +
                    "Finite Language: A finite language is a language that contains a finite number of words. For example, consider the language L = {\"apple,\" \"banana,\" \"cherry\"}. This language is finite as it consists of only three words.\n" +
                    "\n" +
                    "Infinite Language: An infinite language is a language that contains an infinite number of words. For instance, the language L = {0^n1^n | n ≥ 0}, also known as the balanced parentheses language, contains an infinite number of words such as \"01,\" \"0011,\" \"000111,\" and so on.\n" +
                    "\n" +
                    "Languages can be further classified based on their generative mechanisms, such as regular languages, context-free languages, context-sensitive languages, and recursively enumerable languages. Each class of languages has different expressive power and can be recognized by specific types of automata.\n" +
                    "\n" +
                    "The study of alphabets, words, and languages is essential in formal language theory, automata theory, and computational linguistics. It forms the basis for understanding and analyzing the structure, syntax, and semantics of natural and formal languages, as well as designing algorithms and systems that process and manipulate language-based data.")
                    )
        itemList.add (
            PModel("String","In the context of computer science and formal languages, a string (also known as a word) is a finite sequence of symbols or characters chosen from an alphabet. Strings are fundamental objects used to represent and manipulate textual data.\n" +
                    "\n" +
                    "Here are some key characteristics and concepts related to strings:\n" +
                    "\n" +
                    "Alphabet: An alphabet is a finite set of symbols or characters. Strings are composed of symbols selected from an alphabet. For example, an alphabet can be {0, 1} for binary strings or {a, b, ..., z} for strings containing lowercase letters.\n" +
                    "\n" +
                    "Length: The length of a string is the number of symbols it contains. It represents the size or the number of characters in the string. The length of a string is denoted by the function |s|, where s is the string. For example, the length of the string \"hello\" is 5.\n" +
                    "\n" +
                    "Concatenation: Concatenation is the operation of combining two or more strings to create a new string. It is denoted by the symbol '∙' or by simply placing the strings next to each other. For example, if we concatenate the strings \"hello\" and \"world,\" we get the string \"helloworld.\"\n" +
                    "\n" +
                    "Empty String: The empty string, denoted as ε or λ, is a string with no symbols. It has a length of 0 and is often used as a base case or as a placeholder. For example, the string \"apple\" concatenated with the empty string results in \"apple.\"\n" +
                    "\n" +
                    "Substring: A substring is a contiguous sequence of symbols within a string. It is obtained by selecting a range of positions from the original string. For instance, in the string \"hello,\" \"ell\" is a substring.\n" +
                    "\n" +
                    "Operations on Strings: Various operations can be performed on strings, including comparing two strings for equality, finding patterns or substrings within a string, splitting a string into smaller parts, and transforming strings through operations like reversing or replacing characters.\n" +
                    "\n" +
                    "Strings play a crucial role in computer programming, text processing, pattern matching, data serialization, and many other areas. They are the basis for representing and manipulating textual data in programming languages and are extensively used in tasks such as parsing, regular expressions, natural language processing, and data manipulation.\n" +
                    "\n" +
                    "Understanding the properties and operations of strings is fundamental to working with formal languages, automata theory, data structures, and algorithms involving text processing and manipulation.")
                )
        itemList.add (
            PModel("Formal Grammar","A formal grammar, also known as a formal language grammar or simply a grammar, is a set of rules that define the syntax or structure of a formal language. It provides a systematic way to generate or recognize valid strings within a language.\n" +
                    "\n" +
                    "Formal grammars are widely used in computer science, linguistics, and related fields to describe and analyze the syntax of programming languages, natural languages, communication protocols, and more. They are a fundamental tool for studying the structure and properties of formal languages.\n" +
                    "\n" +
                    "Here are the key components and concepts related to formal grammars:\n" +
                    "\n" +
                    "Terminals: Terminals, also known as terminal symbols or terminal alphabets, are the basic symbols or characters that belong to the language. They are the building blocks or atomic elements of the strings. In a programming language grammar, terminals can be keywords, operators, or punctuation marks.\n" +
                    "\n" +
                    "Non-terminals: Non-terminals, also known as non-terminal symbols, are placeholders that represent sets of strings in a language. They serve as variables or placeholders for combinations of terminals and non-terminals. Non-terminals are often represented by uppercase letters.\n" +
                    "\n" +
                    "Productions/Rules: Productions or rules define the syntax of the language by specifying how non-terminals can be expanded or replaced by a combination of terminals and non-terminals. A production consists of a left-hand side (non-terminal) and a right-hand side (sequence of terminals and non-terminals). For example, in a context-free grammar, a rule can be represented as A → XYZ, where A is a non-terminal and XYZ is a sequence of terminals and non-terminals.\n" +
                    "\n" +
                    "Start Symbol: The start symbol is a designated non-terminal that represents the beginning point of generating or recognizing strings in the language. It serves as the starting point for the derivation or parsing process.\n" +
                    "\n" +
                    "Derivation: A derivation is a sequence of grammar rule applications that transform the start symbol into a string of terminals. It involves replacing non-terminals with their corresponding right-hand sides according to the grammar rules. The derivation process generates or recognizes valid strings in the language.\n" +
                    "\n" +
                    "Language Generated by a Grammar: The language generated by a grammar is the set of all valid strings that can be derived from the grammar's start symbol using its productions or rules. It represents the collection of all strings adhering to the grammar's syntax.\n" +
                    "\n" +
                    "Formal grammars are classified into different types based on their expressive power and the form of their production rules. The most commonly studied types are regular grammars, context-free grammars, context-sensitive grammars, and unrestricted grammars. Each type of grammar corresponds to a specific class of formal languages with varying complexity.\n" +
                    "\n" +
                    "The study of formal grammars and their associated languages is a fundamental part of formal language theory, automata theory, and compiler construction. It enables the analysis, design, and implementation of programming languages, parsers, and syntax analysis tools.\n" +
                    "\n" +
                    "Overall, formal grammars provide a precise and systematic way to define and analyze the syntax or structure of formal languages, allowing for the development of grammatically correct and meaningful strings within various domains of study and application.")
        )
        itemList.add (
            PModel("Automaton","An automaton is a mathematical model or abstract machine used to represent and simulate the behavior of a system. Automata theory is a branch of computer science and mathematics that studies these models and their properties.\n" +
                    "\n" +
                    "Automata are widely used in various areas, including computer science, formal language theory, artificial intelligence, and more. They provide a formal and rigorous way to analyze and describe the behavior of systems, ranging from simple machines to complex computational processes.\n" +
                    "\n" +
                    "Here are some key concepts related to automata:\n" +
                    "\n" +
                    "States: An automaton consists of a set of states, which represent the different configurations or conditions of the system. The states capture the information or context of the system at a particular point in time.\n" +
                    "\n" +
                    "Transitions: Transitions define the movement or change of states within the automaton. They are triggered by input symbols or events and specify how the system transitions from one state to another. Transitions can be deterministic, where there is a unique transition for each input symbol, or non-deterministic, where multiple transitions may be possible for a given input symbol.\n" +
                    "\n" +
                    "Inputs: Inputs are the symbols or events that drive the transitions in the automaton. They represent the external stimuli or signals that the system receives and responds to.\n" +
                    "\n" +
                    "Accepting/Rejecting States: In some types of automata, such as finite-state machines (FSMs), certain states are designated as accepting or final states. If the system reaches an accepting state after processing a sequence of inputs, it is said to accept the input. Conversely, if the system ends up in a rejecting state, it rejects the input.\n" +
                    "\n" +
                    "Deterministic vs. Non-deterministic: Automata can be deterministic, where the next state is uniquely determined by the current state and the input symbol, or non-deterministic, where there may be multiple possible transitions for a given state and input symbol. Deterministic automata are often simpler to analyze and implement, while non-deterministic automata provide more expressive power but may require additional computational resources.\n" +
                    "\n" +
                    "Types of Automata: Various types of automata exist, each with its own expressive power and capabilities. Some common types include finite-state machines (FSMs), pushdown automata (PDAs), Turing machines (TMs), and more. Each type of automaton is capable of recognizing or generating a specific class of formal languages.\n" +
                    "\n" +
                    "Automata theory explores the properties, limitations, and relationships between different types of automata and the formal languages they can recognize or generate. It provides insights into the fundamental principles of computation, language theory, and algorithm design.\n" +
                    "\n" +
                    "Automata and formal languages are closely intertwined, as automata are used to recognize or generate strings belonging to formal languages. The theory of automata and formal languages plays a crucial role in the design and analysis of programming languages, compiler construction, pattern recognition, natural language processing, and many other areas of computer science.\n" +
                    "\n" +
                    "By modeling systems as automata, computer scientists can gain a deeper understanding of their behavior, analyze their properties, and design efficient algorithms and systems that operate within well-defined constraints.")
        )
        itemList.add (
            PModel("Deterministic vs. Non-deterministic","Deterministic and non-deterministic are two different modes of behavior exhibited by automata. Let's explore the concepts of deterministic and non-deterministic automata:\n" +
                    "\n" +
                    "Deterministic Automata (DA):\n" +
                    "\n" +
                    "In a deterministic automaton, there is exactly one unique transition for each input symbol from any given state.\n" +
                    "The transition function of a deterministic automaton is defined as a mapping from a state and an input symbol to the next state.\n" +
                    "Given the current state and input symbol, a deterministic automaton always transitions to a specific next state.\n" +
                    "Deterministic automata are often simpler to analyze and implement than their non-deterministic counterparts.\n" +
                    "Finite-State Machines (FSMs) are a common example of deterministic automata.\n" +
                    "Non-deterministic Automata (NA):\n" +
                    "\n" +
                    "In a non-deterministic automaton, there may be multiple possible transitions for a given state and input symbol, or even the possibility of taking an \"epsilon\" or empty transition without consuming an input symbol.\n" +
                    "The transition function of a non-deterministic automaton is defined as a mapping from a state and an input symbol (or epsilon) to a set of possible next states.\n" +
                    "Non-deterministic automata have the flexibility to explore multiple paths simultaneously or make choices at each step based on available options.\n" +
                    "Non-deterministic Finite-State Machines (NFSMs) and Non-deterministic Pushdown Automata (NPDAs) are examples of non-deterministic automata.\n" +
                    "Key differences between deterministic and non-deterministic automata:\n" +
                    "\n" +
                    "Unique vs. Multiple Transitions: Deterministic automata have a single transition for each input symbol, while non-deterministic automata can have multiple possible transitions or epsilon transitions.\n" +
                    "Determinism vs. Choice: Deterministic automata operate based on determinism, where the next state is uniquely determined by the current state and input symbol. Non-deterministic automata have the flexibility to make choices and explore multiple paths simultaneously.\n" +
                    "Simplicity vs. Expressiveness: Deterministic automata are generally simpler to analyze, implement, and simulate. Non-deterministic automata provide more expressive power and flexibility in representing complex behaviors.\n" +
                    "It is worth noting that non-deterministic automata can always be converted into an equivalent deterministic form, although the resulting deterministic automaton may have a larger number of states.\n" +
                    "\n" +
                    "Deterministic and non-deterministic automata play significant roles in formal language theory, automata theory, and computational complexity. They are used to define and analyze languages, solve decision problems, design efficient algorithms, and explore the boundaries of computability.")
        )




        adapter = PAdapter(itemList)
        recyclerView.adapter = adapter



    }












}