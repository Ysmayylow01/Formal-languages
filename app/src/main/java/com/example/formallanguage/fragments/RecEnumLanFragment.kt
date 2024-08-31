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

class RecEnumLanFragment : Fragment() {
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
       val view=inflater.inflate(R.layout.fragment_rec_enum_lan, container, false)



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
            PModel("Turing machines","Turing machines are theoretical computational devices introduced by Alan Turing in the 1930s. They are one of the fundamental models of computation and play a crucial role in the field of theoretical computer science. Turing machines provide a formal and abstract framework for understanding the limits and capabilities of computation. Here are some key aspects of Turing machines:\n" +
                    "\n" +
                    "Structure: A Turing machine consists of an infinite tape divided into cells, each capable of holding a symbol. The tape serves as the input, working space, and output of the machine. The machine has a read-write head that can move left or right along the tape, reading and writing symbols on the cells.\n" +
                    "\n" +
                    "States and Transitions: A Turing machine operates in discrete steps. At each step, it reads the symbol on the current tape cell, consults its internal state, and performs a transition based on the current state and the read symbol. The transition specifies the new state, the symbol to write on the tape, and the direction for the head to move (left or right).\n" +
                    "\n" +
                    "Deterministic and Non-deterministic Turing Machines: Turing machines can be either deterministic or non-deterministic. Deterministic Turing machines have a unique transition for each combination of state and input symbol, while non-deterministic Turing machines may have multiple possible transitions. Non-deterministic Turing machines provide a theoretical model of parallel computation.\n" +
                    "\n" +
                    "Computation and Acceptance: A Turing machine starts in an initial state and follows a sequence of transitions based on the input symbols until it reaches a halting state. The machine may accept or reject the input based on the final state it reaches. Acceptance criteria vary depending on the context, such as accepting if the final state is an accepting state or accepting if the machine halts.\n" +
                    "\n" +
                    "Universal Turing Machines: A universal Turing machine is a special Turing machine that can simulate any other Turing machine given its description as input. Universal Turing machines play a significant role in the study of computability and complexity theory, as they demonstrate that a single machine can emulate any other machine.\n" +
                    "\n" +
                    "Church-Turing Thesis: The Church-Turing thesis states that any function that can be effectively computed by an algorithm can be computed by a Turing machine. It forms the foundation of computability theory and asserts that Turing machines capture the essence of what can be computed.\n" +
                    "\n" +
                    "Turing machines are used as a theoretical tool to study the limits of computation, computability theory, and the classification of problems based on their solvability. They serve as a benchmark for evaluating the computational complexity of algorithms and the decidability of languages. Turing machines are also employed as a theoretical foundation for programming languages, compilers, and formal language theory.")
        )
        itemList.add(
            PModel(" Programming techniques for Turing machines","Turing machines are abstract theoretical models of computation rather than practical programming platforms. Nevertheless, there are programming techniques and approaches that can be used to simulate and work with Turing machines. Here are some techniques that can be applied when working with Turing machines:\n" +
                    "\n" +
                    "Transition Table: One way to program a Turing machine is to define a transition table that specifies the machine's behavior. The table lists the current state, the symbol being read, the action to take (write a symbol, move the head left or right), and the next state. This table serves as a program that guides the machine's behavior.\n" +
                    "\n" +
                    "Turing Machine Simulator: You can implement a Turing machine simulator in a programming language of your choice. The simulator takes as input the transition table and an initial tape configuration. It executes the transitions based on the current state and the symbol being read, updates the tape, and moves the head accordingly. The simulator can handle step-by-step execution or run until a halting state is reached.\n" +
                    "\n" +
                    "High-Level Language: You can use a high-level programming language to write code that emulates the behavior of a Turing machine. This involves defining data structures to represent the tape, implementing functions or methods that perform the transition logic based on the current state and symbol, and simulating the movement of the head. This approach provides more flexibility and readability compared to directly working with transition tables.\n" +
                    "\n" +
                    "Turing-Complete Languages: Many modern programming languages are Turing-complete, meaning they have the computational power equivalent to a Turing machine. You can utilize such languages to solve problems that can be modeled as Turing machines. In this case, you would write programs in the chosen language using loops, conditionals, and data structures to simulate the behavior of a Turing machine.\n" +
                    "\n" +
                    "Turing Machine Libraries: Some programming languages or libraries provide built-in support for simulating Turing machines. These libraries may provide convenient interfaces and functions for defining transition tables, executing Turing machines, and visualizing the computation process. Utilizing such libraries can simplify the process of working with Turing machines.\n" +
                    "\n" +
                    "It's important to note that programming techniques for Turing machines are primarily aimed at understanding and exploring the theoretical aspects of computation. Turing machines are not typically used for practical programming tasks, but rather serve as a theoretical foundation for understanding the limits of computation, studying formal language theory, and analyzing the solvability of problems.")
        )
        itemList.add(
            PModel("Modifications of Turing machines","Turing machines are highly flexible and can be modified in various ways to explore different computational models and problem-solving capabilities. Here are some common modifications of Turing machines:\n" +
                    "\n" +
                    "Multi-Tape Turing Machines: In a standard Turing machine, there is a single tape. However, multi-tape Turing machines have multiple tapes, each with its own read-write head. This modification allows for parallel processing and can simplify certain computations that would be complex on a single-tape machine. Multi-tape Turing machines are equivalent in computational power to standard Turing machines, but they can provide efficiency gains for specific tasks.\n" +
                    "\n" +
                    "Non-Deterministic Turing Machines: Non-deterministic Turing machines (NTMs) are theoretical machines that allow for multiple possible transitions from a given state and symbol. Unlike deterministic Turing machines that have a unique next move, NTMs can branch out into different paths simultaneously. Non-determinism is useful for exploring alternative computational possibilities, studying complexity theory, and understanding the power of parallelism.\n" +
                    "\n" +
                    "Oracle Turing Machines: Oracle Turing machines incorporate an \"oracle\" component, which is an external device or subroutine that provides solutions to specific computational problems. The oracle is treated as a black box that can provide answers to queries without revealing the underlying algorithm. Oracle Turing machines are useful for studying the complexity and feasibility of solving specific problems with specialized algorithms or procedures.\n" +
                    "\n" +
                    "Bounded Turing Machines: Bounded Turing machines restrict the amount of tape that can be used during computation. Instead of having an infinite tape, the tape is limited to a fixed size or bounded by a specific function of the input length. Bounded Turing machines are used to analyze the complexity of problems under resource constraints, such as time and space complexity.\n" +
                    "\n" +
                    "Alternating Turing Machines: Alternating Turing machines combine elements of both non-determinism and determinism. They have multiple tapes and read-write heads, allowing for both existential and universal choices at each step. Alternating Turing machines are used in computational complexity theory to study complexity classes like PSPACE and the polynomial hierarchy.\n" +
                    "\n" +
                    "Probabilistic Turing Machines: Probabilistic Turing machines introduce probabilistic choices during computation. Instead of deterministic transitions, probabilistic Turing machines use randomization to determine the next move. They assign probabilities to different transitions and can model situations where randomness or uncertainty plays a role in computation. Probabilistic Turing machines are fundamental to the study of probabilistic algorithms and complexity classes like BPP (bounded-error probabilistic polynomial time).\n" +
                    "\n" +
                    "These modifications demonstrate the versatility of Turing machines as a theoretical framework for exploring different computational models and studying the properties of algorithms and languages. They help researchers investigate the limits and capabilities of computation under various scenarios and shed light on the relationships between different computational classes and problem-solving techniques.")
        )
        itemList.add(
            PModel("Closure properties","Closure properties, in the context of formal languages, refer to the properties of languages that are preserved under certain operations or transformations. These properties describe how languages behave when subjected to various operations or manipulations. Here are some important closure properties of formal languages:\n" +
                    "\n" +
                    "Union: The union of two languages L1 and L2, denoted by L1 ∪ L2, is the language that contains all the strings that belong to either L1 or L2. The union of two languages is also a language. Formally, if L1 and L2 are languages over an alphabet Σ, then L1 ∪ L2 is also a language over Σ.\n" +
                    "\n" +
                    "Concatenation: The concatenation of two languages L1 and L2, denoted by L1L2, is the language that contains all possible concatenations of strings from L1 and L2. Formally, if L1 and L2 are languages over an alphabet Σ, then L1L2 is also a language over Σ.\n" +
                    "\n" +
                    "Kleene Star: The Kleene star of a language L, denoted by L*, is the language that contains all possible concatenations of zero or more strings from L. It includes the empty string ε as well. Formally, if L is a language over an alphabet Σ, then L* is also a language over Σ.\n" +
                    "\n" +
                    "Intersection: The intersection of two languages L1 and L2, denoted by L1 ∩ L2, is the language that contains all the strings that belong to both L1 and L2. The intersection of two languages is also a language. Formally, if L1 and L2 are languages over an alphabet Σ, then L1 ∩ L2 is also a language over Σ.\n" +
                    "\n" +
                    "Complement: The complement of a language L, denoted by L', is the language that contains all the strings over the alphabet Σ that do not belong to L. The complement of a language is also a language. Formally, if L is a language over an alphabet Σ, then L' is also a language over Σ.\n" +
                    "\n" +
                    "Reversal: The reversal of a language L, denoted by L^R, is the language that contains all the reversed strings of L. If L is a language over an alphabet Σ, then L^R is also a language over Σ.\n" +
                    "\n" +
                    "Homomorphism: A homomorphism is a mapping from one language to another that replaces each symbol in the original language with a string. If L1 is a language over an alphabet Σ and h is a homomorphism, then h(L1) is also a language over the image alphabet of h.\n" +
                    "\n" +
                    "These closure properties allow us to manipulate and combine languages to create new languages. The closure properties are important in formal language theory as they provide a way to reason about languages and their relationships, as well as algorithms for language recognition and generation.")
        )
        itemList.add(
            PModel("Decision problems and Turing machines","Decision problems are computational problems that can be formulated as questions with a \"yes\" or \"no\" answer. These problems ask whether a given input satisfies a certain property or belongs to a specific language. Turing machines, on the other hand, are abstract computational devices that can be used to solve decision problems. Here's how Turing machines and decision problems are related:\n" +
                    "\n" +
                    "Turing Machines as Solvers: Turing machines can be used to solve decision problems by accepting or rejecting inputs based on their properties. A Turing machine takes an input string and processes it according to its transition rules until it reaches a halting state. If the Turing machine halts in an accepting state, the answer to the decision problem is \"yes\" for that input. If it halts in a rejecting state or loops indefinitely, the answer is \"no\".\n" +
                    "\n" +
                    "Encoding Decision Problems: Decision problems can be encoded as languages over an alphabet. For example, a decision problem may be represented as a language of binary strings where \"yes\" instances are encoded as strings in the language, and \"no\" instances are not. Turing machines can then be used to recognize or decide membership in these languages. If a Turing machine accepts a string, it implies that the string is a \"yes\" instance of the decision problem.\n" +
                    "\n" +
                    "Language Recognition: Turing machines can recognize languages, including decision languages. A Turing machine that recognizes a language halts and accepts any input string that belongs to the language and either rejects or loops indefinitely for strings not in the language. By constructing a Turing machine that recognizes a decision language, we can effectively solve the corresponding decision problem.\n" +
                    "\n" +
                    "Complexity Analysis: Turing machines provide a framework for analyzing the complexity of decision problems. Complexity classes, such as P (problems solvable in polynomial time) and NP (nondeterministic polynomial time), are defined based on the behavior of Turing machines. By studying the resources (time and space) required by Turing machines to solve decision problems, we gain insights into their computational difficulty and the relationships between different problem classes.\n" +
                    "\n" +
                    "Turing machines serve as a theoretical foundation for studying decision problems and computability. They help us understand the capabilities and limitations of computational models and provide a basis for analyzing the complexity of algorithms and problems. By using Turing machines, we can formalize decision problems, reason about their solvability, and explore the boundaries of computation.")
        )
        itemList.add(
            PModel("Universal Turing machines","A Universal Turing machine (UTM) is a special type of Turing machine that can simulate any other Turing machine. It is a theoretical concept introduced by Alan Turing in 1936 as part of his work on computability and the foundations of computer science. The concept of a Universal Turing machine forms the basis of the Church-Turing thesis, which states that any function that can be effectively computed can be computed by a Turing machine.\n" +
                    "\n" +
                    "A Universal Turing machine consists of two main components:\n" +
                    "\n" +
                    "Control Mechanism: The control mechanism of a Universal Turing machine is responsible for interpreting the instructions of the machine being simulated. It reads the current state of the machine being simulated and the symbol being read on its tape, and it determines the appropriate action to take based on a predefined set of rules. These rules, known as the universal control table or the universal program, define how the UTM should behave to simulate any other Turing machine.\n" +
                    "\n" +
                    "Tape: The tape of the Universal Turing machine serves as the working space and holds the input for both the UTM and the Turing machine being simulated. It is initially loaded with the description of the Turing machine being simulated, along with the input for that machine. The UTM uses its control mechanism to simulate the transitions of the Turing machine being simulated on the tape.\n" +
                    "\n" +
                    "The key idea behind a Universal Turing machine is that it can simulate the behavior of any other Turing machine by interpreting its instructions and updating its tape accordingly. This means that a single Universal Turing machine can effectively perform any computation that any other Turing machine can perform. It achieves this by encoding the instructions and symbols of the simulated Turing machine on its tape and following the rules defined in its universal control table.\n" +
                    "\n" +
                    "Universal Turing machines have played a fundamental role in the development of computer science and the theory of computation. They provide a theoretical basis for the notion of programmability and the concept of a general-purpose computer. The existence of a Universal Turing machine supports the idea that a single machine can perform any computation that can be carried out by a computer, given the appropriate program or instructions.\n" +
                    "\n" +
                    "Although Universal Turing machines are not practical physical devices, they serve as an important theoretical construct for understanding the limits and capabilities of computation. They have influenced the design of real-world computers and programming languages and continue to be a key concept in the study of computability and computational complexity.")
        )
        itemList.add(
                PModel("Rice’s theorem","Rice's theorem, named after mathematician Henry Gordon Rice, is a fundamental result in computability theory that establishes a limitation on the decidability of certain properties of Turing machines or other computational models. The theorem states that for any non-trivial property of the behavior of a Turing machine, it is undecidable to determine whether a given Turing machine (or its language) possesses that property.\n" +
                        "\n" +
                        "Formally, Rice's theorem can be stated as follows:\n" +
                        "\n" +
                        "Let P be any non-trivial property of Turing machines, meaning there exist two Turing machines M1 and M2 such that M1 possesses property P and M2 does not possess property P. Then the problem of deciding, given the description of a Turing machine M, whether M possesses property P (i.e., L(M) has property P) is undecidable.\n" +
                        "\n" +
                        "Here, a property is considered non-trivial if it is neither true for all Turing machines nor true for none of them. In other words, the property distinguishes between different Turing machines or languages.\n" +
                        "\n" +
                        "Rice's theorem has significant implications. It implies that many interesting properties of Turing machines, such as halting on a particular input, recognizing a specific language, or having a specific computational complexity, are undecidable. It demonstrates the inherent limitations of computational methods in solving certain questions about the behavior of Turing machines.\n" +
                        "\n" +
                        "The theorem is proven using a technique known as diagonalization. By constructing a Turing machine that can decide the property in question, one can create a new Turing machine that contradicts its own behavior, leading to a contradiction and establishing the undecidability of the property.\n" +
                        "\n" +
                        "Rice's theorem has broad applications in theoretical computer science. It helps define the boundaries of decidability and serves as a powerful tool for proving undecidability results in various areas, including programming language theory, formal methods, and the study of complexity classes. It highlights the complexity and richness of the behavior of Turing machines and contributes to our understanding of the limits of computation.")
                )
        itemList.add(
            PModel("Turing machines as rewriting systems and grammars","Turing machines can be viewed as rewriting systems or grammars in the context of formal languages and computational models. Let's explore these perspectives:\n" +
                    "\n" +
                    "Turing Machines as Rewriting Systems:\n" +
                    "In the rewriting system view, a Turing machine can be seen as a system that performs step-by-step transformations on an input string. The tape of the Turing machine serves as the working space where these transformations take place. Each transition of the Turing machine corresponds to a rewrite rule that specifies how the current symbol being read and the machine's state should be replaced. The rewriting process continues until the machine halts.\n" +
                    "This perspective highlights the computational power of Turing machines in terms of their ability to manipulate symbols and modify strings based on the specified rules. The rewriting system view allows us to analyze the behavior of Turing machines in terms of the sequences of symbol transformations they perform during computation.\n" +
                    "\n" +
                    "Turing Machines as Grammars:\n" +
                    "From a grammatical perspective, a Turing machine can be considered as a language-generating device. The transitions of the Turing machine can be seen as production rules that define the transformation of a given symbol or state into a sequence of symbols and states. These production rules resemble the rules of formal grammars, such as context-free grammars.\n" +
                    "In this view, the language recognized by a Turing machine corresponds to the set of strings generated by the grammar represented by its production rules. The Turing machine's initial state and the halting states can be seen as the start symbol and the non-terminal symbols of the grammar, respectively. The transitions define the rewriting rules that generate the strings in the language.\n" +
                    "\n" +
                    "This perspective allows us to analyze the languages recognized by Turing machines in terms of their grammatical properties. We can study the generative capacity of Turing machines by examining the types of languages they can produce, such as regular languages, context-free languages, or recursively enumerable languages.\n" +
                    "\n" +
                    "By viewing Turing machines as rewriting systems or grammars, we gain insights into their computational behavior and their relationships with other language-generating models. These perspectives provide formal frameworks for studying the properties and capabilities of Turing machines and contribute to our understanding of formal languages and computation.")
        )
        itemList.add(
            PModel("Other undecidable problems","In addition to Rice's theorem, which establishes the undecidability of properties of Turing machines, there are numerous other undecidable problems in various domains of computer science. Here are a few notable examples:\n" +
                    "\n" +
                    "Halting Problem: The Halting Problem is a classic undecidable problem that asks, given a Turing machine M and an input string w, whether M halts (reaches a halting state) when started on input w. Alan Turing first proved this problem to be undecidable in 1936. The proof relies on a clever self-referential argument and diagonalization.\n" +
                    "\n" +
                    "Post's Correspondence Problem: The Post's Correspondence Problem (PCP) is an undecidable problem in the domain of formal languages. Given a finite set of pairs of strings, the problem is to determine whether there exists a sequence of pairs such that concatenating the first strings in each pair is equal to concatenating the second strings. PCP was shown to be undecidable by Emil Post in 1946.\n" +
                    "\n" +
                    "The Word Problem for Groups: The Word Problem for Groups is the problem of determining, given a group G and two words w and v representing elements of G, whether w and v represent the same element. The general case of the Word Problem for Groups is undecidable, as proved by Pyotr Novikov and William Boone independently in 1955.\n" +
                    "\n" +
                    "The Entscheidungsproblem: The Entscheidungsproblem, translated as the \"decision problem\" in English, was one of the foundational questions in computer science and was posed by David Hilbert in 1928. It asks whether there exists an algorithm that can decide the truth or falsehood of any mathematical statement. In 1936, Alan Turing proved that the Entscheidungsproblem is undecidable.\n" +
                    "\n" +
                    "The Collatz Conjecture: The Collatz Conjecture, also known as the 3n + 1 problem, is an unsolved mathematical problem. The conjecture states that for any positive integer n, the sequence obtained by repeatedly applying the following rules will eventually reach the value 1: If n is even, divide it by 2; if n is odd, multiply it by 3 and add 1. While the conjecture is widely believed to be true, no general proof or counterexample has been found, making it an open problem.\n" +
                    "\n" +
                    "These examples illustrate the existence of undecidable problems in various branches of computer science and mathematics. They highlight the inherent limitations of computation and demonstrate that there are questions that cannot be answered algorithmically or mechanically. These undecidable problems form an essential part of the theory of computability and serve as a basis for understanding the boundaries of what can be computed.")
        )
        itemList.add(
            PModel("Post correspondence problem","The Post Correspondence Problem (PCP) is a classic undecidable problem in the field of formal languages and computability theory. It was introduced by Emil Post in 1946 as a way to demonstrate the existence of undecidable problems.\n" +
                    "\n" +
                    "The problem is defined as follows: Given a finite set of pairs of strings (also known as tiles), the task is to determine whether there exists a non-empty sequence of these pairs such that concatenating the first strings in each pair yields the same result as concatenating the second strings. In other words, we want to find a sequence of indices i1, i2, ..., ik such that the concatenation of the first strings of the corresponding pairs is equal to the concatenation of the second strings:\n" +
                    "\n" +
                    "w[i1]w[i2]...w[ik] = v[i1]v[i2]...v[ik]\n" +
                    "\n" +
                    "where w[i] and v[i] represent the first and second strings of the i-th pair, respectively.\n" +
                    "\n" +
                    "To illustrate the PCP, consider the following set of pairs:\n" +
                    "\n" +
                    "{(ab, baa), (b, aa), (ba, a)}\n" +
                    "\n" +
                    "In this case, there exists a sequence of indices {1, 1, 3} that satisfies the concatenation condition:\n" +
                    "\n" +
                    "abababa = baabaa\n" +
                    "\n" +
                    "Thus, the PCP is solvable for this particular set of pairs.\n" +
                    "\n" +
                    "However, the undecidability of the PCP lies in the fact that it is impossible to design a general algorithm that can determine whether a solution exists for any given set of pairs. This means that there is no effective procedure or algorithm that can solve the PCP for all inputs.\n" +
                    "\n" +
                    "The proof of undecidability for the PCP relies on reduction from other undecidable problems, such as the Halting Problem, and employs techniques such as diagonalization to construct a contradiction.\n" +
                    "\n" +
                    "The Post Correspondence Problem has played a significant role in the development of computability theory, as it was one of the earliest examples of an undecidable problem. It highlights the existence of fundamental limits in solving certain language-related problems algorithmically and contributes to our understanding of the boundaries of computability.")
        )
        itemList.add(
            PModel("Problems concerning context-free grammars","There are several interesting problems concerning context-free grammars (CFGs) that have been studied in the field of formal languages and automata theory. Here are a few notable ones:\n" +
                    "\n" +
                    "Membership Problem: Given a CFG and a string, the membership problem asks whether the given string belongs to the language generated by the CFG. This problem involves determining whether there exists a derivation in the CFG that produces the given string.\n" +
                    "\n" +
                    "Emptiness Problem: The emptiness problem for CFGs is to determine whether the language generated by a given CFG is empty, i.e., it does not contain any strings.\n" +
                    "\n" +
                    "Ambiguity Problem: The ambiguity problem deals with determining whether a given CFG is ambiguous, meaning it generates at least one string that can be derived in more than one way. Ambiguity can lead to multiple interpretations or meanings for the same string, which can complicate language processing.\n" +
                    "\n" +
                    "Equivalence Problem: The equivalence problem for CFGs asks whether two given CFGs generate the same language, i.e., they generate exactly the same set of strings. Determining the equivalence of CFGs can be challenging and has implications in compiler design, code optimization, and language processing.\n" +
                    "\n" +
                    "Reachability Problem: The reachability problem involves determining whether a specific non-terminal symbol in a CFG can be reached from the start symbol through a sequence of grammar rules. This problem is relevant for analyzing the usefulness of non-terminals and detecting dead or unreachable portions of the grammar.\n" +
                    "\n" +
                    "Closure Properties: Various closure properties of context-free languages are of interest. For example, the problem of closure under union, intersection, concatenation, complement, and Kleene star operations asks whether the result of applying these operations to two CFGs yields another CFG. These properties help establish relationships between different context-free languages.\n" +
                    "\n" +
                    "Parsing Problem: Parsing refers to the process of analyzing a string based on the grammar rules of a CFG to determine its structure or syntactic correctness. The parsing problem involves developing efficient algorithms for parsing strings according to a given CFG.\n" +
                    "\n" +
                    "These are just a few examples of the problems concerning context-free grammars. Each problem has its own complexities and may have different degrees of computational difficulty. The study of these problems contributes to our understanding of the expressive power, properties, and limitations of context-free languages and grammars.")
        )
        itemList.add(
            PModel(" Mortality of matrix products","The \"mortality\" of matrix products refers to the property of whether the product of two matrices is guaranteed to be a non-zero matrix. In other words, it asks whether there exists a pair of matrices whose product is always non-zero, regardless of the choice of matrices.\n" +
                    "\n" +
                    "The mortality of matrix products depends on the size and structure of the matrices involved. Here are a few key observations:\n" +
                    "\n" +
                    "Square Matrices: If both matrices are square matrices (i.e., having the same number of rows and columns), then the product can be a zero matrix. Consider the zero matrix multiplied by any non-zero matrix; the result will always be the zero matrix.\n" +
                    "\n" +
                    "Rectangular Matrices: If at least one matrix is a rectangular matrix (i.e., having a different number of rows and columns), then the product can still be a non-zero matrix. For example, if you multiply a non-zero column vector by a non-zero row vector, the resulting matrix will be non-zero.\n" +
                    "\n" +
                    "Non-Zero Determinants: If both matrices have non-zero determinants, then the product is guaranteed to be non-zero. This property holds for both square and rectangular matrices. The determinant of a matrix represents the scaling factor of the transformation induced by the matrix, and if the determinants of both matrices are non-zero, their product will also have a non-zero determinant.\n" +
                    "\n" +
                    "Overall, the mortality of matrix products depends on various factors such as the size, structure, and properties of the matrices involved. While there are cases where the product can be a zero matrix, there are also scenarios where the product is guaranteed to be non-zero. It is important to consider the specific properties and constraints of the matrices in question to determine the mortality of their products.")
        )
        itemList.add(
            PModel(" Tiling problems","Tiling problems refer to a class of combinatorial problems in which the goal is to cover a given region with a set of smaller tiles according to certain rules or constraints. These problems have applications in fields such as mathematics, computer science, and design. Here are a few notable tiling problems:\n" +
                    "\n" +
                    "Domino Tiling: In the domino tiling problem, the goal is to cover a rectangular grid with dominoes (2x1 tiles) without overlapping or leaving any gaps. The problem can be approached as finding a tiling arrangement that covers the entire grid or determining if a tiling is possible for a given grid.\n" +
                    "\n" +
                    "Wang Tiles: Wang tiles are square tiles with colored edges. In the Wang tiling problem, the objective is to cover an infinite plane (or a large region) with these tiles such that adjacent edges of the tiles have matching colors. The challenge is to find a tiling arrangement that satisfies the color-matching condition and potentially other constraints.\n" +
                    "\n" +
                    "Polyomino Tiling: Polyominoes are shapes formed by connecting unit squares along their edges. In the polyomino tiling problem, the task is to cover a given region (usually a rectangle) with a set of polyominoes without overlapping or leaving any gaps. This problem has various variations, including the problem of tiling a rectangle with a specific type of polyomino or finding the minimum number of polyominoes required to tile a given region.\n" +
                    "\n" +
                    "Penrose Tiles: Penrose tiles are a set of non-periodic tiles that can be used to cover a plane without creating a repetitive pattern. The Penrose tiling problem involves finding a way to cover a plane with these tiles, adhering to specific matching rules. Penrose tiles are notable for their aperiodic properties, meaning they do not exhibit translational symmetry.\n" +
                    "\n" +
                    "Solving tiling problems often requires creative problem-solving techniques, combinatorial algorithms, and mathematical reasoning. These problems have connections to areas such as graph theory, computational geometry, and pattern recognition. Tiling problems also offer insights into the study of symmetry, tessellations, and the aesthetics of tile arrangements.")
        )
        itemList.add(
            PModel(" Undecidability and incompleteness in arithmetics","Undecidability and incompleteness are fundamental concepts in the field of mathematical logic and they have significant implications in the study of arithmetic and formal systems. Let's explore each concept:\n" +
                    "\n" +
                    "Undecidability: In the context of arithmetic, undecidability refers to the existence of mathematical statements or problems that cannot be solved by an algorithm or mechanical procedure. This means that there is no algorithm that can determine the truth or falsehood of all arithmetic statements.\n" +
                    "One of the most famous undecidable problems in arithmetic is the Halting Problem. It asks whether a given program, when provided with a specific input, will halt or run indefinitely. Alan Turing proved in 1936 that the Halting Problem is undecidable, meaning there is no algorithm that can decide whether an arbitrary program halts or not.\n" +
                    "\n" +
                    "The undecidability of the Halting Problem has far-reaching consequences, as it shows that there are fundamental limitations to what can be computed or determined algorithmically.\n" +
                    "\n" +
                    "Incompleteness: Incompleteness refers to the property of a formal system that cannot prove or disprove all true statements within the system. In 1931, Kurt Gödel proved his famous incompleteness theorems, which demonstrated that any formal system capable of expressing arithmetic is either inconsistent (meaning it can prove both a statement and its negation) or incomplete (meaning there are true statements that cannot be proven or disproven within the system).\n" +
                    "Gödel's first incompleteness theorem states that in any consistent formal system capable of expressing arithmetic, there exists a true statement that cannot be proven within the system itself. This implies that there are inherent limitations to what can be proven using formal axiomatic systems.\n" +
                    "\n" +
                    "Gödel's second incompleteness theorem states that no consistent formal system capable of expressing arithmetic can prove its own consistency. This means that, in such a system, it is impossible to prove that the system itself does not contain contradictions.\n" +
                    "\n" +
                    "The incompleteness theorems shattered the hopes of finding a complete and consistent formal system for arithmetic. They showed that there will always be true statements about arithmetic that cannot be proven within any formal system.\n" +
                    "\n" +
                    "The concepts of undecidability and incompleteness highlight the inherent limitations of formal systems and the boundaries of what can be proven or computed. They have profound implications in various areas of mathematics, logic, computer science, and philosophy, shaping our understanding of the nature and limits of mathematical reasoning.")
        )
        itemList.add(
            PModel(" Computable functions and reducibility","Computable functions and reducibility are key concepts in computability theory, which studies the fundamental limitations and capabilities of computational systems. Let's explore each concept:\n" +
                    "\n" +
                    "Computable Functions: A function is considered computable if there exists an algorithm or computational procedure that can compute the function's output for any given input. In other words, a function is computable if there is a systematic and mechanical way to compute its values.\n" +
                    "The concept of computability is closely tied to Turing machines, which are abstract models of computation. A function is said to be Turing computable if it can be computed by a Turing machine. This notion of computability serves as a foundation for understanding what can be algorithmically computed.\n" +
                    "\n" +
                    "Not all functions are computable. There are functions that are mathematically defined but do not have corresponding algorithms that can compute their values for all inputs. The existence of non-computable functions highlights the limits of computation.\n" +
                    "\n" +
                    "Reducibility: Reducibility is a concept used to compare the computational difficulty of different problems or functions. If problem A can be reduced to problem B, it means that an algorithm for solving problem B can be used to solve problem A.\n" +
                    "Formally, reducibility is defined in terms of a mapping between instances of two problems. If there exists an algorithm that can transform instances of problem A into instances of problem B in a computable way, such that the solution to problem B can be used to solve problem A, then problem A is reducible to problem B.\n" +
                    "\n" +
                    "Reductions are often used to establish the relative computational hardness or complexity of problems. For example, if problem A is known to be computationally difficult, and problem B is reducible to problem A, then problem B is at least as difficult as problem A.\n" +
                    "\n" +
                    "Reductions are classified into various types, such as polynomial-time reductions and many-one reductions, depending on the computational resources used and the nature of the reduction. They provide a means to analyze the relationships between different computational problems and to classify their complexity.\n" +
                    "\n" +
                    "Reducibility also plays a crucial role in the theory of NP-completeness, where problems are classified based on their computational difficulty within the class of problems known as NP (nondeterministic polynomial time).\n" +
                    "\n" +
                    "Overall, the concepts of computable functions and reducibility are fundamental in understanding the limits of computation and the relationships between different computational problems. They form the basis for studying computational complexity, algorithmic analysis, and the classification of problems based on their computational difficulty.")
        )
        itemList.add(
            PModel("Some other universal models of computation","\n" +
                    "In addition to Turing machines, there are several other universal models of computation that have been proposed and studied in the field of theoretical computer science. These models share the characteristic of being able to simulate any other computational model or algorithm. Here are a few notable examples:\n" +
                    "\n" +
                    "Lambda Calculus: Lambda calculus, developed by Alonzo Church, is a formal system based on function abstraction and application. It provides a foundation for studying computable functions and has been influential in the development of functional programming languages. The lambda calculus can express any computable function and is considered Turing complete, making it a universal model of computation.\n" +
                    "\n" +
                    "Register Machines: Register machines are abstract computational devices that operate on a set of registers, each capable of storing a value. They are similar to Turing machines but operate in a different manner. Register machines have been shown to be equivalent in computational power to Turing machines and can simulate any Turing machine and vice versa.\n" +
                    "\n" +
                    "Cellular Automata: Cellular automata are discrete models that consist of a grid of cells, each having a finite number of states. The cells update their states based on local rules and interactions with neighboring cells. While cellular automata are often studied for their emergent and self-organizing behavior, certain types of cellular automata, such as the Game of Life, have been shown to be capable of universal computation.\n" +
                    "\n" +
                    "Recursive Functions: Recursive functions, also known as μ-recursive functions, are a mathematical model of computation introduced by Stephen Kleene. They are defined using a set of basic functions and three operations: composition, primitive recursion, and unbounded minimization. Recursive functions capture the notion of computability and can express any computable function, making them a universal model of computation.\n" +
                    "\n" +
                    "Petri Nets: Petri nets are graphical models used to describe the behavior and interactions of concurrent systems. They consist of a set of places, transitions, and arcs connecting them. Petri nets are capable of modeling various types of systems and processes, and certain classes of Petri nets have been shown to be Turing complete, making them universal models of computation.\n" +
                    "\n" +
                    "These are just a few examples of alternative universal models of computation. Each model has its own characteristics and strengths, and they provide different perspectives on computation and computational complexity. Studying these models helps deepen our understanding of the theoretical foundations of computation and the capabilities of different computational systems.")
        )
        itemList.add(
            PModel("Counter machines","Counter machines are a type of abstract computational model that operate based on a set of counters, which are non-negative integer variables. These machines are simple yet powerful and have been widely studied in the field of theoretical computer science. Let's explore the basics of counter machines:\n" +
                    "\n" +
                    "Components of Counter Machines:\n" +
                    "\n" +
                    "Counters: A counter machine has a finite set of counters, each of which holds a non-negative integer value. The values of counters can be incremented, decremented, or tested for zero.\n" +
                    "\n" +
                    "Instructions: Counter machines operate based on a set of instructions that specify the actions to be performed on counters. The instructions typically include operations such as incrementing or decrementing a counter, conditional branching based on the value of a counter, and halting the machine.\n" +
                    "\n" +
                    "Control Unit: The control unit of a counter machine controls the execution of instructions. It determines which instruction to execute next based on the current state of the machine and the values of the counters.\n" +
                    "\n" +
                    "Working of Counter Machines:\n" +
                    "Counter machines execute instructions sequentially, starting from an initial state. The control unit fetches an instruction, performs the specified operation on the counters, updates the state, and moves to the next instruction. The execution continues until a halting instruction is encountered.\n" +
                    "\n" +
                    "The power of counter machines lies in their ability to simulate other computational models, such as Turing machines. Counter machines can perform arithmetic computations, iterate over loops, and implement decision-making processes. They are capable of expressing a wide range of algorithms and can solve various computational problems.\n" +
                    "\n" +
                    "Complexity of Counter Machines:\n" +
                    "Counter machines are powerful computational models, but they have their limitations. They operate on a finite number of counters, and the size of the counters is finite. Therefore, counter machines are classified as a class of linear-bounded automata, which means that the amount of memory they can use is limited to a linear function of the input size.\n" +
                    "\n" +
                    "Counter machines can solve decision problems in a time complexity that is at most exponential in the input size. However, they cannot solve all computational problems efficiently. For example, some problems that require unbounded memory, such as the halting problem for Turing machines, are not solvable by counter machines.\n" +
                    "\n" +
                    "Counter machines have been extensively studied and serve as a fundamental model in the theory of computation. They provide insights into the complexity of algorithms, the boundaries of computational power, and the relationship between different computational models.")
        )
        itemList.add(
            PModel(" Fractran","Fractran is a simple programming language and computational model created by John Conway, the mathematician known for his work on cellular automata and the Game of Life. Fractran is a unique language that uses fractions to perform computations. Let's explore the basics of Fractran:\n" +
                    "\n" +
                    "Program Structure: A Fractran program consists of a set of fractions, each representing an instruction. These fractions are written as a/b, where a and b are positive integers. The program is defined by an initial input integer.\n" +
                    "\n" +
                    "Execution: To execute a Fractran program, the initial input integer is multiplied by each fraction in the program until no further multiplication is possible. The resulting integer is the output of the program.\n" +
                    "\n" +
                    "Instruction Execution: To execute an instruction (fraction), the program checks if the current input integer is divisible by the numerator (a) of the fraction. If it is, the current input integer is multiplied by the fraction and the resulting product becomes the new input integer. If not, the program moves on to the next instruction.\n" +
                    "\n" +
                    "Program Termination: A Fractran program terminates if no further multiplication is possible, meaning that none of the fractions in the program are divisible by the current input integer.\n" +
                    "\n" +
                    "Fractran is a Turing complete language, meaning it can simulate any computation that can be performed by a Turing machine. Despite its simplicity, Fractran has been shown to be capable of performing complex computations, including prime number generation and simulating other computational models.\n" +
                    "\n" +
                    "Fractran programs are highly dependent on the choice of fractions. The selection and arrangement of fractions determine the behavior and output of the program. Designing Fractran programs for specific computations often involves careful mathematical analysis and understanding of number theory.\n" +
                    "\n" +
                    "Fractran provides a fascinating example of how a seemingly simple language based on fractions can exhibit computational universality and perform non-trivial computations. It serves as a unique and intriguing area of study in the field of computational theory.")
        )
        itemList.add(
            PModel("Tag systems","Tag systems are simple computational models that consist of a string of symbols and a set of production rules. They are considered a type of formal system and have been studied in the field of theoretical computer science. Let's explore the basics of tag systems:\n" +
                    "\n" +
                    "Components of Tag Systems:\n" +
                    "\n" +
                    "Tape: The tape in a tag system is a string composed of symbols from a finite alphabet. The tape serves as the input to the system and is manipulated by the production rules.\n" +
                    "\n" +
                    "Production Rules: Tag systems operate based on a set of production rules. Each rule consists of a pattern and a corresponding replacement. The pattern specifies a sequence of symbols on the tape, and the replacement indicates how the pattern should be modified.\n" +
                    "\n" +
                    "Working of Tag Systems:\n" +
                    "The tag system operates iteratively, applying production rules to the tape. At each step, the system examines a portion of the tape determined by the pattern of a production rule. If the examined portion of the tape matches the pattern, it is replaced with the corresponding replacement.\n" +
                    "\n" +
                    "The system continues iterating until either a halting condition is met or the tape becomes empty. The resulting tape or the halting condition provides the output of the tag system.\n" +
                    "\n" +
                    "Applications and Variations:\n" +
                    "Tag systems have been used to explore the concepts of computational universality and undecidability. They are simple yet powerful enough to simulate other computational models, such as Turing machines.\n" +
                    "\n" +
                    "One well-known variation of tag systems is the Post Tag System, introduced by Emil Post. In a Post Tag System, the production rules can be applied to any position on the tape, not just the beginning. This additional flexibility allows for more complex computations and behaviors.\n" +
                    "\n" +
                    "Tag systems are also used in the field of algorithmic information theory to study the concept of complexity and information content in strings.\n" +
                    "\n" +
                    "While tag systems are computationally powerful, they have certain limitations. For example, they are not suitable for solving problems that require large amounts of memory or complex data structures.\n" +
                    "\n" +
                    "In summary, tag systems are simple computational models that operate based on production rules applied to a string of symbols. They provide insights into the concept of computation and have applications in the study of computational universality and algorithmic information theory." +
                    "Computational Power: Tag systems are capable of universal computation, meaning they can simulate any Turing machine computation. This universality makes them equivalent in power to other well-known computational models like Turing machines or cellular automata.\n" +
                    "\n" +
                    "Halting Problem: Similar to other computational models, tag systems face undecidability issues. It is undecidable to determine whether a given tag system will halt or continue indefinitely on a particular input. This is analogous to the halting problem for Turing machines.\n" +
                    "\n" +
                    "Complexity and Variants: Tag systems can exhibit various levels of complexity depending on the number of production rules, the size of the alphabet, and the specific patterns and replacements allowed. Certain variants, such as Two-Tag Systems or Collatz Tag Systems, have been extensively studied to understand their computational behavior and complexity.\n" +
                    "\n" +
                    "Fractal Patterns: Tag systems can produce intriguing fractal patterns. As the production rules iteratively modify the tape, the resulting sequence of symbols can exhibit self-similar and recursive patterns. This connection to fractals adds to the aesthetic and mathematical appeal of tag systems.\n" +
                    "\n" +
                    "Research and Applications: Tag systems have been studied for their theoretical properties and connections to other areas of mathematics and computer science. They serve as a tool for exploring the limits of computation and investigating the behavior of simple yet powerful computational models.\n" +
                    "\n" +
                    "It's worth noting that while tag systems are fascinating from a theoretical standpoint, they are not commonly used as practical computational models in real-world applications. Their main significance lies in their contributions to theoretical computer science, computability theory, and the understanding of complex systems and patterns.\n" +
                    "\n")
        )





        adapter = PAdapter(itemList)
        recyclerView.adapter = adapter



    }












}